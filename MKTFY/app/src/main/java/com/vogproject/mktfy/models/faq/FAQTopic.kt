package com.vogproject.mktfy.models.faq

data class FAQTopic(
    val formatVersion: Int,
    val category: String,
    val type: String,
    val setup: String,
    val delivery: String,
    val flags: Flags,
    val lang: String
) {
    data class Flags(
        val nsfw: Boolean = false,
        val religious: Boolean = false,
        val political: Boolean = false,
        val racist: Boolean = false,
        val sexist: Boolean = false,
        val explicit: Boolean = false
    )
}
