package com.example.myapplication.utils

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.example.myapplication.view.layouts.behaviors.ButtonBehavior

class MyImageView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyle: Int = 0
) : AppCompatImageView(context, attributeSet, defStyle), CoordinatorLayout.AttachedBehavior {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec)
    }

    override fun getBehavior(): CoordinatorLayout.Behavior<*> {
        return  ButtonBehavior(context) // 3 способ
    }
}