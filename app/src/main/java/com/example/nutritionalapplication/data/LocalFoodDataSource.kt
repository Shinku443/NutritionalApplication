package com.example.nutritionalapplication.data

import android.util.Log
import com.example.nutritionalapplication.data.dao.FoodDao
import com.example.nutritionalapplication.data.response.FoodEntity
import javax.inject.Inject

//rename to repository?
class LocalFoodDataSource @Inject constructor(
    private val foodDao: FoodDao
){
    suspend fun getFood(): List<FoodEntity> {
        return foodDao.getAll()
    }

    suspend fun addFoodToDatabase(food: Food){
        Log.e("!!", "adding food to db...")
        foodDao.insertSingleFoodItem(food.convertToEntityObject())
    }

    suspend fun deleteFood(food:Food) {
       foodDao.delete(food = food.convertToEntityObject())
    }



}