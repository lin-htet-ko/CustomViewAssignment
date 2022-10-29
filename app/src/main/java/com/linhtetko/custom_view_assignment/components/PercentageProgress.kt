package com.linhtetko.custom_view_assignment.components

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import androidx.core.content.withStyledAttributes
import com.linhtetko.custom_view_assignment.R

class PercentageProgress @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet?,
) : View(context, attrs) {

    private var radius = 0f
    private var backgroundPaint = Paint().apply {
        color = context?.resources?.getColor(R.color.colorPrimaryTransparent)
            ?: Color.parseColor("#80F26950")
        style = Paint.Style.STROKE
        strokeCap = Paint.Cap.ROUND
    }
    private var progressPaint = Paint().apply {
        color = context?.resources?.getColor(R.color.colorPrimary) ?: Color.parseColor("#FFF26950")
        style = Paint.Style.STROKE
        strokeCap = Paint.Cap.ROUND
    }
    private val textPaint = Paint().apply {
        color = Color.WHITE
        textSize = 30f
        textAlign = Paint.Align.CENTER
        isFakeBoldText = true
    }
    var progress = 0

    var outerStrokeWidth = 0f
    var innerStrokeWidth = 0f

    init {
        context?.withStyledAttributes(attrs, R.styleable.PercentageProgress) {
            backgroundPaint.apply {
                color = getColor(
                    R.styleable.PercentageProgress_outerStrokeColor,
                    Color.parseColor("#80F26950")
                )
                outerStrokeWidth = getDimension(R.styleable.PercentageProgress_outerStrokeWidth, 6f)
                strokeWidth = outerStrokeWidth
            }
            progressPaint.apply {
                color = getColor(
                    R.styleable.PercentageProgress_innerStrokeColor,
                    Color.parseColor("#FFF26950")
                )
                innerStrokeWidth = getDimension(R.styleable.PercentageProgress_innerStrokeWidth, 6f)
                strokeWidth = innerStrokeWidth
            }
            textPaint.apply {
                color = getColor(
                    R.styleable.PercentageProgress_textColor,
                    Color.parseColor("#FFF26950")
                )
                textSize = getDimension(R.styleable.PercentageProgress_textSize, 30f)
            }
            progress = getInteger(R.styleable.PercentageProgress_progress, progress)

        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        radius = measuredWidth.coerceAtMost(measuredHeight) / 2f
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val outRect = RectF(
            outerStrokeWidth / 2f,
            outerStrokeWidth / 2f,
            width.toFloat() - 3,
            height.toFloat() - 3
        )
        canvas?.drawArc(outRect, 0f, 360f, false, backgroundPaint)

        val rect = RectF(
            outerStrokeWidth / 2f,
            outerStrokeWidth / 2f,
            width.toFloat() - 3,
            height.toFloat() - 3
        )

        val progressPercent = 360 * (progress / 100f)
        canvas?.drawArc(rect, 270f, progressPercent, false, progressPaint)

        canvas?.drawText(
            "$progress %",
            (width.toFloat()) / 2,
            (height.toFloat() - (textPaint.descent() + textPaint.ascent())) / 2,
            textPaint
        )
    }
}