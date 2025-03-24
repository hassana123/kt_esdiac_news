package com.example.routes

import com.example.database.Users
import com.example.security.UserSession
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

fun Application.configureAuthRouting() {
    routing {
        post("/auth/login") {
            val formData = call.receiveParameters()
            val email = formData["email"]
            val password = formData["password"]

            // ✅ Check database for user
            val userExists = transaction {
                Users.select { Users.email eq email!! }
                    .map { it[Users.password] }
                    .firstOrNull() == password
            }

            if (userExists) {
                call.sessions.set(UserSession(userId = email!!))
                call.respondRedirect("/dashboard?success=logged_in")
            } else {
                call.respondRedirect("/login?error=invalid_credentials")
            }
        }

        get("/auth/logout") {
            call.sessions.clear<UserSession>()
            call.respondRedirect("/login?success=logged_out")
        }
    }
}
