package com.example.myapplication.view.layouts.behaviors

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.example.myapplication.R

class ButtonBehavior(context: Context, attrs: AttributeSet?=null): CoordinatorLayout.Behavior<View>(context,attrs)  {

    override fun layoutDependsOn(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {
        return (dependency.id == R.id.bottomSheetContainer)
    }


    override fun onDependentViewChanged(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {
        if(dependency.id ==R.id.bottomSheetContainer){
            Log.d("@@@","${dependency.y} ${dependency.height}")
            child.y = dependency.y -300
        }
        return super.onDependentViewChanged(parent, child, dependency)
    }
}