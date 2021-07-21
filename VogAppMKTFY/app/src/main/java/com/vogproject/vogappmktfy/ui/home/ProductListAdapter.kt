package com.vogproject.vogappmktfy.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vogproject.vogappmktfy.databinding.LayoutProductBinding
import com.vogproject.vogappmktfy.models.Product


class ProductListAdapter(private val clickListener: ProductClickListener) :
    ListAdapter<Product, ProductListAdapter.ProductViewHolder>(ProductDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(getItem(position), clickListener)
    }

    class ProductViewHolder private constructor(val binding: LayoutProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        //These items must be specified as variables in the xml item layout file
        fun bind(
            item: Product,
            clickListener: ProductClickListener
        ) {
            binding.apply {
                product = item
                this.clickListener = clickListener
                executePendingBindings()
            }
        }

        companion object {
            fun from(parent: ViewGroup): ProductViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = LayoutProductBinding.inflate(layoutInflater, parent, false)
                return ProductViewHolder(binding)
            }
        }
    }

    object ProductDiffCallback : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product) = oldItem == newItem
        override fun areContentsTheSame(oldItem: Product, newItem: Product) =
            oldItem.id == newItem.id
    }
}

class ProductClickListener(val clickListener: (item: Product) -> Unit) {
    fun onClick(item: Product) = clickListener(item)
}