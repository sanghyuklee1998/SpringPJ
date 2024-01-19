package com.teamsparta.springpj.todocards.dtos

import com.teamsparta.springpj.todocards.model.TodoCard
import java.time.ZonedDateTime

data class TodoCardDto(
    val id: Long?,
    val title: String,
    val content: String,
    val nickname: String,
    val isCompleted: Boolean,
    val createdAt: ZonedDateTime
) {
    companion object {
        fun from(todoCard: TodoCard): TodoCardDto {
            return TodoCardDto(
                id = todoCard.id,
                title = todoCard.title,
                content = todoCard.content,
                nickname = todoCard.nickname,
                isCompleted = todoCard.isCompleted,
                createdAt = todoCard.createdAt
            )
        }
    }
}