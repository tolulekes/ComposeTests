package com.vog.mvvmdemo.models

import com.vog.mvvmdemo.models.Feedback
import com.vog.mvvmdemo.models.Subject

interface IFeedbackModel {
    suspend fun getSubjects(): List<Subject>
    suspend fun submitFeedback(feedback: Feedback)
}