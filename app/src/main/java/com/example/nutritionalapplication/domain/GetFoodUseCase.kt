package com.example.nutritionalapplication.domain

import android.util.Log
import com.example.nutritionalapplication.data.response.FoodEntity
import com.example.nutritionalapplication.data.FoodRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

//business logic for app (transforming data, doesn't always have to hit
//repo, but most cases it does)
class GetFoodUseCase @Inject constructor(private val foodRepository: FoodRepository) {
    fun invoke(): Flow<List<FoodEntity>> {
        Log.e("!!", "invoking - getting list of foods")
        return foodRepository.latestFoods
    }
}



//class PhoneUseCase{
//
//    fun validatePhone(val phone:String): Boolean{
//        //check that phone is valid
//        return true/false
//    }
//}