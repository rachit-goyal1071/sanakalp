package com.example.sankalp.DoctorPage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sankalp.ui.theme.customColor
import com.example.sankalp.ui.theme.notoFontFamily


@Composable
fun EventsComposable() {
    Column {
        Spacer(modifier = Modifier.size(15.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.padding(start = 10.dp),
                text = "Nearby Events",
                fontFamily = notoFontFamily,
                color = Color.Black,
                fontSize = 20.sp
            )
            OutlinedButton(onClick = {

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
        for (i in 1..3) {
            OutlinedCard(
                colors = CardDefaults.cardColors(containerColor = customColor.FrenchGrey),
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(5.dp)

            ) {
                Column(
                    modifier = Modifier.size(80.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = null
                    )
                    Text(
                        fontSize = 15.sp,
                        text = "Physicist",
                        color = Color.Black
                    )
                }
            }
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(text = "See more", color = Color.Gray)
            Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null)
        }
    }
}
