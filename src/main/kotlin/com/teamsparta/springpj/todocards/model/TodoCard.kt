package com.teamsparta.springpj.todocards.model

import com.teamsparta.springpj.replies.model.Reply
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import org.hibernate.annotations.CreationTimestamp
import java.time.ZonedDateTime

@Entity
class TodoCard (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column
    val title: String,

    @Column
    val content: String,

    @Column
    val nickname: String,

    @OneToMany(mappedBy = "todoCard")
    val repiles: List<Reply> = emptyList()


) {
    @CreationTimestamp
    @Column(updatable = false)
    val createdAt: ZonedDateTime = ZonedDateTime.now()

    @Column(name = "is_completed")
    private var _isCompleted: Boolean = false

    val isCompleted: Boolean
        get() = _isCompleted

    fun complete(){
        _isCompleted = true
    }
}


