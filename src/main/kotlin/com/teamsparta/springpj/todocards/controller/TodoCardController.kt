package com.teamsparta.springpj.todocards.controller

import com.teamsparta.springpj.todocards.dtos.TodoCardDto
import com.teamsparta.springpj.todocards.dtos.CreateTodoCardArguments
import com.teamsparta.springpj.todocards.dtos.UpdateTodoCardArguments
import com.teamsparta.springpj.todocards.service.TodoCardService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/v1/todo-cards")
@RestController
class TodoCardController(
    val todoCardService: TodoCardService
) {

    @PostMapping
    fun createTodoCard(
        @RequestBody createTodoCardArguments: CreateTodoCardArguments,
    ): ResponseEntity<TodoCardDto> {
        val todoCard = todoCardService.createTodoCard(createTodoCardArguments)

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(todoCard)
    }

    @GetMapping
    fun findAllTodoCard(): ResponseEntity<List<TodoCardDto>> {
        val todoCards = todoCardService.findAll()

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(todoCards)
    }

    @GetMapping("/{todoCardId}")
    fun findTodoCard(
        @PathVariable todoCardId: Long
    ): ResponseEntity<TodoCardDto?> {
        val todoCard = todoCardService.findById(todoCardId)

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(todoCard)
    }

    @PutMapping
    fun updateTodoCard(
        @PathVariable todoCardId: Long,
        @RequestBody todoCardArguments: UpdateTodoCardArguments
    ): ResponseEntity<TodoCardDto> {
        val arguments = UpdateTodoCardArguments(
            id = todoCardId,
            title = todoCardArguments.title,
            content = todoCardArguments.content,
            nickname = todoCardArguments.nickname
        )

        val todoCard: TodoCardDto = todoCardService.updateTodoCard(arguments)

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(todoCard)
    }

    @PatchMapping("/{todoCardId}/complete")
    fun completeTodoCard(
        @PathVariable todoCardId: Long
    ): ResponseEntity<Unit> {
        todoCardService.completeTodoCard(todoCardId)

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(null)
    }

    @DeleteMapping("/{todoCardId}")
    fun deleteTodoCard(
        @PathVariable todoCardId: Long
    ): ResponseEntity<Unit> {
        todoCardService.deleteTodoCard(todoCardId)

        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .body(null)
    }
}