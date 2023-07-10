package com.example.nutritionalapplication.data

import com.example.nutritionalapplication.data.remote.FoodApi
import javax.inject.Inject

//repository to use api
class NetworkFoodDataSource @Inject constructor(foodApi: FoodApi) {
}