package com.teamsparta.springpj.todocards.repository

import com.teamsparta.springpj.todocards.model.TodoCard
import org.springframework.data.jpa.repository.JpaRepository

interface TodoCardRepository: JpaRepository<TodoCard, Long>{
    fun findAllByOrderByCreatedAtDesc(): List<TodoCard>
}