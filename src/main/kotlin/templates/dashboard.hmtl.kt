package com.example.templates

import kotlinx.html.*

fun FlowContent.dashboardPage() {
    // ✅ Dashboard Header
    div(classes = "text-center mb-6") {
        h1(classes = "text-2xl font-bold text-[#0A1D4D]") { +"Recent Uploads" }
    }

    // ✅ News List
    div(classes = "bg-white rounded-lg shadow-lg p-5") {
        // Example news items (Replace with dynamic content later)
        val newsItems = listOf(
            "With Esdiac, adding credit is simple, fast, and secure" to "March 19, 2025",
            "Last Chance: Call Nigeria at $0.09/min" to "March 17, 2025",
            "Awesomeness is in the Smallest Gestures" to "March 10, 2025"
        )

        newsItems.forEach { (title, date) ->
            div(classes = "border-b py-4 flex justify-between items-center") {
                div {
                    h2(classes = "text-lg font-semibold") { +title }
                    p(classes = "text-sm text-gray-500") { +"Promotion" }
                    p(classes = "text-sm text-gray-500") { +date }
                }

                // ✅ Read More Button
                div {
                    a(href = "#", classes = "bg-[#0A1D4D] text-white px-4 py-2 rounded-md") {
                        +"Read More"
                    }
                }
            }
        }
    }

    // ✅ Pagination Section
    div(classes = "flex justify-between items-center mt-6") {
        a(href = "#", classes = "bg-gray-300 px-4 py-2 rounded-md") { +"⬅" }
        p(classes = "text-gray-700") { +"Page 1 of 3" }
        a(href = "#", classes = "bg-[#0A1D4D] text-white px-4 py-2 rounded-md") { +"➡" }
    }

    // ✅ News Report Section
    div(classes = "mt-10 text-center") {
        h2(classes = "text-xl font-bold text-[#0A1D4D]") { +"News Report" }
        p(classes = "text-gray-500") { +"Top Performing News Categories" }
    }
}
