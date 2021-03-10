package com.example.clock.loop

import android.widget.TextView
import com.example.clock.Utils.TimeFormat

class MainLoop(var view: TextView) : LoopStructure {
    private var exam: Thread? = null
    private var format = TimeFormat()
    private var countDown: Int = 0
    private var thread: Thread? = null
    override fun start() {
        countDown = 0
        thread = null
        thread = StopwatchLoop(view, countDown)
        thread!!.start()
    }

    override fun pause() {
        thread!!.interrupt()
        countDown = thread!!.id.toInt()
    }

    override fun lap(): Int {
        countDown = thread!!.id.toInt()
        return countDown
    }

    override fun resume() {
        thread = null
        thread = StopwatchLoop(view, countDown)
        thread!!.start()
    }

    override fun restart() {
        countDown = 0
        thread = null
    }

    override fun join(): Thread {
        exam = Thread(Runnable {
            try {
                while (true) {
                    Thread.sleep(10)
                    countDown += 1
                    view.text = format.formatString(countDown)
                }
            } catch (e: InterruptedException) {
                e.stackTrace
                return@Runnable
            }
        })
        return exam!!
    }

}