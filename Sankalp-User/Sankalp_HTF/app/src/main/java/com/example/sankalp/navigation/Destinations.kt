package com.example.sankalp.navigation

sealed class Destinations(var route:String) {
    object LoginSignup:Destinations("login_signup")
    object ChatScreen:Destinations("chatScreen")
    object DoctorScreen:Destinations("otherScreen")
    object StreakScreen:Destinations("streakScreen")
    object SingleChatScreen:Destinations("SingleChatScreen")
    object ReelsScreen:Destinations("ReelsScreen")
    object DoctorCards:Destinations("DoctorCards")
    object ChatPage:Destinations("chatPage")
    object Meditation:Destinations("Meditation")
}
