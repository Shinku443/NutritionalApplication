package com.example.nutritionalapplication.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.nutritionalapplication.data.response.FoodEntity
import com.example.nutritionalapplication.databinding.FoodItemListBinding
import timber.log.Timber

class FoodListAdapter(private var viewModel: ManualInputViewModel) :
    ListAdapter<FoodEntity, FoodListAdapter.FoodListViewHolder>(DiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodListViewHolder {
        return FoodListViewHolder(
            FoodItemListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    override fun onBindViewHolder(holder: FoodListViewHolder, position: Int) {
        holder.bind(getItem(position), viewModel)
        //holder.

    }

    class FoodListViewHolder(private var binding: FoodItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(foodEntity: FoodEntity, viewModel: ManualInputViewModel) {
            binding.foodName.text = foodEntity.foodName
            binding.calories.text = foodEntity.calories.toString()
            binding.deleteButton.setOnClickListener {
                Timber.e("!!clicking!:: ${foodEntity.convertToDomainObject()}")
                viewModel.deleteFood(foodEntity.convertToDomainObject())
            }
        }
    }


    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<FoodEntity>() {
            override fun areItemsTheSame(oldItem: FoodEntity, newItem: FoodEntity): Boolean {
                return oldItem.uid == newItem.uid
            }

            override fun areContentsTheSame(oldItem: FoodEntity, newItem: FoodEntity): Boolean {
                return oldItem == newItem
            }
        }

    }
}