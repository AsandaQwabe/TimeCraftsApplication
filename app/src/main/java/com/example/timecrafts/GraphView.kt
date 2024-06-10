package com.example.timecrafts

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class GraphView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private val paint = Paint().apply {
        color = Color.BLUE
        strokeWidth = 5f
        style = Paint.Style.STROKE
    }

    private val goalPaint = Paint().apply {
        color = Color.RED
        strokeWidth = 2f
        style = Paint.Style.STROKE
    }

    private val textPaint = Paint().apply {
        color = Color.BLACK
        textSize = 40f
    }

    private var data: List<Float> = listOf()
    private var minGoal: Float = 0f
    private var maxGoal: Float = 0f

    fun setData(data: List<Float>, minGoal: Float, maxGoal: Float) {
        this.data = data
        this.minGoal = minGoal
        this.maxGoal = maxGoal
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawGraph(canvas)
    }

    private fun drawGraph(canvas: Canvas) {
        val width = width.toFloat()
        val height = height.toFloat()
        val padding = 50f

        // Draw min and max goal lines
        val minY = height - (height * (minGoal / maxGoal))
        canvas.drawLine(padding, minY, width - padding, minY, goalPaint)
        canvas.drawText("Min Goal", padding, minY - 10, textPaint)

        val maxY = height - (height * (maxGoal / maxGoal))
        canvas.drawLine(padding, maxY, width - padding, maxY, goalPaint)
        canvas.drawText("Max Goal", padding, maxY - 10, textPaint)

        // Draw the graph line
        if (data.isNotEmpty()) {
            val stepX = (width - 2 * padding) / (data.size - 1)
            var prevX = padding
            var prevY = height - (height * (data[0] / maxGoal))

            for (i in 1 until data.size) {
                val x = padding + i * stepX
                val y = height - (height * (data[i] / maxGoal))
                canvas.drawLine(prevX, prevY, x, y, paint)
                prevX = x
                prevY = y
            }
        }
    }
}