package com.teamsparta.springpj.replies.service

import com.teamsparta.springpj.replies.model.Reply
import com.teamsparta.springpj.replies.repository.ReplyRepository
import com.teamsparta.springpj.todocards.repository.TodoCardRepository
import com.teamsparta.springpj.replies.dto.CreateReplyArguments
import com.teamsparta.springpj.replies.dto.DeleteReplyArguments
import com.teamsparta.springpj.replies.dto.ReplyDto
import com.teamsparta.springpj.replies.dto.UpdateReplyArguments
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.lang.Exception

@Service
class ReplyServiceImpl(
    val replyRepository: ReplyRepository,
    val todoCardRepository: TodoCardRepository,
): ReplyService {
    override fun createReply(createReplyArguments: CreateReplyArguments): ReplyDto {
        val targetTodoCard = todoCardRepository.findByIdOrNull(createReplyArguments.todoCardId)
            ?: throw Exception("target todo card is not found")

        val reply = Reply(
            content = createReplyArguments.content,
            authorName = createReplyArguments.authorName,
            password = createReplyArguments.password,
            todoCard = targetTodoCard,
        )

        val result = replyRepository.save(reply)

        return ReplyDto.from(result)
    }

    override fun updateReply(updateReplyArguments: UpdateReplyArguments): ReplyDto {
        val foundReply = updateReplyArguments.id?.let {
            replyRepository.findByIdOrNull(it)
        } ?: throw Exception("target reply is not found")

        foundReply.changeContent(updateReplyArguments.content)

        replyRepository.save(foundReply)

        return ReplyDto.from(foundReply)
    }

    override fun deleteReply(deleteReplyArguments: DeleteReplyArguments) {
        deleteReplyArguments.id?.let {
            replyRepository.deleteById(it)
        }
    }
}