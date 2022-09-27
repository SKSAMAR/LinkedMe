package com.samar.linkedmewithmaterial3.domain.model

data class ScreenState<T>(
    val isLoading: Boolean = false,
    val error: String = "",
    val receivedResponse: T? = null
)
