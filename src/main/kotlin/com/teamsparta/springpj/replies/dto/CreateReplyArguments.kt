package com.teamsparta.springpj.replies.dto

data class CreateReplyArguments(
    val content: String,
    val nickname: String,
    val password: String,
    val todoCardId: Long,
)