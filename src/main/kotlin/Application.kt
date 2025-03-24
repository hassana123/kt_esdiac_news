package com.example

import com.example.database.DatabaseFactory
import com.example.security.configureSecurity
import com.example.routes.configureAuthRouting
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    DatabaseFactory.init()
    configureSecurity()
    configureTemplating()
    configureSerialization()
    configureAuthRouting()
    configureRouting()
}
