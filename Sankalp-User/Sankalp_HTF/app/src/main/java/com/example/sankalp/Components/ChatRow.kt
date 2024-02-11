package com.example.sankalp.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sankalp.R
import com.example.sankalp.ui.theme.customColor
import com.example.sankalp.ui.theme.notoFontFamily
import com.example.sankalp.ui.theme.poppinsFontFamily

@Composable
fun ChatRow(name: String,image:Int, onItemClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .clickable { onItemClick.invoke() }
            .background(Color.White)
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painterResource(id = image),
            contentDescription = null,
            modifier = Modifier
                .clip(CircleShape)
                .size(80.dp)
                .border(0.5.dp, color = customColor.DelftBlue,CircleShape)
        )

        Column {
            Text(
                text = name,
                color = Color.Black,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = "new messages",
                color = Color.Black,
                fontFamily = notoFontFamily,
                fontSize = 15.sp
            )
        }
        Text(text = "14:30", color = customColor.DelftBlue, modifier = Modifier.padding(end = 2.dp))
    }
    Spacer(modifier = Modifier.size(20.dp))
    Divider(thickness = 1.dp, modifier = Modifier.fillMaxWidth(), color = Color.Gray)

}