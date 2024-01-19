package com.teamsparta.springpj.replies.dto

data class CreateReplyArguments(
    val content: String,
    val authorName: String,
    val password: String,
    val todoCardId: Long,
)