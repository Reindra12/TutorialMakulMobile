package com.example.tutorialpertama.data.remote.model

data class RegisterRequest(
    val name: String,
    val email: String,
    val password: String,
    val avatar: String
)