package com.example.sankalp.Components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sankalp.Models.Category
import com.example.sankalp.R
import com.example.sankalp.Screens.CategoryItem
import com.example.sankalp.Screens.playSong
import com.example.sankalp.Viewmodels.ChatViewModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

@Composable
fun Meditation(navController: NavController,vm:ChatViewModel) {
    val firestore = FirebaseFirestore.getInstance()
    val items by vm.categories.collectAsState()
    val songsCollection = firestore.collection("songs") // Assuming a separate collection for songs
    var selectedCategory = remember { mutableStateOf<Category?>(null) }
    val selectedItems = remember { derivedStateOf { selectedCategory.value?.songArray } }

    val context = LocalContext.current

    var songTitle by remember { mutableStateOf("") }
    var songUrl by remember { mutableStateOf("") }


    Scaffold(bottomBar = {
        BottomNavigationMenu(selectedItem = BottomNavItem.STREAK, navController = navController)
    }) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.White)
        ) {
            LazyRow {
                items(items) { category ->
                    Log.d("idk", category.toString())
                    CategoryItem(category, selectedCategory)
                }
            }
            selectedCategory.value?.let { selCategory ->
                LazyColumn() {
                    items(selCategory.songArray) { song ->
                        LaunchedEffect(Unit) {
                            val songDocument = songsCollection.document(song).get().await()
                            Log.d("idkk", songDocument.toString())
                            if (songDocument.exists()) {
                                songTitle = songDocument.getString("title") ?: ""
                                songUrl = songDocument.getString("songUrl") ?: ""
                            }
                        }
                        Card(
                            border = BorderStroke(0.5.dp, Color.Black),
                            modifier = Modifier
                                .height(intrinsicSize = IntrinsicSize.Max)
                                .width(125.dp)
                                .padding(start = 5.dp, end = 5.dp),
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.test),
                                contentDescription = null
                            )
                            Text(text = songTitle)
                            Button(onClick = { playSong(songUrl) }) {
                                Text("Play $songTitle")
                            }

                        }
                    }
//            selectedCategory.value?.let { selCategory ->


//                    }
                }

            }
        }
    }
}