package com.vogproject.mktfy.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vogproject.mktfy.databinding.LayoutCategoryBinding
import com.vogproject.mktfy.models.homeactivity.Category


class CategoryListAdapter(private val clickListener: CategoryClickListener) :
    ListAdapter<Category, CategoryListAdapter.CategoryViewHolder>(CategoryDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(getItem(position), clickListener)
    }

    class CategoryViewHolder private constructor(val binding: LayoutCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        //These items must be specified as variables in the xml item layout file
        fun bind(
            item: Category,
            clickListener: CategoryClickListener
        ) {
            binding.apply {
                category = item
                this.clickListener = clickListener
                executePendingBindings()
            }
        }

        companion object {
            fun from(parent: ViewGroup): CategoryViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = LayoutCategoryBinding.inflate(layoutInflater, parent, false)
                return CategoryViewHolder(binding)
            }
        }
    }

    object CategoryDiffCallback : DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(oldItem: Category, newItem: Category) = oldItem == newItem
        override fun areContentsTheSame(oldItem: Category, newItem: Category) = oldItem.id == newItem.id
    }
}

class CategoryClickListener(val clickListener: (item: Category) -> Unit) {
    fun onClick(item: Category) = clickListener(item)
}