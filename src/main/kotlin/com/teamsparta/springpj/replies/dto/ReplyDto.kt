package com.teamsparta.springpj.replies.dto

import com.teamsparta.springpj.replies.model.Reply

class ReplyDto(
    var id: Long?,
    val content: String,
    val nickname: String,
    var todoCardId: Long,
) {
    companion object {
        fun from(reply: Reply): ReplyDto {
            return ReplyDto(
                id = reply.id,
                content = reply.content,
                nickname = reply.nickname,
                todoCardId = reply.todoCard.id ?: throw Exception("target todo card is not persisted"),
            )
        }
    }
}