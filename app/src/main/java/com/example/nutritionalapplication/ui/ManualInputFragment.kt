package com.example.nutritionalapplication.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.coroutineScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nutritionalapplication.R
import com.example.nutritionalapplication.databinding.ManualInputScreenBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ManualInputFragment : Fragment() {
    private lateinit var binding: ManualInputScreenBinding
    private val viewModel: ManualInputViewModel by activityViewModels()
    private lateinit var foodListAdapter: FoodListAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ManualInputScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.saveButton.setOnClickListener {
            if (binding.foodNameInput.text.isNotEmpty()) {
                viewModel.saveFood(
                    binding.foodNameInput.text.toString(),
                    binding.foodCaloriesInput.text.toString()
                )
            }else{
                //please enter a valid name
            }
        }

        foodListAdapter = FoodListAdapter(viewModel)
        binding.foodListRecyclerView.adapter = foodListAdapter

        lifecycle.coroutineScope.launch {
            viewModel.listOfFoods().collect() {
                foodListAdapter.submitList(it)
            }
        }
        binding.foodListRecyclerView.layoutManager = LinearLayoutManager(context);

        super.onViewCreated(view, savedInstanceState)
    }
}