package com.example.nutritionalapplication.data.response

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.nutritionalapplication.data.Food

//Entity is used to represent the object from within the DB
@Entity(tableName = "food_db")
data class FoodEntity(
    @PrimaryKey(autoGenerate = true)
    val uid: Int? = 0,
    val foodName: String,
    val calories: Int?
  //  @ColumnInfo(name = "food_name")val name: String,
 //   @ColumnInfo(name = "calories")val calories: Int
){
    fun convertToDomainObject() = Food(uid, foodName, calories)
}