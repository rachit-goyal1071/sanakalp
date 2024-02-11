package com.example.sankalp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sankalp.Components.Meditation
import com.example.sankalp.DoctorPage.DoctorCards
import com.example.sankalp.MainScreen.ChatPage
import com.example.sankalp.Screens.ChatScreen
import com.example.sankalp.Screens.DoctorScreen
import com.example.sankalp.Screens.Login_signup_screen
import com.example.sankalp.Screens.ReelsScreen
import com.example.sankalp.Screens.SingleChatScreen
import com.example.sankalp.Screens.StreakScreen
import com.example.sankalp.Viewmodels.ChatViewModel
import com.example.sankalp.navigation.Destinations
import com.example.sankalp.ui.theme.SankalpTheme
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SankalpTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }

    @Composable
    fun AppNavigation() {
        val navController = rememberNavController()
        val vm = hiltViewModel<ChatViewModel>()
        NavHost(navController = navController, startDestination = Destinations.LoginSignup.route) {
            composable(Destinations.LoginSignup.route) {
                Login_signup_screen( navController, vm)
            }
            composable(Destinations.ChatScreen.route) {
                ChatScreen(navController, vm)
            }
            composable(Destinations.DoctorScreen.route) {
                DoctorScreen(navController, vm)
            }
            composable(Destinations.StreakScreen.route) {
                StreakScreen(navController, vm)
            }
            composable(Destinations.SingleChatScreen.route) {
                SingleChatScreen(navController, vm)
            }
            composable(Destinations.ReelsScreen.route) {
                ReelsScreen(navController, vm)
            }
            composable(Destinations.DoctorCards.route) {
                DoctorCards(navController)
            }
            composable(Destinations.ChatPage.route) {
                ChatPage(navController)
            }
            composable(Destinations.Meditation.route) {
                Meditation(navController,vm)
            }
        }
    }
}
