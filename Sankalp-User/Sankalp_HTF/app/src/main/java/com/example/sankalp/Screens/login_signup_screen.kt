package com.example.sankalp.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sankalp.Components.CircularProgressBar
import com.example.sankalp.Components.checkSignIn
import com.example.sankalp.R
import com.example.sankalp.Viewmodels.ChatViewModel
import com.example.sankalp.navigation.Destinations
import com.example.sankalp.ui.theme.customColor
import com.example.sankalp.ui.theme.poppinsFontFamily


@Composable
fun Login_signup_screen(navController: NavController, vm: ChatViewModel) {
    val Context = LocalContext.current
    checkSignIn(vm = vm, navController = navController)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(customColor.Beige),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(fontFamily = poppinsFontFamily,text = "Welcome to Sankalp", fontSize = 30.sp, color = Color.Black)
        Image(
            modifier = Modifier
                .width(300.dp)
                .height(300.dp),
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null
        )
        Spacer(modifier = Modifier.size(40.dp))
        Button( modifier = Modifier.width(170.dp).height(45.dp), colors = ButtonDefaults.buttonColors(containerColor = Color.Black), onClick = {
            vm.signupLogin()
            navController.navigate(Destinations.ChatScreen.route)
        }) {
            Text(fontSize = 14.sp, fontFamily = poppinsFontFamily, text = "Enter Sankalp", color = Color.White)
        }
    }

    if (vm.inProgress.value) {
        CircularProgressBar()
    }
}