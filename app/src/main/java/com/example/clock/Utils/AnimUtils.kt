package com.example.clock.Utils

import android.content.Context
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.clock.R

class AnimUtils(context: Context) : AnimStructure {
    var startButtonCreateAnim: Animation? = null
    var startButtonDestroyAnim: Animation? = null
    var pauseButtonCreateAnim: Animation? = null
    var pauseButtonDestroyAnim: Animation? = null
    var lapButtonCreateAnim: Animation? = null
    var lapButtonDestroyAnim: Animation? = null
    var listViewCreateAnim: Animation? = null
    var listViewDestroyAnim: Animation? = null

    init {
        startButtonCreateAnim =
            AnimationUtils.loadAnimation(context, R.anim.anim_start_button_create)
        startButtonDestroyAnim =
            AnimationUtils.loadAnimation(context, R.anim.anim_start_button_destroy)
        pauseButtonCreateAnim =
            AnimationUtils.loadAnimation(context, R.anim.anim_pause_button_create)
        pauseButtonDestroyAnim =
            AnimationUtils.loadAnimation(context, R.anim.anim_pause_button_destroy)
        lapButtonCreateAnim = AnimationUtils.loadAnimation(context, R.anim.anim_lap_button_create)
        lapButtonDestroyAnim = AnimationUtils.loadAnimation(context, R.anim.anim_lap_button_destroy)
        listViewCreateAnim = AnimationUtils.loadAnimation(context, R.anim.anim_list_create)
        listViewDestroyAnim = AnimationUtils.loadAnimation(context, R.anim.anim_list_destroy)
    }

    override fun startButtonCreate(view: View) {
        when (view.visibility) {
            View.INVISIBLE -> {
                view.startAnimation(startButtonCreateAnim)
                startButtonCreateAnim!!.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationRepeat(animation: Animation?) {

                    }

                    override fun onAnimationEnd(animation: Animation?) {
                        view.visibility = View.VISIBLE
                    }

                    override fun onAnimationStart(animation: Animation?) {

                    }

                })
            }
        }
    }

    override fun startButtonDestroy(view: View) {
        when (view.visibility) {
            View.VISIBLE -> {
                view.startAnimation(startButtonDestroyAnim)
                startButtonDestroyAnim!!.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationRepeat(animation: Animation?) {

                    }

                    override fun onAnimationEnd(animation: Animation?) {
                        view.visibility = View.INVISIBLE
                    }

                    override fun onAnimationStart(animation: Animation?) {

                    }
                })
            }
        }
    }

    override fun pauseButtonCreate(view: View) {
        when (view.visibility) {
            View.INVISIBLE -> {
                view.startAnimation(pauseButtonCreateAnim)
                pauseButtonCreateAnim!!.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationRepeat(animation: Animation?) {

                    }

                    override fun onAnimationEnd(animation: Animation?) {
                        view.visibility = View.VISIBLE
                    }

                    override fun onAnimationStart(animation: Animation?) {

                    }
                })
            }
        }
    }

    override fun pauseButtonDestroy(view: View) {
        when (view.visibility) {
            View.VISIBLE -> {
                view.startAnimation(pauseButtonDestroyAnim)
                pauseButtonDestroyAnim!!.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationRepeat(animation: Animation?) {

                    }

                    override fun onAnimationEnd(animation: Animation?) {
                        view.visibility = View.INVISIBLE
                    }

                    override fun onAnimationStart(animation: Animation?) {

                    }

                })
            }
        }
    }

    override fun lapButtonCreate(view: View) {
        when (view.visibility) {
            View.INVISIBLE -> {
                view.startAnimation(lapButtonCreateAnim)
                lapButtonCreateAnim!!.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationRepeat(animation: Animation?) {

                    }

                    override fun onAnimationEnd(animation: Animation?) {
                        view.visibility = View.VISIBLE
                    }

                    override fun onAnimationStart(animation: Animation?) {

                    }

                })
            }
        }
    }

    override fun lapButtonDestroy(view: View) {
        when (view.visibility) {
            View.VISIBLE -> {
                view.startAnimation(lapButtonDestroyAnim)
                lapButtonDestroyAnim!!.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationRepeat(animation: Animation?) {

                    }

                    override fun onAnimationEnd(animation: Animation?) {
                        view.visibility = View.INVISIBLE
                    }

                    override fun onAnimationStart(animation: Animation?) {

                    }

                })
            }
        }
    }

    override fun listViewCreate(view: View) {
        when (view.visibility) {
            View.GONE -> {
                view.startAnimation(listViewCreateAnim)
                listViewCreateAnim!!.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationRepeat(animation: Animation?) {

                    }

                    override fun onAnimationEnd(animation: Animation?) {
                        view.visibility = View.VISIBLE
                    }

                    override fun onAnimationStart(animation: Animation?) {

                    }

                })
            }
        }
    }

    override fun listViewDestroy(view: View) {
        when (view.visibility) {
            View.VISIBLE -> {
                view.startAnimation(listViewDestroyAnim)
                listViewDestroyAnim!!.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationRepeat(animation: Animation?) {

                    }

                    override fun onAnimationEnd(animation: Animation?) {
                        view.visibility = View.GONE
                    }

                    override fun onAnimationStart(animation: Animation?) {

                    }

                })
            }
        }
    }
}