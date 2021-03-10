package com.example.clock.loop

import android.widget.TextView
import com.example.clock.Utils.TimeFormat

class StopwatchLoop(var view: TextView, var countDown: Int) : Thread() {
    var format = TimeFormat()
    override fun run() {
        try {
            while (true) {
                Thread.sleep(10)
                countDown += 1
                view.text = format.formatString(countDown)
            }
        } catch (e: InterruptedException) {
            e.stackTrace
            return
        }
    }

    override fun getId(): Long {
        return countDown.toLong()
    }
}