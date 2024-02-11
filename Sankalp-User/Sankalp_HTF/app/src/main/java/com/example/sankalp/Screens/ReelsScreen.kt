package com.example.sankalp.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.sankalp.Components.BottomNavItem
import com.example.sankalp.Components.BottomNavigationMenu
import com.example.sankalp.Reels.ReelsView
import com.example.sankalp.Viewmodels.ChatViewModel

@Composable
fun ReelsScreen(navController: NavController, vm: ChatViewModel) {
    Scaffold(bottomBar = {
        BottomNavigationMenu(selectedItem = BottomNavItem.REELS, navController = navController)
    }) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.White)
        ) {
            ReelsView()
        }
    }
}