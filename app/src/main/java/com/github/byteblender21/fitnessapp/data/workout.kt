package com.github.byteblender21.fitnessapp.data

data class Exercise(var name: String, var repetitions: Int, var weight: Int)

data class Workout(var exercises: List<Exercise>)