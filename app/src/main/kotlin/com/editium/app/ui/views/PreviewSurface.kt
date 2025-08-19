package com.editium.app.ui.views

import android.content.Context
import android.graphics.SurfaceTexture
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.TextureView
import android.view.MotionEvent
import kotlin.math.max
import kotlin.math.min

class PreviewSurface @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : TextureView(context, attrs), TextureView.SurfaceTextureListener {

    interface Callback {
        fun onSurfaceReady(surfaceTexture: SurfaceTexture)
        fun onSurfaceDestroyed()
        fun onGesture(deltaX: Float, deltaY: Float, scale: Float)
        fun onDoubleTap()
    }

    var callback: Callback? = null

    private var lastX = 0f
    private var lastY = 0f
    private var scaleFactor = 1f

    init { surfaceTextureListener = this }

    override fun onSurfaceTextureAvailable(surface: SurfaceTexture, width: Int, height: Int) {
        callback?.onSurfaceReady(surface)
    }

    override fun onSurfaceTextureSizeChanged(surface: SurfaceTexture, width: Int, height: Int) {}

    override fun onSurfaceTextureDestroyed(surface: SurfaceTexture): Boolean {
        callback?.onSurfaceDestroyed()
        return true
    }

    override fun onSurfaceTextureUpdated(surface: SurfaceTexture) {}

    private val tapDetector = GestureDetector(context, object : GestureDetector.SimpleOnGestureListener() {
        override fun onDoubleTap(e: MotionEvent): Boolean { callback?.onDoubleTap(); return true }
    })

    override fun onTouchEvent(event: MotionEvent): Boolean {
        tapDetector.onTouchEvent(event)
        when (event.pointerCount) {
            1 -> handlePan(event)
            2 -> handlePinch(event)
        }
        return true
    }

    private fun handlePan(event: MotionEvent) {
        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> { lastX = event.x; lastY = event.y }
            MotionEvent.ACTION_MOVE -> {
                val dx = event.x - lastX
                val dy = event.y - lastY
                lastX = event.x
                lastY = event.y
                callback?.onGesture(dx, dy, scaleFactor)
            }
        }
    }

    private fun handlePinch(event: MotionEvent) {
        if (event.pointerCount < 2) return
        if (event.actionMasked == MotionEvent.ACTION_MOVE) {
            val dx = event.getX(0) - event.getX(1)
            val dy = event.getY(0) - event.getY(1)
            val distance = kotlin.math.sqrt(dx * dx + dy * dy)
            scaleFactor = min(5f, max(0.5f, distance / 300f))
            callback?.onGesture(0f, 0f, scaleFactor)
        }
    }
}

