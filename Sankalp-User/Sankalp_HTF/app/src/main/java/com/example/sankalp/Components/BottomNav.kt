package com.example.sankalp.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sankalp.R
import com.example.sankalp.navigation.Destinations
import com.example.sankalp.ui.theme.customColor
import com.example.sankalp.utils.navigatTO

enum class BottomNavItem(
    val icon: Int,
    val title: String,
    val navDestination: Destinations
) {
    CHAT(R.drawable.home, "Home", Destinations.ChatScreen),
    REELS(R.drawable.daily, "Daily", Destinations.ReelsScreen),
    OTHER(R.drawable.video, "Consult", Destinations.DoctorScreen),
    STREAK(R.drawable.tracking, "Tracking", Destinations.StreakScreen),
}


@Composable
fun BottomNavigationMenu(
    selectedItem: BottomNavItem,
    navController: NavController
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(customColor.sabseLightColor),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (item in BottomNavItem.entries) {
            Column(
                modifier = Modifier
                    .clickable {
                        navigatTO(navController, item.navDestination.route)
                    }
                    .padding(5.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painterResource(id = item.icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
//                        .clickable {
//                            navigatTO(navController, item.navDestination.route)
//                        }
                    , colorFilter = if (item == selectedItem) {
                        ColorFilter.tint(Color.Black)
                    } else {
                        ColorFilter.tint(Color.Gray)
                    }
                )
                Text(
                    text = item.title, color = if (item == selectedItem) {
                        Color.Black
                    } else {
                        Color.Gray
                    }
                )
            }
        }
    }
}