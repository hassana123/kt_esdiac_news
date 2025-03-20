package com.example

import com.example.templates.baseTemplate
import com.example.templates.dashboardPage
import com.example.templates.loginPage
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Application.configureRouting() {
    routing {
        // ✅ Root should now redirect to the dashboard instead of plain text
        get("/") {
            call.respondHtml {
                baseTemplate("Dashboard") {
                    dashboardPage()
                }
            }
        }

        // ✅ Dashboard route
        get("/dashboard") {
            call.respondHtml {
                baseTemplate("Dashboard") {
                    dashboardPage()
                }
            }
        }

        // ✅ Login page
        get("/login") {
            call.respondHtml {
                baseTemplate("Login Page") {
                    loginPage()
                }
            }
        }

        // ✅ JSON API route (will now work correctly)
        get("/json/kotlinx-serialization") {
            call.respond(mapOf("hello" to "world"))
        }

        // ✅ Include Authentication routes
        configureAuthRouting()
    }
}
