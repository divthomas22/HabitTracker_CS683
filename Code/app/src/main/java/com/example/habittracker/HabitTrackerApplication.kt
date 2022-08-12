package com.example.habittracker

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.habittracker.datalayer.HabitsDatabase

class HabitTrackerApplication : Application() {
    lateinit var habitsDatabase: HabitsDatabase
    lateinit var habitTrackerRepository: HabitTrackerRepository
    override fun onCreate() {
        super.onCreate()

        habitsDatabase = Room.databaseBuilder(
            applicationContext, HabitsDatabase::class.java,
            "habittracker-db"
        )
            .addCallback(object : RoomDatabase.Callback() {
            })
            .build()

        habitTrackerRepository = HabitTrackerRepository(habitsDatabase.habitDao())
    }


}