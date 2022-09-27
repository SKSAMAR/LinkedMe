package com.samar.linkedmewithmaterial3.util.common

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.samar.linkedmewithmaterial3.domain.model.ScreenState

open class BaseViewModel<T>: ViewModel() {

    private val _state = mutableStateOf(ScreenState<T>())
    val state: State<ScreenState<T>> = _state


}