package com.example.nutritionalapplication.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.nutritionalapplication.data.response.FoodEntity

//Directly touches DB
@Dao
interface FoodDao {
    @Query("SELECT * FROM food_db")
    suspend fun getAll(): List<FoodEntity>

    @Insert
    suspend fun insertSingleFoodItem(vararg food: FoodEntity)
//
//    @Insert
//    fun insertAll(vararg listOfFoods: List<FoodEntity>)

    @Delete
    suspend fun delete(food: FoodEntity)
}