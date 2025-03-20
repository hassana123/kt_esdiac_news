package com.example.templates.components


import kotlinx.html.*

fun FlowContent.navbar() {
    nav(classes = "py-1  w-[80%] mx-auto flex justify-between items-center") {
        // ✅ Logo
        div(classes = "logo") {
            img {
                width = "40"
                src = "/static/logo-blue.png"  // Adjust this path to your actual logo location
                alt = "Logo"
            }
        }

        // ✅ Export Data Button
        div {
            button(classes = "bg-[#0A1D4D] hover:border-[2px] hover:bg-white border-customPrimary hover:text-customPrimary text-white py-2 px-8 rounded-md") {
                +"Export Data"
            }
        }
    }
}
