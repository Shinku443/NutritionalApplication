package com.example.nutritionalapplication.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nutritionalapplication.data.response.FoodEntity
import com.example.nutritionalapplication.data.dao.FoodDao

@Database(entities = [FoodEntity::class], version = 1)
abstract class FoodDatabase : RoomDatabase() {
    abstract fun foodDao(): FoodDao
}