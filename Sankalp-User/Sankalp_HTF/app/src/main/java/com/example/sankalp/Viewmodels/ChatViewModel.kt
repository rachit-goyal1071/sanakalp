package com.example.sankalp.Viewmodels

import android.content.Context
import android.service.autofill.UserData
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sankalp.Models.Category
import com.example.sankalp.Models.Song
import com.example.sankalp.utils.USER_NODE
import com.example.sankalp.utils.userData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.sign

@HiltViewModel
class ChatViewModel @Inject constructor(val auth: FirebaseAuth, var db: FirebaseFirestore) :
    ViewModel() {
    var inProgress = mutableStateOf(false)
    var signIn = mutableStateOf(false)
    val userkaData = mutableStateOf<userData?>(null)
    private val _categories = MutableStateFlow<List<Category>>(emptyList())
    val categories: MutableStateFlow<List<Category>> = _categories


    init {
        val currentUser = auth.currentUser
        signIn.value = currentUser != null
        currentUser?.uid.let {
            getUserData(it.toString())
        }

    }

    fun signupLogin() {
        inProgress.value = true
        auth.signInAnonymously().addOnCompleteListener {
            if (it.isSuccessful) {
                signIn.value = true
                Log.d("idk", "success")
                inProgress.value = false
                createUserDb()
            } else {
                Log.d("idk", "Failed")
                inProgress.value = false
            }
        }
    }

    fun createUserDb(name: String? = null) {
        val uid = auth.currentUser?.uid
        Log.d("idk", "user id : $uid")
        val UserData = userData(
            userId = uid,
            name = name
        )
        uid.let {
            inProgress.value = true
            db.collection(USER_NODE).document(uid.toString()).get().addOnSuccessListener {
                if (it.exists()) {

                } else {
                    db.collection(USER_NODE).document(uid.toString()).set(UserData)
                    inProgress.value = false
                    getUserData(uid.toString())
                }
            }.addOnFailureListener {
                Log.d("idk", "failure in db something")
            }
        }
    }


    private fun getUserData(uid: String) {
        inProgress.value = true
        db.collection(USER_NODE).document(uid).addSnapshotListener { value, error ->
            if (error != null) {
                Log.d("idk", "snapshot error viewmodel")
            }
            if (value != null) {
                var user = value.toObject<userData>()
                userkaData.value = user
                inProgress.value = false

            }

        }
    }


    fun fetchSongs() {
        val categoriesCollection = db.collection("categories")
        categoriesCollection.addSnapshotListener { value, error ->
            if (error != null) {
                Log.e("Firestore", "Error fetching categories: $error")
                return@addSnapshotListener
            }
            value?.let { snapshot ->
                viewModelScope.launch {
                    val categoriesvm = snapshot.documents.mapNotNull { categoryDocument ->
                        val categoryName = categoryDocument.getString("title") ?: ""
                        val songNames =
                            categoryDocument.get("songArray") as? List<String> ?: emptyList()
                        val coverUrl = categoryDocument.getString("coverUrl") ?: ""

                        // Create Category object
                        Category(coverUrl, categoryName, songNames)
                    }
                    Log.d("idk",categoriesvm.toString())
                    _categories.value = categoriesvm

                }
            }
        }
    }
}
//            value?.documents?.forEach { categoryDocument ->
//                val categoryName = categoryDocument.getString("title") ?: ""
////                val songsArray = categoryDocument.get("songarray") as? List<HashMap<String, Any>> ?: emptyList()
//                val songNames = categoryDocument.get("songArray") as? List<String> ?: emptyList()
//                val coverUrl = categoryDocument.getString("coverUrl") ?: "" // Fetch coverUrl
//                Log.d("catName", categoryName)
//                Log.d("catName", songNames.toString())
////                val songList = songsArray.map { songMap ->
////                    val title = songMap["title"] as? String ?: ""
////                    val songUrl = songMap["songUrl"] as? String ?: ""
////                    Song(title, songUrl)
//            Log.d("idk", categoryDocument.toString())
//                }

//                _categories.value = listOf(Category(coverUrl, categoryName, songNames))

//            }
//            Log.d("idk", _categories.value.toString())
//            return@addSnapshotListener categories
//        }
//            onDispose {
//                listenerRegistration.remove()
//            }
//        }
