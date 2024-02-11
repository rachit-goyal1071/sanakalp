package com.example.sankalp.MainScreen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sankalp.Components.BottomNavItem
import com.example.sankalp.Components.BottomNavigationMenu
import com.example.sankalp.Components.ChatRow
import com.example.sankalp.R
import com.example.sankalp.navigation.Destinations
import com.example.sankalp.ui.theme.customColor
import com.example.sankalp.ui.theme.notoFontFamily
import com.example.sankalp.utils.navigatTO

@Composable
fun ChatPage(navController: NavController) {
    val context = LocalContext.current

    Scaffold(bottomBar = {
        BottomNavigationMenu(selectedItem = BottomNavItem.CHAT, navController = navController)
    }, floatingActionButton = {
        Icon(imageVector = Icons.Default.Add, contentDescription = null)
    }) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.White)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .padding(20.dp)
                    .background(Color.White),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = customColor.DelftBlue,
                    modifier = Modifier.size(30.dp)
                )
                Icon(
                    Icons.Default.Notifications,
                    contentDescription = null,
                    tint = customColor.DelftBlue,
                    modifier = Modifier.size(30.dp)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .padding(start = 10.dp)
                    .background(Color.White),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "Inbox",
                    fontFamily = notoFontFamily,
                    color = customColor.DelftBlue,
                    fontSize = 25.sp
                )
            }
            ChatRow(name = "World Connect", image = R.drawable.flame) {
                navigatTO(navController, route = Destinations.SingleChatScreen.route)
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            }
            ChatRow(name = "Muskaan Foundation", image = R.drawable.muskaan) {
                navigatTO(navController, route = Destinations.SingleChatScreen.route)
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            }
            ChatRow(name = "Goonj Foundation", image = R.drawable.stairs) {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            }
            ChatRow(name = "Weekly Feedback", image = R.drawable.logo) {
                navigatTO(navController, route = Destinations.SingleChatScreen.route)
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }
}