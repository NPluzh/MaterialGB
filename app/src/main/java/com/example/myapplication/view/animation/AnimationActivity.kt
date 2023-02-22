package com.example.myapplication.view.animation

import android.graphics.Rect
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.*
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityAnimationBinding


class AnimationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnimationBinding

    var isFlag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView.setOnClickListener {
            isFlag = !isFlag

            val params = it.layoutParams as LinearLayout.LayoutParams

            val transitionSet = TransitionSet()
            val changeImageTransform = ChangeImageTransform()
            val changeBounds = ChangeBounds()
            changeBounds.duration = 2000L
            changeImageTransform.duration = 2000L

            transitionSet.ordering = TransitionSet.ORDERING_TOGETHER

            transitionSet.addTransition(changeBounds)// важен порядок, обязетельно changeImageTransform после changeBounds
            transitionSet.addTransition(changeImageTransform)



            TransitionManager.beginDelayedTransition(binding.root, transitionSet)
            if (isFlag) {
                params.height = LinearLayout.LayoutParams.MATCH_PARENT
                binding.imageView.scaleType = ImageView.ScaleType.CENTER_CROP
            } else {
                params.height = LinearLayout.LayoutParams.WRAP_CONTENT
                binding.imageView.scaleType = ImageView.ScaleType.CENTER_INSIDE
            }
            binding.imageView.layoutParams = params
        }
    }


}