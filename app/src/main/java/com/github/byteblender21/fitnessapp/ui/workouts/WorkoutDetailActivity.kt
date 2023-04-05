package com.github.byteblender21.fitnessapp.ui.workouts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.byteblender21.fitnessapp.databinding.ActivityWorkoutDetailBinding
import com.google.android.material.snackbar.Snackbar

class WorkoutDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWorkoutDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWorkoutDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
}