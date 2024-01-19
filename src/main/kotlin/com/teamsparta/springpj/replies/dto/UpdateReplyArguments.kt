package com.teamsparta.springpj.replies.dto

data class UpdateReplyArguments(
    val id: Long?,
    val content: String,
    val password: String
)
