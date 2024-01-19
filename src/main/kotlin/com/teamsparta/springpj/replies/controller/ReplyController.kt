package com.teamsparta.springpj.replies.controller

import com.teamsparta.springpj.replies.service.ReplyService
import com.teamsparta.springpj.replies.dto.CreateReplyArguments
import com.teamsparta.springpj.replies.dto.ReplyDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/api/v1/replies")
@RestController
class ReplyController(
    val replyService: ReplyService,
) {
    @PostMapping
    fun writeReply(
        @RequestBody createReplyArguments: CreateReplyArguments,
    ): ResponseEntity<ReplyDto> {
        val result = replyService.createReply(createReplyArguments)

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(result)
    }
}