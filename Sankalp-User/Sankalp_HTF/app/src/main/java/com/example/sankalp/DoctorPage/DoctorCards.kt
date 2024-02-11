package com.example.sankalp.DoctorPage

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import com.example.sankalp.R
import com.example.sankalp.videoCall


@Composable
fun DoctorCards(navController: NavController) {
val context = LocalContext.current
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for (i in 1..5) {

            item {

                ElevatedCard {
                    Image(
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape),
                        painter = painterResource(id = R.drawable.test),
                        contentDescription = null
                    )
                    Text(text = "Kshitiz Agarwal")//doctor
                    Text(text = "Physician")//specialization
                    Text(text = "6+ years experience")//exp of dr
                    Text(text = "location")//exp of dr
                    Text(text = "Degree")//exp of dr
                    Text(text = "Price :₹ 600")//exp of dr
                    Text(text = "Languages : English, Hindi")//exp of dr
                    Text(text = "Apollo Hospital, Gandhinagar")//exp of dr
                    Text(text = "Availaibility : Instant")//exp of dr
                    Button(onClick = {
                        val intent = Intent(context,videoCall::class.java)
                        startActivity(context,intent,null)
                    }) {
                        Icon(imageVector = Icons.Filled.Call, contentDescription = null)
                        Text(text = "Book Digital Consultation")
                    }

                }
            }
        }

    }
}