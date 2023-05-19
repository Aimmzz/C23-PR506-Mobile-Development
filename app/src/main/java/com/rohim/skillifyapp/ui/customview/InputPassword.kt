package com.rohim.skillifyapp.ui.customview

import android.content.Context
import android.graphics.drawable.Drawable
import android.text.method.PasswordTransformationMethod
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import com.rohim.skillifyapp.R

class InputPassword : AppCompatEditText {
    private lateinit var lockImage: Drawable
    private var isPassValid: Boolean = false

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    private fun init() {
        lockImage = ContextCompat.getDrawable(context, R.drawable.baseline_lock_24) as Drawable
        transformationMethod = PasswordTransformationMethod.getInstance()
        onShowVisibilityIcon(lockImage)

        addTextChangedListener(onTextChanged = {p0: CharSequence?, p1: Int, p2: Int, p3: Int ->
            val pass = text?.trim()
            when {
                pass.isNullOrEmpty() -> {
                    isPassValid = false
                    error = resources.getString(R.string.input_pass)
                }
                pass.length < 6 -> {
                    isPassValid = false
                    error = resources.getString(R.string.pass_length)
                }
                else -> {
                    isPassValid = true
                }
            }
        })
    }

    private fun onShowVisibilityIcon(icon: Drawable) {
        setButtonDrawables(startOfTheText = icon)
    }

    private fun setButtonDrawables(
        startOfTheText: Drawable? = null,
        topOfTheText: Drawable? = null,
        endOfTheText: Drawable? = null,
        bottomOfTheText: Drawable? = null
    ) {
        setCompoundDrawablesWithIntrinsicBounds(
            startOfTheText,
            topOfTheText,
            endOfTheText,
            bottomOfTheText
        )

    }
}