package com.example.templates

import kotlinx.html.*

fun HTML.loginPage() {  // ✅ Fix: Change FlowContent to HTML
    head {
        title { +"Login - Esdiac News App" }
        link {
            rel = "stylesheet"
            href = "/static/styles.css"
        }
        script { src = "https://cdn.tailwindcss.com" }
    }

    body {
        div(classes = "flex justify-center items-center h-screen bg-gray-100") {
            div(classes = "max-w-lg text-gray-900 mx-auto p-8 shadow-lg bg-white rounded-lg") {
                h1(classes = "text-3xl font-bold text-center mb-6") { +"Login Form" }
                p(classes = "text-center text-gray-500 mb-6") { +"Login to access the Admin Dashboard" }

                // ✅ Display error/success messages
                div {
                    script {
                        unsafe {
                            +"""
                                document.addEventListener("DOMContentLoaded", function() {
                                    const urlParams = new URLSearchParams(window.location.search);
                                    if (urlParams.has("error")) {
                                        document.getElementById("errorMessage").innerText = "Invalid email or password. Please try again.";
                                        document.getElementById("errorMessage").style.display = "block";
                                    }
                                    if (urlParams.has("success")) {
                                        document.getElementById("successMessage").innerText = "You have successfully logged out.";
                                        document.getElementById("successMessage").style.display = "block";
                                    }
                                });
                            """
                        }
                    }

                    p(classes = "bg-red-200 text-red-700 p-2 rounded-md text-center mb-4") {
                        id = "errorMessage"
                        style = "display: none;"
                    }

                    p(classes = "bg-green-200 text-green-700 p-2 rounded-md text-center mb-4") {
                        id = "successMessage"
                        style = "display: none;"
                    }
                }

                form(action = "/auth/login", method = FormMethod.post) {
                    div(classes = "my-5") {
                        label(classes = "py-2") { +"Email" }
                        input(classes = "border p-2 w-full") {
                            type = InputType.text
                            name = "email"
                            placeholder = "Enter your email"
                        }
                    }
                    div {
                        label(classes = "py-2") { +"Password" }
                        input(classes = "border p-2 w-full mt-2") {
                            type = InputType.password
                            name = "password"
                            placeholder = "Enter your password"
                        }
                    }
                    button(classes = "bg-blue-500 text-white px-4 py-2 mt-4 w-full") {
                        type = ButtonType.submit
                        id = "loginButton"
                        +"Login"
                    }

                    script {
                        unsafe {
                            +"""
                                document.querySelector("form").addEventListener("submit", function(event) {
                                    document.getElementById("loginButton").innerText = "Logging in...";
                                    document.getElementById("loginButton").disabled = true;
                                });
                            """
                        }
                    }
                }
            }
        }
    }
}
