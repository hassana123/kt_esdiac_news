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
        div(classes = "flex h-screen") {
            // ✅ Sidebar Section
            div(classes = "w-1/5 bg-[#0A1D4D] text-white p-5 flex flex-col justify-between") {
                div (classes = "my-10") {
                    // Sidebar Logo (adjust path if needed)
//                    div(classes = "flex justify-center mb-10") {
//                        img {
//                            src = "/static/logo-blue.png"
//                            width = "60"
//                            alt = "Esdiac Logo"
//                        }
//                    }

                    // Sidebar Links
                    ul(classes = "space-y-6") {
                        li {
                            a(href = "/dashboard", classes = "flex items-center space-x-3 p-2 rounded-lg hover:bg-[#1E3A8A]") {
                                +"📊 Dashboard"
                            }
                        }
                        li {
                            a(href = "/add-news", classes = "flex items-center space-x-3 p-2 rounded-lg hover:bg-[#1E3A8A]") {
                                +"📰 Add News"
                            }
                        }
                        li {
                            a(href = "/news-report", classes = "flex items-center space-x-3 p-2 rounded-lg hover:bg-[#1E3A8A]") {
                                +"📈 News Report"
                            }
                        }
                        li {
                            a(href = "/manage-news", classes = "flex items-center space-x-3 p-2 rounded-lg hover:bg-[#1E3A8A]") {
                                +"🗂 Manage News"
                            }
                        }
                    }
                }

                // Logout Button
                div {
                    a(href = "/login", classes = "flex items-center space-x-3 p-2 rounded-lg hover:bg-red-600 text-white") {
                        +"🚪 Logout"
                    }
                }
            }

            // ✅ Main Content Section
            div(classes = "w-full  p-6") {
                // ✅ Navbar
                navbar()

                // ✅ Main Content
                div(classes = "mt-5 bg-white") {
                    content()
                }
            }
        }
    }
}
