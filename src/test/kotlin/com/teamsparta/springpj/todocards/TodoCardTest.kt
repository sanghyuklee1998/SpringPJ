package com.teamsparta.springpj.todocards

import com.teamsparta.springpj.replies.model.Reply
import com.teamsparta.springpj.todocards.model.TodoCard
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class TodoCardTest : BehaviorSpec({
    Given("information of todo card") {
        val id = null
        val title = "title"
        val content = "content"
        val nickname = "nickname"
        val replies = emptyList<Reply>()

        When("excute TodoCard constructor") {
            val result = TodoCard(
                id = id,
                title = title,
                content = content,
                nickname = nickname,
                replies = replies,
            )

            Then("result should be expected") {
                result.id shouldBe id
                result.title shouldBe title
                result.content shouldBe content
                result.nickname shouldBe nickname
                result.replies shouldBe replies
            }
        }
    }
})