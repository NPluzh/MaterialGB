package com.example.myapplication.view.animation

import android.os.Bundle
import android.view.animation.AnticipateOvershootInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.transition.*
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityAnimationStartBinding


class AnimationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnimationStartBinding

    var isFlag = false
    var duration = 1000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationStartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val constraintSetStart = ConstraintSet()
        val constraintSetEnd = ConstraintSet()
        //constraintSetStart.clone(binding.constraintContainer)
        constraintSetStart.clone(this,R.layout.activity_animation_start)
        constraintSetEnd.clone(this,R.layout.activity_animation_end)

        binding.tap.setOnClickListener {
            isFlag = !isFlag

            val changeBounds = ChangeBounds()
            changeBounds.duration = 1000L
            changeBounds.interpolator = AnticipateOvershootInterpolator(5.0f)
            TransitionManager.beginDelayedTransition(binding.constraintContainer,changeBounds)
            if(isFlag){
                constraintSetEnd.applyTo(binding.constraintContainer)
            }else{
                constraintSetStart.applyTo(binding.constraintContainer)
            }
        }
    }


}