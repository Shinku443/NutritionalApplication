package com.example.nutritionalapplication.data

import android.util.Log
import com.example.nutritionalapplication.data.response.FoodEntity
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

//SSOT
//repo can have multiple feeds of data (one network, and one local) (also one memory/cache)
//handles how we're loading data (initially load from db instead of network)
open class FoodRepository @Inject constructor(
    private val localFoodDataSource: LocalFoodDataSource, // database
) {
    private val refreshIntervalMs: Long = 500
    val latestFoods: Flow<List<FoodEntity>> = flow {
        while (true) {
            val latestFoodList = localFoodDataSource.getFood()
            emit(latestFoodList) // Emits the result of the request to the flow
            delay(refreshIntervalMs) // Suspends the coroutine for some time
        }
    }

    suspend fun saveFood(foodName: String, calories: Int?) {
        Log.e("!!", "Saving Food '$foodName' into Repo")
        localFoodDataSource.addFoodToDatabase(food = Food(null, foodName, calories))
    }


    suspend fun deleteFood(food: Food){
        Timber.e("!!r emoving food... $food")
        Timber.e("foods... : ${localFoodDataSource.getFood()}")
        localFoodDataSource.deleteFood(food)
    }
}