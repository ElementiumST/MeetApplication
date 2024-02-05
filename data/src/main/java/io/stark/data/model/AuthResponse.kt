package io.stark.data.model

data class AuthResponse(
    val accessToken: String,
    val refreshToken: String
)