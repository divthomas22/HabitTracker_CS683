package com.example.habittracker

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.RatingBar
import androidx.navigation.fragment.findNavController
import com.example.habittracker.databinding.CreateHabitBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class CreateHabit : Fragment() {

    private var _binding: CreateHabitBinding? = null
    private lateinit var nameCreate: EditText
    private lateinit var descCreate: EditText
    private lateinit var priorityCreate: RatingBar
    private lateinit var reminderCreate : EditText

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = CreateHabitBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nameCreate = view.findViewById(R.id.nameCreate)
        descCreate =  view.findViewById(R.id.descCreate)
        priorityCreate = view.findViewById(R.id.createPriority)
        reminderCreate = view.findViewById(R.id.createReminder)

        binding.cancel.setOnClickListener {
            Log.d(TAG, "OPERATION CANCELLED - No data saved")
            Log.d(TAG, "Navigating back to Habit List...")
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        binding.submit.setOnClickListener {
            Log.d(TAG, "Submitted! Saving data...")

            val name = nameCreate.text.toString()
            Log.d(TAG, "Habit name: $name")

            val desc = descCreate.text.toString()
            Log.d(TAG, "Habit Description: $desc")

            val priority = priorityCreate.rating
            Log.d(TAG, "Habit Priority: $priority")

            val reminder = reminderCreate.text.toString()
            Log.d(TAG, "Habit Reminder: $reminder")

            val newHabit = Habit(name, desc, priority, reminder, false)
            val i = HabitList.saveHabit(newHabit)
            Log.d(TAG, "New Habit saved at index $i : " + HabitList.getHabit(i))

            Log.d(TAG, "Navigating back to Habit List...")
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}