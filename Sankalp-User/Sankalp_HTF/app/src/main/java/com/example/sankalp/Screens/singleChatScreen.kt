package com.example.sankalp.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentRecomposeScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sankalp.Viewmodels.ChatViewModel
import com.example.sankalp.ui.theme.customColor

@Composable
fun SingleChatScreen(navController: NavController, vm: ChatViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Bottom
    ) {
        ReplyBox(reply = "", onReplyChange = {}) {
        }

    }
}


@Composable
fun ReplyBox(reply: String, onReplyChange: (String) -> Unit, onSendReply: () -> Unit) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp), verticalAlignment = Alignment.Bottom
    ) {
        TextField(
            modifier = Modifier
                .width(250.dp)
                .clip(RoundedCornerShape(10.dp)),
            value = reply,
            onValueChange = { onReplyChange },
            maxLines = 3,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = customColor.FrenchGrey,
                unfocusedContainerColor = customColor.FrenchGrey
            )
        )
        Button(
            onClick = { onSendReply },
            colors = ButtonDefaults.buttonColors(containerColor = customColor.DelftBlue)
        ) {
            Text(text = "Send", color = Color.White)
        }
    }
}