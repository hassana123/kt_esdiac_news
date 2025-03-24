package com.example.templates

import com.example.templates.components.navbar
import kotlinx.html.*

fun HTML.baseTemplate(titleText: String, content: FlowContent.() -> Unit) {
    head {
        title { +titleText }
        link {
            rel = "stylesheet"
            href = "/static/styles.css"
        }
        script { src = "https://cdn.tailwindcss.com" }
    }

    body {
        script {
            unsafe {
                +"""
                    document.addEventListener("DOMContentLoaded", function() {
                        const urlParams = new URLSearchParams(window.location.search);
                        if (urlParams.has("success")) {
                            document.getElementById("successMessage").innerText = "Welcome back!";
                            document.getElementById("successMessage").style.display = "block";
                        }
                    });
                """
            }
        }

        p(classes = "bg-green-200 text-green-700 p-2 rounded-md text-center mb-4") {
            id = "successMessage"
            style = "display: none;"
        }

        div(classes = "flex h-screen") {
            div(classes = "w-1/5 bg-[#0A1D4D] text-white p-5 flex flex-col justify-between" ) {
                div(classes = "mt-[100px]") {
                    ul(classes = "space-y-20") {
                        li { a(href = "/dashboard") { +"📊 Dashboard" } }
                        li { a(href = "/add-news") { +"📰 Add News" } }
                        li { a(href = "/manage-news") { +"🗂 Manage News" } }
                    }
                }

                div {
                    a(href = "/auth/logout", classes = "bg-red-500 text-white px-4 py-2 rounded-md") {
                        +"🚪 Logout"
                    }
                }
            }

            div(classes = "w-full p-6") {
                navbar()
                div(classes = "mt-5 bg-white") {
                    content()
                }
            }
        }
    }
}
