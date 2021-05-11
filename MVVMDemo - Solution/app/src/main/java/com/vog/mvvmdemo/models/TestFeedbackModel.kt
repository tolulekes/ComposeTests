package com.vog.mvvmdemo.models

import kotlinx.coroutines.delay

class TestFeedbackModel: IFeedbackModel {
    override suspend fun getSubjects(): List<Subject> {
        return listOf(
            Subject("Issue", listOf(
                Subject("Login"),
                Subject("Feed"),
                Subject("Settings"),
                Subject("Other")
            )),
            Subject("Feature Request"),
            Subject("Other")
        )
    }

    override suspend fun submitFeedback(feedback: Feedback) {

    }
}