package com.example.kotlinoneproject

import java.io.Serializable

data class BusinessModel(

     var imageUrl: String,
     var name: String,
     var age: Int,
     var color: String

) : Serializable



