package com.rohim.skillifyapp.ui.customview

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton

class CustomButton : AppCompatButton {

    constructor(context: Context) : super(context) {}
    constructor(context: Context, attrs: AttributeSet ) : super(context, attrs) {}
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }
}