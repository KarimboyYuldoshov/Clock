package com.example.clock.fragment

interface StopwatchFragmentStructure {
    fun create()
    fun start()
    fun pause()
    fun lap()
    fun resume()
    fun restart()
}