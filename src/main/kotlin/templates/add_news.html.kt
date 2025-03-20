package com.example.templates

import kotlinx.html.*

fun FlowContent.addNewsPage() {
    div(classes = "p-6") {
        // ✅ Page Title
        h1(classes = "text-2xl font-bold text-[#0A1D4D] mb-6") { +"Add News" }

        // ✅ News Form
        form(action = "/add-news", method = FormMethod.post, encType = FormEncType.multipartFormData, classes = "space-y-4") {

            // ✅ Title Input
            div {
                label(classes = "block text-sm font-semibold text-gray-700") { +"Title" }
                input(type = InputType.text, classes = "w-full border p-2 rounded-md") {
                    name = "title"
                    attributes["placeholder"] = "Enter news title"
                }
            }

            // ✅ Category Dropdown
            div {
                label(classes = "block text-sm font-semibold text-gray-700") { +"Category" }
                select(classes = "w-full border p-2 rounded-md") {
                    name = "category"
                    option { +"Select Category" }
                    option { +"News" }
                    option { +"Promotion" }
                    option { +"Sports" }
                    option { +"Entertainment" }
                }
            }

            // ✅ Image Upload
            div {
                label(classes = "block text-sm font-semibold text-gray-700") { +"Image (optional)" }
                input(type = InputType.file, classes = "w-full border p-2 rounded-md") {
                    name = "image"
                }
            }

            // ✅ Video Upload
            div {
                label(classes = "block text-sm font-semibold text-gray-700") { +"Video (optional)" }
                input(type = InputType.file, classes = "w-full border p-2 rounded-md") {
                    name = "video"
                }
            }

            // ✅ News Details (Textarea)
            div {
                label(classes = "block text-sm font-semibold text-gray-700") { +"Details" }
                textArea(classes = "w-full border p-2 rounded-md h-28") {
                    name = "details"
                    attributes["placeholder"] = "More details about the news..."
                }
            }

            // ✅ Status Toggle
            div(classes = "flex items-center space-x-3") {
                label(classes = "text-sm font-semibold text-gray-700") { +"Status: Is Active" }
                input(type = InputType.checkBox, classes = "border rounded-md") {
                    name = "status"
                }
            }

            // ✅ Submit Button
            div {
                button(type = ButtonType.submit, classes = "bg-[#0A1D4D] text-white px-6 py-3 rounded-md w-full") {
                    +"Upload News"
                }
            }
        }
    }
}
