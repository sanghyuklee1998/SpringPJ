package com.teamsparta.springpj

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.EnableAspectJAutoProxy

@EnableAspectJAutoProxy
@SpringBootApplication
class SpringPjApplication

fun main(args: Array<String>) {
    runApplication<SpringPjApplication>(*args)
}
