package com.teamsparta.springpj.replies.repository

import com.teamsparta.springpj.replies.model.Reply
import org.springframework.data.jpa.repository.JpaRepository

interface ReplyRepository: JpaRepository<Reply, Long> {
}