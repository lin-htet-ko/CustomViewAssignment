package com.linhtetko.custom_view_assignment.components

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.content.withStyledAttributes
import com.linhtetko.custom_view_assignment.R

class LinearProgressbar @JvmOverloads constructor(context: Context?, attrs: AttributeSet?) :
    View(context, attrs) {
    private val secondaryPaint = Paint().apply {
        color = Color.parseColor("#802CC09C")
    }
    private val primaryPaint = Paint().apply {
        color = Color.parseColor("#2cc09c")
    }
    var progress = 0f

    init {
        context?.withStyledAttributes(attrs, R.styleable.LinearProgressbar) {
            progress = getInteger(R.styleable.LinearProgressbar_linearProgress, 0).toFloat()
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        setMeasuredDimension(w, h)
    }

    override fun onDraw(canvas: Canvas?) {

        canvas?.drawRect(Rect(0, 0, width, height), secondaryPaint)
        canvas?.drawRect(RectF(0f, 0f, width * (progress / 100f), height.toFloat()), primaryPaint)

        super.onDraw(canvas)
    }
}