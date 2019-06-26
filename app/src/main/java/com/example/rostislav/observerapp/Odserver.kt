package com.example.rostislav.observerapp

interface Odserver <T,S>{

    fun onChanged( t: T, s: S)
}