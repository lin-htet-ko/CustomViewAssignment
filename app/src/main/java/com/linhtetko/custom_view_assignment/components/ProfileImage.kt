package com.linhtetko.custom_view_assignment.components

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.withStyledAttributes
import com.linhtetko.custom_view_assignment.R

class ProfileImage @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : AppCompatImageView(context, attrs) {

    private var radius = 0f
    private var strokeColor = Color.WHITE
    private var strokeWidth = 0f
    private val paint = Paint().apply {
        color = Color.WHITE
    }
    private val path = Path()

    init {
        context.withStyledAttributes(attrs, R.styleable.ProfileImage){
            strokeColor = getColor(R.styleable.ProfileImage_strokeColor, strokeColor)
            strokeWidth = getDimension(R.styleable.ProfileImage_strokeWidth, 0f)
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        radius = measuredWidth.coerceAtMost(measuredHeight) / 2f
    }


    override fun onDraw(canvas: Canvas?) {

        val react = RectF(0f, 0f, width.toFloat(), height.toFloat())
        path.addRoundRect(react, radius, radius, Path.Direction.CCW)

        canvas?.clipPath(path)

        super.onDraw(canvas)

        paint.style = Paint.Style.STROKE
        paint.strokeWidth = strokeWidth
        paint.color = strokeColor
        val strokeRect = RectF(0f, 0f, width.toFloat() , height.toFloat())
        canvas?.drawOval(strokeRect, paint)
    }
}