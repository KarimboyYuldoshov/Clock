package com.example.clock.Utils

import android.view.View

interface AnimStructure {

    fun startButtonCreate(view: View)
    fun startButtonDestroy(view: View)

    fun pauseButtonCreate(view: View)
    fun pauseButtonDestroy(view: View)

    fun lapButtonCreate(view: View)
    fun lapButtonDestroy(view: View)

    fun listViewCreate(view: View)
    fun listViewDestroy(view: View)
}