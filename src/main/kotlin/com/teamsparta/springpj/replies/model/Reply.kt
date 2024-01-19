package com.teamsparta.springpj.replies.model

import com.teamsparta.springpj.todocards.model.TodoCard
import jakarta.persistence.*

@Entity
@Table(name = "comment")
class Reply(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column
    var content: String,
    @Column
    val nickname: String,
    @Column
    val password: String,
    @ManyToOne
    var todoCard: TodoCard,
) {
    fun changeContent(content: String){
        this.content = content
    }
}