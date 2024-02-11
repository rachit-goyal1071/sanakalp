package com.example.sankalp.DoctorPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sankalp.Components.BottomNavItem
import com.example.sankalp.Components.BottomNavigationMenu
import com.example.sankalp.R
import com.example.sankalp.navigation.Destinations
import com.example.sankalp.ui.theme.customColor
import com.example.sankalp.ui.theme.notoFontFamily
import com.example.sankalp.ui.theme.poppinsFontFamily
import com.example.sankalp.utils.navigatTO

data class CardData(val resourceId: Int, val name: String)

@Composable
fun DoctorComposable(navController: NavController) {

    val images = listOf(
        CardData(R.drawable.counsellor, "Counsellor"),
        CardData(R.drawable.physicist, "Physicist"),
        CardData(R.drawable.psycologist, "Psychologist"),
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
                text = "Online Consult",
                fontFamily = notoFontFamily,
                color = Color.Black,
                fontSize = 20.sp
            )
            OutlinedButton(onClick = {
                navigatTO(navController, Destinations.DoctorCards.route)
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


@Composable
fun ImageListItem(imageData: CardData) {

    OutlinedCard(
        colors = CardDefaults.cardColors(containerColor = customColor.sabseLightColor),
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .width(170.dp)
            .height(170.dp)
            .padding(10.dp)

    ) {
        Column(
            modifier = Modifier
                .height(170.dp)
                .width(170.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier.width(130.dp),
                painter = painterResource(id = imageData.resourceId),
                contentDescription = null
            )
            Text(
                fontSize = 16.sp,
                text = imageData.name,
                color = Color.Black,
                fontFamily = poppinsFontFamily,
                modifier = Modifier.offset(y = (-30).dp)
            )


        }
    }
}

