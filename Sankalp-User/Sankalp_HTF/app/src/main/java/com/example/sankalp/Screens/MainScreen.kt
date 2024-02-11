package com.example.sankalp.Screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sankalp.Components.BottomNavItem
import com.example.sankalp.Components.BottomNavigationMenu
import com.example.sankalp.Components.ChatRow
import com.example.sankalp.R
import com.example.sankalp.Viewmodels.ChatViewModel
import com.example.sankalp.navigation.Destinations
import com.example.sankalp.ui.theme.customColor
import com.example.sankalp.ui.theme.notoFontFamily
import com.example.sankalp.utils.navigatTO


@Composable
fun ChatScreen(navController: NavController, vm: ChatViewModel) {
    Scaffold(bottomBar = {
        BottomNavigationMenu(selectedItem = BottomNavItem.CHAT, navController = navController)
    }) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.White)
        ) {
            Spacer(modifier = Modifier.size(10.dp))
            Row (modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
                Image(
                    modifier = Modifier.size(70 .dp),
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null
                )
                Text(
                    text = "Don't Give Up !",
                    color = customColor.DelftBlue,
                    fontSize = 30.sp,
                    fontFamily = notoFontFamily
                )
            }
        Spacer(modifier = Modifier.size(20.dp))
        Divider(modifier = Modifier.fillMaxWidth(), thickness = 1.dp, color = customColor.Beige)
        Spacer(modifier = Modifier.size(20.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Stay Motivated !!",
                fontFamily = notoFontFamily,
                color = customColor.DelftBlue,
                fontSize = 25.sp
            )
            Spacer(modifier = Modifier.size(25.dp))
            Icon(
                painter = painterResource(id = R.drawable.baseline_sports_gymnastics_24),
                contentDescription = null, tint = customColor.DelftBlue
            )

        }
        QuoteCarousel()
        Spacer(modifier = Modifier.size(20.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(10.dp)
                .border(1.dp, shape = RoundedCornerShape(5.dp), color = customColor.DelftBlue)
                .clip(RoundedCornerShape(5.dp))
                .background(customColor.Beige)
        ) {
            Column {
                Text(
                    text = "Connect with the world!!",
                    fontFamily = notoFontFamily,
                    fontSize = 25.sp,
                    color = customColor.DelftBlue
                )
                Button(
                    modifier = Modifier.offset(x = 200.dp),
                    onClick = {
                        navigatTO(navController, Destinations.ChatPage.route)
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = customColor.DelftBlue)
                ) {
                    Text(text = "view all", color = Color.White)
                    Spacer(modifier = Modifier.size(5.dp))
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }

        }

    }
}
}



@Composable
fun QuoteCarousel() {
    LazyRow() {
        item {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(5.dp)
                    .clip(RoundedCornerShape(15.dp)),
                painter = painterResource(id = R.drawable.quote1),
                contentDescription = null
            )
        }
        item {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(5.dp)
                    .clip(RoundedCornerShape(15.dp)),
                painter = painterResource(id = R.drawable.quote2),
                contentDescription = null
            )

        }
    }
}
//        item {
//            OutlinedCard(
//                colors = CardDefaults.cardColors(containerColor = customColor.FrenchGrey),
//                shape = RoundedCornerShape(5.dp),
//                modifier = Modifier
//                    .width(300.dp)
//                    .height(150.dp)
//                    .padding(10.dp)
//
//            )
//            {
//                Column(
//                    modifier = Modifier.size(150.dp),
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.SpaceEvenly
//                ) {
//                    Image(
//                        painter = painterResource(id = R.drawable.quote1),
//                        contentDescription = null
//                    )
////                        Text(
////                            fontSize = 15.sp,
////                            text = "Physicist",
////                            color = Color.Black
////                        )
//
//                }
//            }
//        }
//    }
//}
