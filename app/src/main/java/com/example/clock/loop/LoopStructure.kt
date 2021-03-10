package com.example.clock.loop

interface LoopStructure {
    fun start()
    fun pause()
    fun lap(): Int
    fun resume()
    fun restart()
    fun join(): Thread
}