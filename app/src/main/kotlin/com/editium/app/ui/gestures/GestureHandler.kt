package com.editium.app.ui.gestures

import android.view.GestureDetector
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.View

class GestureHandler(
    view: View,
    private val onTap: () -> Unit,
    private val onLongPress: () -> Unit,
    private val onScroll: (dx: Float, dy: Float) -> Unit,
    private val onScale: (scale: Float) -> Unit
) : View.OnTouchListener {

    private val gestureDetector = GestureDetector(view.context, object : GestureDetector.SimpleOnGestureListener() {
        override fun onSingleTapConfirmed(e: MotionEvent): Boolean { onTap(); return true }
        override fun onLongPress(e: MotionEvent) { onLongPress() }
        override fun onScroll(e1: MotionEvent, e2: MotionEvent, distanceX: Float, distanceY: Float): Boolean {
            onScroll(-distanceX, -distanceY); return true
        }
    })

    private val scaleDetector = ScaleGestureDetector(view.context, object : ScaleGestureDetector.SimpleOnScaleGestureListener() {
        override fun onScale(detector: ScaleGestureDetector): Boolean { onScale(detector.scaleFactor); return true }
    })

    init { view.setOnTouchListener(this) }

    override fun onTouch(v: View, event: MotionEvent): Boolean {
        scaleDetector.onTouchEvent(event)
        gestureDetector.onTouchEvent(event)
        return true
    }
}

