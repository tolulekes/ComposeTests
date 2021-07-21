package com.vogproject.mktfy.ui.faq

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.vogproject.mktfy.R
import com.vogproject.mktfy.databinding.FragmentFAQOpenedBinding


class FAQOpened : Fragment() {

    private lateinit var binding: FragmentFAQOpenedBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_f_a_q_opened, container, false)

        return binding.root
    }
}