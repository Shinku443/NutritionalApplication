package com.example.nutritionalapplication.data

import com.example.nutritionalapplication.data.response.FoodEntity

//Exposed to domain layer
data class Food (
    val uid: Int?,
    val foodName: String,
    val calories: Int?
){
    fun convertToEntityObject() = FoodEntity(uid = uid, foodName =  foodName, calories = calories)
}