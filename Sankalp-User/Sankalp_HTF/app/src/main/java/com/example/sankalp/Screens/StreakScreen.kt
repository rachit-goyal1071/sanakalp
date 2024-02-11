package com.example.sankalp.Screens

import android.media.MediaPlayer
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import com.example.sankalp.Components.BottomNavItem
import com.example.sankalp.Components.BottomNavigationMenu
import com.example.sankalp.DoctorPage.CardData
import com.example.sankalp.DoctorPage.ImageListItem
import com.example.sankalp.Models.Category
import com.example.sankalp.R
import com.example.sankalp.Viewmodels.ChatViewModel
import com.example.sankalp.navigation.Destinations
import com.example.sankalp.ui.theme.customColor
import com.example.sankalp.ui.theme.notoFontFamily
import com.example.sankalp.utils.navigatTO
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import java.io.IOException

@Composable
fun StreakScreen(navController: NavController, vm: ChatViewModel) {
    val firestore = FirebaseFirestore.getInstance()
    val items by vm.categories.collectAsState()
    val songsCollection = firestore.collection("songs") // Assuming a separate collection for songs
    var selectedCategory = remember { mutableStateOf<Category?>(null) }
//    var selectedCategory = remember { mutableStateOf }
    val selectedItems = remember { derivedStateOf { selectedCategory.value?.songArray } }

    val context = LocalContext.current
//    val categories = remember { mutableStateListOf<Category>() }

//    var selectedCategory by remember { mutableStateOf(categories[1]) }
//    val selectedItems: List<Song> by remember{ derivedStateOf { (selectedCategory.songArray)} }
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
            Box(
                modifier = Modifier
                    .height(425.dp)
                    .fillMaxWidth()
                    .background(customColor.Secondary)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(10.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier.padding(start = 10.dp),
                        text = "Streak",
                        fontSize = 30.sp,
                        fontFamily = notoFontFamily,
                        color = customColor.DelftBlue
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "2",
                            fontSize = 40.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = customColor.RussianViolet
                        )
                        Image(
                            modifier = Modifier.size(60.dp),
                            painter = painterResource(id = R.drawable.flame),
                            contentDescription = null
                        )
                    }
                    Text(
                        text = "Streak Days",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = customColor.RussianViolet
                    )
                    Row {
                        Text(
                            text = "You have came this far,\n keep going champ..!!",
                            fontFamily = notoFontFamily,
                            color = customColor.DelftBlue
                        )
                        Spacer(modifier = Modifier.size(20.dp))
                        Button(
                            onClick = {
                                Toast.makeText(
                                    context,
                                    "You have already marked today's streak",
                                    Toast.LENGTH_SHORT
                                ).show();
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = customColor.Beige)
                        ) {
                            Text(text = "Mark Streak", color = customColor.DelftBlue)
                        }

                    }
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                    ) {
                        item {
                            Image(
                                painter = painterResource(id = R.drawable.badge1),
                                contentDescription = null
                            )
                        }
                        item {
                            Image(
                                painter = painterResource(id = R.drawable.badge4),
                                contentDescription = null
                            )
                        }
                        item {
                            Image(
                                painter = painterResource(id = R.drawable.badge2),
                                contentDescription = null
                            )
                        }
                        item {
                            Image(
                                painter = painterResource(id = R.drawable.badge3),
                                contentDescription = null
                            )
                        }
                    }
                }
            }
//            Button(onClick = {
//                vm.fetchSongs()
//                Log.d("idk", items.toString())
//            }) {
//            }
//            Row {
//                Text(text = "Explore Meditation")
//                OutlinedButton(onClick = {
//                    vm.fetchSongs()
//                    navigatTO(navController, Destinations.Meditation.route)
//                }) {
//                    Text(text = "GO there")
//                }
//            }
            val images = listOf(
                CardData(R.drawable.counsellor, "Therapy"),
                CardData(R.drawable.physicist, "Sleep"),
                CardData(R.drawable.psycologist, "Relax"),
            )
            Column {
                Spacer(modifier = Modifier.size(15.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.padding(start = 10.dp),
                        text = "Explore Meditation",
                        fontFamily = notoFontFamily,
                        color = Color.Black,
                        fontSize = 20.sp
                    )
                    OutlinedButton(onClick = {
                        vm.fetchSongs()
                        navigatTO(navController, Destinations.Meditation.route)
                    }, modifier = Modifier.padding(end = 10.dp)) {
                        Text(text = "Go there", color = Color.Black)
                        Spacer(modifier = Modifier.size(10.dp))
                        Icon(
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = null,
                            tint = customColor.DelftBlue
                        )
                    }
                }
                LazyRow() {
                    items(images.size) { index ->
                        ImageListItem(imageData = images[index])
                    }
                }
            }
        }
    }
}

@Composable
fun CategoryItem(category: Category, selectedCategory: MutableState<Category?>) {
    val painter = rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current).data(data = category.coverUrl)
            .apply(block = fun ImageRequest.Builder.() {
                scale(Scale.FILL)
            }).build()
    )
    Column(
        modifier = Modifier
            .height(intrinsicSize = IntrinsicSize.Max)
//            .fillMaxWidth()
            .padding(5.dp)
            .clickable {
                selectedCategory.value = category
//                selectedCategory = category
            }
    ) {
        Text(
            text = category.title,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(8.dp))
        Image(
            painter = painter,
            contentDescription = null, // Handle accessibility
            modifier = Modifier
                .height(200.dp)
                .width(100.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp))
//        LazyColumn {
//            items(category.songArray) { songUrl ->
//                SongItem(songUrl)
//            }
//        }
    }
}


fun playSong(songUrl: String) {
    val mediaPlayer = MediaPlayer()
    try {
        mediaPlayer.setDataSource(songUrl)
        mediaPlayer.prepare()
        mediaPlayer.start()
        // Optionally, you can handle playback completion or errors
        mediaPlayer.setOnCompletionListener { mp ->
            // Handle playback completion
            mp.release()
        }

        mediaPlayer.setOnErrorListener { mp, what, extra ->
            // Handle playback error
            mp.release()
            true
        }
    } catch (e: IOException) {
        e.printStackTrace()
    }

}
