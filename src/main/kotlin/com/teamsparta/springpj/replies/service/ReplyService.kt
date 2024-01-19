package com.teamsparta.springpj.replies.service

import com.teamsparta.springpj.replies.dto.CreateReplyArguments
import com.teamsparta.springpj.replies.dto.DeleteReplyArguments
import com.teamsparta.springpj.replies.dto.ReplyDto
import com.teamsparta.springpj.replies.dto.UpdateReplyArguments

interface ReplyService {
    fun createReply(createReplyArguments: CreateReplyArguments): ReplyDto

    fun updateReply(updateReplyArguments: UpdateReplyArguments): ReplyDto

    fun deleteReply(deleteReplyArguments: DeleteReplyArguments)
}