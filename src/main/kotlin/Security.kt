package com.example

import com.example.security.FirebaseConfig
import io.ktor.server.application.*

fun Application.configureSecurity() {
    FirebaseConfig.initialize()
}
