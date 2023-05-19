package com.rohim.skillifyapp.ui.customview

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.Patterns
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import com.rohim.skillifyapp.R

class InputEmail : AppCompatEditText {
    private lateinit var emailImage: Drawable
    private var isEmailValid: Boolean = false

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
        emailImage = ContextCompat.getDrawable(context, R.drawable.baseline_email_24) as Drawable
        onShowVisibilityIcon(emailImage)

        addTextChangedListener(onTextChanged = {p0: CharSequence?, p1: Int, p2: Int, p3: Int ->
            val email = text?.trim()
            if (email.isNullOrEmpty()) {
                isEmailValid = false
                error = resources.getString(R.string.input_email)
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                isEmailValid = false
                error = resources.getString(R.string.invalid_email)
            } else {
                isEmailValid = true
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