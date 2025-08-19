package com.editium.app.ui.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import kotlin.math.max
import kotlin.math.min

class TimelineView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {
    private val trackPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply { color = Color.parseColor("#2d2d2d") }
    private val playheadPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.parseColor("#00a8ff"); strokeWidth = 3f
    }
    private val textPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.parseColor("#e4e4e4"); textSize = 24f
    }

    var zoom: Float = 1f
        set(value) { field = value.coerceIn(0.25f, 8f); invalidate() }

    var playheadX: Float = 0f
        set(value) { field = value; invalidate() }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val trackHeight = 120f
        var y = 0f
        repeat(3) { _ ->
            canvas.drawRect(0f, y, width.toFloat(), y + trackHeight, trackPaint)
            y += trackHeight + 8f
        }
        // Playhead
        canvas.drawLine(playheadX, 0f, playheadX, height.toFloat(), playheadPaint)
        canvas.drawText("Zoom x$zoom", 16f, height - 16f, textPaint)
    }
}

