package com.example.security

import kotlinx.serialization.Serializable  // ✅ Import Serializable

@Serializable  // ✅ Fix: This tells Kotlinx Serialization to handle this class
data class UserSession(val userId: String)
