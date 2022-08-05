package com.example.habittracker

import android.content.ContentValues.TAG
import android.content.Context
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
import com.example.habittracker.databinding.EditHabitBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class EditHabit : Fragment() {


    private var _binding: EditHabitBinding? = null
    private lateinit var nameEdit: EditText
    private lateinit var descEdit: EditText
    private lateinit var priorityEdit: RatingBar
    private lateinit var reminderEdit : EditText
    private var position : Int = HabitList.getPos()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = EditHabitBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nameEdit = view.findViewById(R.id.nameEdit)
        descEdit =  view.findViewById(R.id.descEdit)
        priorityEdit = view.findViewById(R.id.editPriority)
        reminderEdit = view.findViewById(R.id.editReminder)

        nameEdit.setText(HabitList.getHabit(position).name)
        descEdit.setText(HabitList.getHabit(position).description)
        priorityEdit.rating = HabitList.getHabit(position).priority
        reminderEdit.setText(HabitList.getHabit(position).remindTime)

        binding.delete.setOnClickListener {
            HabitList.deleteHabit(position)
            Log.d(TAG, "DELETE BUTTON SELECTED")
            Log.d(TAG, "Navigating back to Habit List...")
            findNavController().navigate(R.id.action_ThirdFragment_to_FirstFragment)
        }

        binding.save.setOnClickListener {
            Log.d(TAG, "Submitted! Saving data...")

            val name = nameEdit.text.toString()
            HabitList.getHabit(position).name = name
            Log.d(TAG, "Habit name: $name")

            val desc = descEdit.text.toString()
            HabitList.getHabit(position).description = desc
            Log.d(TAG, "Habit Description: $desc")

            val priority = priorityEdit.rating
            HabitList.getHabit(position).priority = priority
            Log.d(TAG, "Habit Priority: $priority")

            val reminder = reminderEdit.text.toString()
            HabitList.getHabit(position).remindTime = reminder
            Log.d(TAG, "Habit Reminder: $reminder")

            Log.d(TAG, "Habit updated at index $position : " + HabitList.getHabit(position))

            Log.d(TAG, "Navigating back to Habit List...")
            findNavController().navigate(R.id.action_ThirdFragment_to_FirstFragment)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}