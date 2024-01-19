package com.teamsparta.springpj.replies.service

import com.teamsparta.springpj.replies.dto.CreateReplyArguments
import com.teamsparta.springpj.replies.dto.ReplyDto

interface ReplyService {
    fun createReply(createReplyArguments: CreateReplyArguments): ReplyDto
}