package com.example.sankalp.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sankalp.Components.BottomNavItem
import com.example.sankalp.Components.BottomNavigationMenu
import com.example.sankalp.DoctorPage.DoctorComposable
import com.example.sankalp.DoctorPage.EventsComposable
import com.example.sankalp.DoctorPage.NgoSection
import com.example.sankalp.Viewmodels.ChatViewModel
import com.example.sankalp.ui.theme.customColor
import com.example.sankalp.ui.theme.notoFontFamily
import com.example.sankalp.ui.theme.poppinsFontFamily
import com.google.android.exoplayer2.text.span.HorizontalTextInVerticalContextSpan


@Composable
fun DoctorScreen(navController: NavController, vm: ChatViewModel) {
    Scaffold(bottomBar = {
        BottomNavigationMenu(selectedItem = BottomNavItem.OTHER, navController = navController)
    },
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(customColor.Beige),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Place,
                    contentDescription = null,
                    tint = customColor.DelftBlue
                )
                Text(
                    fontFamily = notoFontFamily,
                    text = "Gandhinagar",
                    color = customColor.DelftBlue
                )
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    tint = customColor.DelftBlue
                )
            }
        }) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .background(Color.White)
                .fillMaxSize()
        ) {
            item {
                DoctorComposable(navController)
                 NgoSection()
//                EventsComposable()
            }
        }
    }
}


