package com.example.nutritionalapplication.domain

import android.util.Log
import com.example.nutritionalapplication.data.Food
import com.example.nutritionalapplication.data.FoodRepository
import timber.log.Timber
import javax.inject.Inject

//business logic for app (transforming data, doesn't always have to hit
//repo, but most cases it does)
class DeleteFoodUseCase @Inject constructor(private val foodRepository: FoodRepository) {
    suspend fun invoke(food: Food) {
        Timber.e("!!invoking delete")
        foodRepository.deleteFood(food)
    }
}

