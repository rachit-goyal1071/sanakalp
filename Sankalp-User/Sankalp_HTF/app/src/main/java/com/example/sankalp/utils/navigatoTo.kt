package com.example.sankalp.utils

import androidx.navigation.NavController

fun navigatTO(navController: NavController, route: String) {
    navController.navigate(route) {
        popUpTo(route)
    }
}