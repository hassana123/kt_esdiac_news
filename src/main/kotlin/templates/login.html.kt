package com.example.templates

import kotlinx.html.*

fun FlowContent.loginPage() {
    div(classes = "mx-auto w-[80%] max-w-[600px] mt-[100px] h-screen") {
        div(classes = "max-w-lg text-gray-900 mx-auto p-8 shadow-lg bg-white rounded-lg") {
            h1(classes = "text-3xl font-bold text-center mb-6") { +"Login Form" }
            p(classes = "text-center text-gray-500 mb-6") { +"Login to access the Admin Dashboard" }

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
                button(type = ButtonType.submit, classes = "bg-blue-500 text-white px-4 py-2 mt-4 w-full") {
                    +"Login"
                }
            }
        }
    }
}
