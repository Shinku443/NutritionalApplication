package com.example.nutritionalapplication.data.domain

import com.example.nutritionalapplication.data.FoodRepository
import com.example.nutritionalapplication.domain.SaveFoodUseCase
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class SaveFoodUseCaseTest {
    lateinit var subject: SaveFoodUseCase
    private val foodRepository = mockk<FoodRepository>(relaxed = true)

    @Before
    fun setup() {
        subject = SaveFoodUseCase(foodRepository)
    }

    @Test
    fun `when calories is null and invoked is called, food is saved with null calories`() = runTest {
        subject.invoke("Chicken", null)
        coVerify { foodRepository.saveFood("Chicken", null) }
    }

    @Test
    fun `when calories is an int and invoked is called, food is saved with some calories of int`() = runTest {
        subject.invoke("Chicken", "150")
        coVerify { foodRepository.saveFood("Chicken", 150) }
    }

    @Test
    fun `when calories is empty and invoked is called, food is saved with null calories`() =runTest {
        subject.invoke("Chicken", "")
        coVerify { foodRepository.saveFood("Chicken", null) }
    }

    @Test
    fun `when calories is blank and invoked is called, food is saved with null calories`() =runTest {
        subject.invoke("Chicken", "  ")
        coVerify { foodRepository.saveFood("Chicken", null) }
    }
}