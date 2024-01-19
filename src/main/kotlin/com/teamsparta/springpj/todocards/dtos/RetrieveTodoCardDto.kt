package com.teamsparta.springpj.todocards.dtos

import com.teamsparta.springpj.replies.dto.ReplyDto
import com.teamsparta.springpj.todocards.model.TodoCard
import java.time.ZonedDateTime

class RetrieveTodoCardDto (
    val id: Long?,
    val title: String,
    val content: String,
    val nickname: String,
    val isCompleted: Boolean,
    val createdAt: ZonedDateTime,
    val replies: List<ReplyDto>,
    ) {
        companion object {
            fun from(todoCard: TodoCard): RetrieveTodoCardDto {
                return RetrieveTodoCardDto(
                    id = todoCard.id,
                    title = todoCard.title,
                    content = todoCard.content,
                    nickname = todoCard.nickname,
                    isCompleted = todoCard.isCompleted,
                    createdAt = todoCard.createdAt,
                    replies = todoCard.repiles.map { ReplyDto.from(it) }
                )
            }
        }
    }