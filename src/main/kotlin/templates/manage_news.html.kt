package com.example.templates

import kotlinx.html.*

fun FlowContent.manageNewsPage() {
    div(classes = "p-6") {
        // ✅ Page Title
        h1(classes = "text-2xl font-bold text-[#0A1D4D] mb-6") { +"Manage News" }

        // ✅ News Table
        div(classes = "overflow-x-auto bg-white rounded-lg shadow-lg p-5") {
            table(classes = "w-full border-collapse border border-gray-300") {
                // ✅ Table Headers
                thead {
                    tr {
                        th(classes = "border border-gray-300 px-4 py-2 bg-gray-200") { +"Title" }
                        th(classes = "border border-gray-300 px-4 py-2 bg-gray-200") { +"Date" }
                        th(classes = "border border-gray-300 px-4 py-2 bg-gray-200") { +"Details" }
                        th(classes = "border border-gray-300 px-4 py-2 bg-gray-200") { +"Category" }
                        th(classes = "border border-gray-300 px-4 py-2 bg-gray-200") { +"Image" }
                        th(classes = "border border-gray-300 px-4 py-2 bg-gray-200") { +"Video" }
                        th(classes = "border border-gray-300 px-4 py-2 bg-gray-200") { +"Status" }
                        th(classes = "border border-gray-300 px-4 py-2 bg-gray-200") { +"Actions" }
                    }
                }

                // ✅ Table Rows (Static for now, will be dynamic later)
                tbody {
                    listOf(
                        Triple("With Esdiac, adding credit is simple, fast, and secure", "March 19, 2025", "— right from the app!"),
                        Triple("Last Chance: Call Nigeria at $0.09/min", "March 17, 2025", "Plus, enjoy a 20% DISCOUNT on calls to all other countries!"),
                        Triple("Awesomeness is in the Smallest Gestures", "March 10, 2025", "Today is the International Day of Awesomeness...")
                    ).forEachIndexed { index, (title, date, details) ->
                        tr {
                            td(classes = "border border-gray-300 px-4 py-2") { +title }
                            td(classes = "border border-gray-300 px-4 py-2") { +date }
                            td(classes = "border border-gray-300 px-4 py-2") { +details }
                            td(classes = "border border-gray-300 px-4 py-2") { +(if (index == 2) "News" else "Promotion") }

                            // ✅ Image Column (Only one row has an image)
                            td(classes = "border border-gray-300 px-4 py-2 text-center") {
                                if (index == 2) {
                                    img {
                                        src = "/static/sample-image.png"  // Replace with actual image path
                                        width = "40"
                                        alt = "News Image"
                                    }
                                } else {
                                    +"No Image"
                                }
                            }

                            // ✅ Video Column
                            td(classes = "border border-gray-300 px-4 py-2 text-center") {
                                +"No Video"
                            }

                            // ✅ Status Column
                            td(classes = "border border-gray-300 px-4 py-2 text-center") {
                                span(classes = "px-3 py-1 rounded-full text-white " + if (index == 2) "bg-green-500" else "bg-red-500") {
                                    +(if (index == 2) "Active" else "Inactive")
                                }
                            }

                            // ✅ Actions Column
                            td(classes = "border border-gray-300 px-4 py-2 text-center") {
                                button(classes = "text-gray-600 text-xl") { +"⋮" }
                            }
                        }
                    }
                }
            }
        }

        // ✅ Pagination Controls
        div(classes = "flex justify-between items-center mt-6") {
            button(classes = "bg-gray-300 px-4 py-2 rounded-md") { +"Previous" }
            p(classes = "text-gray-700") { +"Page 1 of 3" }
            button(classes = "bg-[#0A1D4D] text-white px-4 py-2 rounded-md") { +"Next" }
        }
    }
}
