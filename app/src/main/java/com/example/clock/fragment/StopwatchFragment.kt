package com.example.clock.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.clock.R
import com.example.clock.Utils.*
import com.example.clock.adapter.LapAdapter
import com.example.clock.loop.MainLoop

class StopwatchFragment : Fragment(), StopwatchFragmentStructure {


    var stopwatchTextView: TextView? = null
    var startView: TextView? = null
    var pauseView: TextView? = null
    var lapView: TextView? = null
    var lapList: RecyclerView? = null

    var hasPauseViewShow: Boolean? = null
    var animUtils: AnimUtils? = null
    var loop: MainLoop? = null
    var list: ArrayList<Int>? = null
    var layoutManager: StaggeredGridLayoutManager? = null
    var adapter: LapAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.ui_layout, container, false)
        return view
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        stopwatchTextView = view.findViewById(R.id.stopwatch_show_countdown)
        startView = view.findViewById(R.id.start_view)
        pauseView = view.findViewById(R.id.pause_view)
        lapView = view.findViewById(R.id.lap_view)
        lapList = view.findViewById(R.id.lap_list)

        animUtils = context?.let { AnimUtils(it) }
        loop = MainLoop(stopwatchTextView!!)
        hasPauseViewShow = false
        list = ArrayList()
        layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        adapter=LapAdapter(list!!)
        lapList!!.adapter=adapter
        lapList!!.layoutManager=layoutManager

        startView!!.text = START_BUTTON_DEFAULT_TEXT
        create()


        startView!!.setOnClickListener {
            Log.d("ttt", "StartView click")
            when (it.visibility) {
                View.VISIBLE -> {
                    Log.d("ttt", "StartView click OK")
                    start()
                }
            }
        }
        pauseView!!.setOnClickListener {
            Log.d("ttt", "PauseView click")
            when (it.visibility) {
                View.VISIBLE -> {
                    Log.d("ttt", "PauseView click OK")
                    when (hasPauseViewShow) {
                        true -> {
                            Log.d("ttt", "PauseView click OK true")
                            pause()
                        }
                        false -> {
                            Log.d("ttt", "PauseView click OK false")
                            resume()
                        }
                    }
                }
            }
        }
        lapView!!.setOnClickListener {
            Log.d("ttt", "LapView click")
            when (it.visibility) {
                View.VISIBLE -> {
                    Log.d("ttt", "LapView click Ok")
                    when (hasPauseViewShow) {
                        true -> {
                            Log.d("ttt", "LapView click Ok true")
                            lap()
                        }
                        false -> {
                            Log.d("ttt", "LapView click Ok false")
                            restart()
                        }
                    }
                }
            }
        }
    }

    override fun create() {
        Log.d("ttt", "Creat Method")
        when (hasPauseViewShow) {
            false -> {
                Log.d("ttt", "Creat Method false")
                stopwatchTextView!!.text = STOPWATCH_DEFAULT_TEXT
                animUtils!!.startButtonCreate(startView!!)
            }
        }
    }

    override fun start() {
        Log.d("ttt", "Start Method")
        when (hasPauseViewShow) {
            false -> {
                Log.d("ttt", "Start Method false")
                pauseView!!.text = PAUSE_BUTTON_DEFAULT_TEXT
                lapView!!.text = LAP_BUTTON_DEFAULT_TEXT
                pauseView!!.setBackgroundResource(R.drawable.pause_button_background)
                animUtils!!.lapButtonCreate(lapView!!)
                animUtils!!.pauseButtonCreate(pauseView!!)
                animUtils!!.startButtonDestroy(startView!!)
                loop!!.start()
                hasPauseViewShow = true
            }
        }
    }

    override fun pause() {
        Log.d("ttt", "Pause Method")
        hasPauseViewShow = false
        loop!!.pause()
        pauseView!!.setBackgroundResource(R.drawable.start_button_background)
        pauseView!!.text = RESUME_BUTTON_DEFAULT_TEXT
        lapView!!.text = RESTART_BUTTON_DEFAULT_TEXT
    }

    override fun lap() {
        Log.d("ttt", "Lap Method")
        list!!.add(0,loop!!.lap())
        adapter!!.notifyItemChanged(0)
        if (lapList!!.visibility==View.GONE) {
            animUtils!!.listViewCreate(lapList!!)
        }
    }

    override fun resume() {
        Log.d("ttt", "Resume Method")
        hasPauseViewShow = true
        loop!!.resume()
        pauseView!!.setBackgroundResource(R.drawable.pause_button_background)
        pauseView!!.text = PAUSE_BUTTON_DEFAULT_TEXT
        lapView!!.text = LAP_BUTTON_DEFAULT_TEXT
    }

    override fun restart() {
        Log.d("ttt", "Restart Method")
        animUtils!!.lapButtonDestroy(lapView!!)
        animUtils!!.pauseButtonDestroy(pauseView!!)
        animUtils!!.listViewDestroy(lapList!!)
        list!!.clear()
        create()
    }
}
