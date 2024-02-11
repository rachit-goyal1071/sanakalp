package com.example.sankalp.utils

data class userData(
    val userId:String?="",
    val name:String?=""
//    val imageUrl:String?=""
){
    fun toMap()= mapOf(
        "userId" to userId,
        "name" to name
    )
}

