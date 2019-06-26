package com.example.rostislav.observerapp

sealed class State {
    object Added : State()
    object Removed : State()
}