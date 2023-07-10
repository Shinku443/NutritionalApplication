package com.example.nutritionalapplication.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nutritionalapplication.data.Food
import com.example.nutritionalapplication.data.response.FoodEntity
import com.example.nutritionalapplication.domain.DeleteFoodUseCase
import com.example.nutritionalapplication.domain.GetFoodUseCase
import com.example.nutritionalapplication.domain.SaveFoodUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ManualInputViewModel @Inject constructor(
    private val saveFoodUseCase: SaveFoodUseCase,
    private val getFoodUseCase: GetFoodUseCase,
    private val deleteFoodUseCase: DeleteFoodUseCase
) : ViewModel() {

    fun listOfFoods(): Flow<List<FoodEntity>> = getFoodUseCase.invoke()

    fun saveFood(foodName: String, calories: String?) {
        Log.e("!!", "saving food $foodName")
        viewModelScope.launch {
            saveFoodUseCase.invoke(foodName, calories)
        }
    }

    fun deleteFood(food: Food){
        CoroutineScope(Dispatchers.IO).launch {
            Timber.e("!!deleting food from vm scope")
            deleteFoodUseCase.invoke(food)
        }
    }
}