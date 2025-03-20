package com.example

import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureTemplating()  // ✅ Ensure templates are configured
    configureSerialization()  // ✅ Install JSON serialization
    configureSecurity()
    configureRouting()  // ✅ Routing should come last
}
