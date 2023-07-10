package com.example.nutritionalapplication.data

import android.content.Context
import androidx.room.Room
import com.example.nutritionalapplication.data.local.FoodDatabase
import com.example.nutritionalapplication.data.remote.FoodApi
import com.example.nutritionalapplication.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        FoodDatabase::class.java,
        "food_db"
    ).build()

    @Singleton
    @Provides
    fun provideDao(database: FoodDatabase) =  database.foodDao()



    @Singleton
    @Provides
    fun provideFoodRepo(
        api: FoodApi,
    ) = NetworkFoodDataSource(api)

    @Singleton
    @Provides
    fun provideFoodApi(): FoodApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(FoodApi::class.java)
    }


}