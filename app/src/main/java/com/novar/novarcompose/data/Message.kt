package com.novar.novarcompose.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue


class Message(val from: User, val text: String, val time: String) {
    var read: Boolean by mutableStateOf(true)
}