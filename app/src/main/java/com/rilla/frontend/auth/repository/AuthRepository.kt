package com.rilla.frontend.auth.repository

interface AuthRepository {
    suspend fun login(email: String, password: String): Boolean
}