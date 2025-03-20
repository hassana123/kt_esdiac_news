package com.example

import com.example.templates.baseTemplate
import com.example.templates.loginPage
import com.example.templates.dashboardPage
import com.example.templates.addNewsPage  // ✅ Import the Add News page
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import kotlinx.html.*
import io.ktor.server.http.content.*

fun Application.configureTemplating() {
    routing {
        static("/static") {
            resources("static")
        }

        get("/login") {
            call.respondHtml {
                baseTemplate("Login Page") {
                    loginPage()
                }
            }
        }

        get("/dashboard") {
            call.respondHtml {
                baseTemplate("Dashboard") {
                    dashboardPage()
                }
            }
        }

        // ✅ Add News Page Route
        get("/add-news") {
            call.respondHtml {
                baseTemplate("Add News") {
                    addNewsPage()
                }
            }
        }
    }
}
