package com.example.sankalp.Models



data class Song(
    val title: String,
    val songUrl: String
)

data class Category(
    val coverUrl: String,
    val title: String,
    val songArray: List<String>
)

