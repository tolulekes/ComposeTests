package com.vogproject.mktfy.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.vogproject.mktfy.databinding.LayoutFaqClosedBinding
import com.vogproject.mktfy.models.faq.FAQTopic


class FAQTopicListAdapter(private val clickListener: FAQTopicClickListener) :
    PagingDataAdapter<FAQTopic, FAQTopicListAdapter.FAQTopicViewHolder>(FAQTopicDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FAQTopicViewHolder {
        return FAQTopicViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: FAQTopicViewHolder, position: Int) {
        getItem(position)?.let {faqTopic ->
            holder.bind(faqTopic, clickListener)
        }
    }

    class FAQTopicViewHolder private constructor(val binding: LayoutFaqClosedBinding) :
        RecyclerView.ViewHolder(binding.root) {
        //These items must be specified as variables in the xml item layout file
        fun bind(
            item: FAQTopic,
            clickListener: FAQTopicClickListener
        ) {
            binding.apply {
                faqtopic = item
                this.clickListener = clickListener
                executePendingBindings()
            }
        }

        companion object {
            fun from(parent: ViewGroup): FAQTopicViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = LayoutFaqClosedBinding.inflate(layoutInflater, parent, false)
                return FAQTopicViewHolder(binding)
            }
        }
    }

    object FAQTopicDiffCallback : DiffUtil.ItemCallback<FAQTopic>() {
        override fun areItemsTheSame(oldItem: FAQTopic, newItem: FAQTopic) = oldItem == newItem
        override fun areContentsTheSame(oldItem: FAQTopic, newItem: FAQTopic) =
            oldItem.setup == newItem.setup
    }
}

class FAQTopicClickListener(val clickListener: (item: FAQTopic) -> Unit) {
    fun onClick(item: FAQTopic) = clickListener(item)
}