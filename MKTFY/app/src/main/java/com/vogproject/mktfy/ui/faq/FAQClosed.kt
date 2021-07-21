package com.vogproject.mktfy.ui.faq

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.vogproject.mktfy.R
import com.vogproject.mktfy.adapters.FAQTopicClickListener
import com.vogproject.mktfy.adapters.FAQTopicListAdapter
import com.vogproject.mktfy.databinding.FragmentFAQBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.vogproject.mktfy.models.faq.FAQViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class FAQClosed : Fragment() {

    private val viewModel: FAQViewModel by viewModel()
    private lateinit var binding: FragmentFAQBinding
    private lateinit var faqAdapter: FAQTopicListAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_f_a_q, container, false)
        binding.apply {
            lifecycleOwner = this@FAQClosed
            faqAdapter = FAQTopicListAdapter(FAQTopicClickListener {

            })
            faqTopicRecyclerView.adapter = faqAdapter

        }
            lifecycleScope.launch {
                viewModel.listData.collect {data ->
                    faqAdapter.submitData(data)
                }
            }

        return binding.root
    }
}