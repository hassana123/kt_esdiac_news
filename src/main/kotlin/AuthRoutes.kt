package com.example

import com.example.security.FirebaseConfig
import com.google.firebase.auth.FirebaseAuthException
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureAuthRouting() {
    routing {
        post("/auth/login") {
            val formData = call.receiveParameters()
            val email = formData["email"]
            val password = formData["password"]

            if (email.isNullOrBlank() || password.isNullOrBlank()) {
                call.respond(mapOf("error" to "Email and password are required"))
                return@post
            }

            try {
                val user = FirebaseConfig.auth.getUserByEmail(email)
                val token = FirebaseConfig.auth.createCustomToken(user.uid)

                call.respond(mapOf("message" to "Login successful", "token" to token))
            } catch (e: FirebaseAuthException) {
                call.respond(mapOf("error" to "Invalid credentials: ${e.message}"))
            }
        }
    }
}
