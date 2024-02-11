package com.example.sankalp.Components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import com.example.sankalp.Viewmodels.ChatViewModel
import com.example.sankalp.navigation.Destinations


@Composable
fun checkSignIn(vm:ChatViewModel,navController: NavController) {
    val alreadySignIn = remember {
        mutableStateOf(false)
    }
    val signIn = vm.signIn.value
    if (signIn && !alreadySignIn.value){
        alreadySignIn.value = true
        navController.navigate(Destinations.ChatScreen.route){
            popUpTo(0 )
        }
    }

}