package com.example.sankalp.DoctorPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sankalp.R
import com.example.sankalp.ui.theme.customColor
import com.example.sankalp.ui.theme.notoFontFamily

@Composable
fun NgoSection() {
    val images = listOf(
        R.drawable.muskaan,
        R.drawable.stairs,
        R.drawable.stairs
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
                text = "Nearby NGOs",
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
        LazyRow() {
//            for (i in 1..3) {
            items(images.size) {index->
                OutlinedCard(
                    colors = CardDefaults.cardColors(containerColor = customColor.WhiteColor),
                    shape = RoundedCornerShape(5.dp),
                    modifier = Modifier
                        .width(225.dp)
                        .height(150.dp)
                        .padding(10.dp)

                ) {
                    Column(
                        modifier = Modifier.size(150.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Image(
                            painter = painterResource(id = images[index]),
                            contentDescription = null,
                            Modifier.size(400.dp).padding(start = 35.dp)
                        )
                    }
                }
            }
        }
    }
}

