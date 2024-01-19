package com.teamsparta.springpj.todocards.service

import com.teamsparta.springpj.todocards.dtos.TodoCardDto
import com.teamsparta.springpj.todocards.dtos.CreateTodoCardArguments
import com.teamsparta.springpj.todocards.dtos.RetrieveTodoCardDto
import com.teamsparta.springpj.todocards.dtos.UpdateTodoCardArguments

interface TodoCardService {

    fun createTodoCard(createTodoCardArguments: CreateTodoCardArguments): TodoCardDto

    fun findById(id: Long): RetrieveTodoCardDto?

    fun findAll(): List<TodoCardDto>

    fun updateTodoCard(todoCardArguments: UpdateTodoCardArguments): TodoCardDto

    fun deleteTodoCard(id: Long)

    fun completeTodoCard(id: Long)
}