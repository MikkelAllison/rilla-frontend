package com.rilla.frontend.auth.viewmodel

import com.rilla.frontend.auth.repository.FakeAuthRepository
import com.rilla.frontend.utils.MainDispatcherRule
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.advanceUntilIdle
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

class LoginViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `login sets loading state true then false on success`() = runTest {
        val viewModel = LoginViewModel(FakeAuthRepository())
        val states = mutableListOf<LoginUiState>()

        // Observe state changes
        val job = launch { viewModel.uiState.toList(states) }

        viewModel.login("user@example.com", "password123")
        advanceUntilIdle()

        assertTrue(states.first().isLoading)
        assertFalse(states.last().isLoading)

        job.cancel()
    }

    @Test
    fun `login with blank email shows error`() {
        val viewModel = LoginViewModel(FakeAuthRepository())
        viewModel.login("", "password")

        val error = viewModel.uiState.value.error
        assertEquals("Email and password must not be blank", error)
    }

}