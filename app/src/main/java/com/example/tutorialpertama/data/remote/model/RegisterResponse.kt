package com.example.tutorialpertama.data.remote.model

import com.google.gson.annotations.SerializedName

data class RegisterResponse(
    val email: String,
    val password: String,
    val name: String,
    val avatar: String,
    val role: String,
    val id: Int,
    val creationAt: String,
    val updatedAt: String
)