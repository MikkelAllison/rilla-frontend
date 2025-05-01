package com.rilla.frontend.auth.repository

import kotlinx.coroutines.delay


class FakeAuthRepository : AuthRepository {
    override suspend fun login(email: String, password: String): Boolean {
        delay(100) // simulate API call
        return true
    }
}