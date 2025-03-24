package com.example

import com.example.security.UserSession
import com.example.templates.baseTemplate
import com.example.templates.loginPage
import com.example.templates.dashboardPage
import com.example.templates.addNewsPage
import com.example.templates.manageNewsPage
import io.ktor.server.application.*
import io.ktor.server.sessions.*
import io.ktor.server.response.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import io.ktor.server.http.content.*
import io.ktor.server.request.path
import kotlinx.html.FlowContent

fun Application.configureTemplating() {
    routing {
        static("/static") {
            resources("static")
        }

        // ✅ Redirect Root `/` to `/login`
        get("/") {
            call.respondRedirect("/login")
        }

        // ✅ Login Route
        get("/login") {
            val session = call.sessions.get<UserSession>()
            if (session != null) {
                // ✅ If already logged in, redirect to dashboard
                call.respondRedirect("/dashboard")
            } else {
                call.respondHtml { loginPage() }
            }
        }

        // ✅ Secure Route Helper (Fix for `PipelineContext` issue)
        fun Route.authenticatedRoute(path: String, pageTitle: String, pageContent: FlowContent.() -> Unit) {
            get(path) {
                val session = call.sessions.get<UserSession>()
                if (session == null) {
                    // ✅ Redirect if user is NOT logged in
                    call.respondRedirect("/login")
                } else {
                    // ✅ Render the requested page
                    call.respondHtml {
                        baseTemplate(pageTitle) {
                            pageContent()
                        }
                    }
                }
            }
        }

        // ✅ Protected Routes (Require Authentication)
        authenticatedRoute("/dashboard", "Dashboard") { dashboardPage() }
        authenticatedRoute("/add-news", "Add News") { addNewsPage() }
        authenticatedRoute("/manage-news", "Manage News") { manageNewsPage() }
    }
}
