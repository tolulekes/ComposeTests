package com.vog.mvvmdemo.ui.feedback

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import com.google.android.material.snackbar.Snackbar
import com.vog.mvvmdemo.R
import com.vog.mvvmdemo.databinding.ActivityFeedbackBinding
import com.vog.mvvmdemo.models.Subject
import com.vog.mvvmdemo.models.TestFeedbackModel
import com.vog.mvvmdemo.ui.feedback.FeedbackViewModel.EventType.*

class FeedbackActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFeedbackBinding
    private val viewModel: FeedbackViewModel = FeedbackViewModel(TestFeedbackModel())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_feedback)
        binding.apply {
            lifecycleOwner = this@FeedbackActivity
            viewModel = this@FeedbackActivity.viewModel
        }

        viewModel.event.observe(this){
            when(it.getContentIfNotHandled()){
                SUBMIT -> {
                    viewModel.submitFeedback()
                    Toast.makeText(this, "Feedback Submitted!", Toast.LENGTH_SHORT).show()
                }
                CANCEL -> {
                    finish()
                }
                null -> {}
            }
        }

        viewModel.subjects.observe(this){subjects ->
            val dataAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, subjects)
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.subject.adapter = dataAdapter
            binding.subject.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    viewModel.setSubject(subjects[position])
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

            }
        }

        viewModel.subject.observe(this){subject ->
            subject.subSubjects.let{subjects ->
                val dataAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, subjects)
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                binding.subSubject.adapter = dataAdapter
                binding.subSubject.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        viewModel.setSubSubject(subjects[position])
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {

                    }

                }
            }
        }
    }
}