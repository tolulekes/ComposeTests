package com.vog.mvvmdemo.models

data class Subject(
    val name: String,
    val subSubjects: List<Subject> = listOf()
){
    override fun toString(): String {
        return name
    }
}
