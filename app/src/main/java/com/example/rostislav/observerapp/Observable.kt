package com.example.rostislav.observerapp

abstract class Observable<T,S>{

    abstract fun setObserver(odserver: Odserver<T,S>)
}