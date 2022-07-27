package com.example.habittracker

data class Habit(
    var name: String, var description: String,
    var priority: Float, var remindTime: String, var isComplete: Boolean)
