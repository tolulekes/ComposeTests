package com.vog.mvvmdemo.models

data class Feedback(
    val subject: Subject?,
    val subSubject: Subject? = null,
    val message: String?
)
