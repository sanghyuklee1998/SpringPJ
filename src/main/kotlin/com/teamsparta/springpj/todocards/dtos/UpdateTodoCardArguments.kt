package com.teamsparta.springpj.todocards.dtos

import com.teamsparta.springpj.todocards.model.TodoCard

data class UpdateTodoCardArguments(
    val id: Long?,
    val title: String,
    val content: String,
    val nickname: String
) {
    fun to(): TodoCard {
        return TodoCard(
            id = id,
            title = title,
            content = content,
            nickname = nickname
        )
    }
}


