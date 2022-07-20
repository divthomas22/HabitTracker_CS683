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
    private lateinit var nameEdit: EditText
    private lateinit var descEdit: EditText
    private lateinit var priorityEdit: RatingBar
    private lateinit var timeEdit : EditText

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

        binding.cancel.setOnClickListener {
            Log.d(TAG, "OPERATION CANCELLED - No data saved")
            Log.d(TAG, "Navigating back to Habit List...")
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        binding.submit.setOnClickListener {
            Log.d(TAG, "Submitted! Saving data...")
            Log.d(TAG, "Navigating back to Habit List...")
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}