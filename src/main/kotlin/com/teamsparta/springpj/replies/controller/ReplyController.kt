package com.teamsparta.springpj.replies.controller

import com.teamsparta.springpj.replies.service.ReplyService
import com.teamsparta.springpj.replies.dto.CreateReplyArguments
import com.teamsparta.springpj.replies.dto.DeleteReplyArguments
import com.teamsparta.springpj.replies.dto.ReplyDto
import com.teamsparta.springpj.replies.dto.UpdateReplyArguments
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/api/v1/replies")
@RestController
class ReplyController(
    val replyService: ReplyService,
) {
    @PostMapping
    fun createReply(
        @RequestBody createReplyArguments: CreateReplyArguments,
    ): ResponseEntity<ReplyDto> {
        val result = replyService.createReply(createReplyArguments)

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(result)
    }

    @PutMapping("/{replyId}")
    fun updateReply(
        @PathVariable replyId: Long,
        @RequestBody updateReplyArguments: UpdateReplyArguments,
    ): ResponseEntity<ReplyDto> {
        val arguments = UpdateReplyArguments(
            id = replyId,
            content = updateReplyArguments.content,
            nickname = updateReplyArguments.nickname,
            password = updateReplyArguments.password,
        )
        val reply = replyService.updateReply(arguments)

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(reply)
    }

    @DeleteMapping("/{replyId}")
    fun deleteReply(
        @PathVariable replyId: Long,
        @RequestBody deleteReplyArguments: DeleteReplyArguments,
    ): ResponseEntity<Unit> {
        val arguments = DeleteReplyArguments(
            id = replyId,
            nickname = deleteReplyArguments.nickname,
            password = deleteReplyArguments.password,
        )

        replyService.deleteReply(arguments)

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(null)
    }
}