package com.example.nutritionalapplication.domain

import android.util.Log
import com.example.nutritionalapplication.data.FoodRepository
import javax.inject.Inject

//business logic for app (transforming data, doesn't always have to hit
//repo, but most cases it does)
class SaveFoodUseCase @Inject constructor(private val foodRepository: FoodRepository) {
    suspend fun invoke(foodName: String, calories: String?) {
        Log.e("!!", "invoking")
        val cals = if (calories?.isNotBlank() == true) calories.toInt() else null
        foodRepository.saveFood(foodName, cals)
    }
}



//class PhoneUseCase{
//
//    fun validatePhone(val phone:String): Boolean{
//        //check that phone is valid
//        return true/false
//    }
//}