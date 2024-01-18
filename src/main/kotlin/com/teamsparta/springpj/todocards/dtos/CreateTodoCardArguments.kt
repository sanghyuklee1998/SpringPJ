package com.teamsparta.springpj.todocards.dtos

import com.teamsparta.springpj.todocards.model.TodoCard

data class CreateTodoCardArguments(
    val title: String,
    val content: String,
    val nickname: String
) {
    fun to(): TodoCard {
        return TodoCard(
            title = title,
            content = content,
            nickname = nickname
        )
    }
}
