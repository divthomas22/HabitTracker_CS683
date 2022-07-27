package com.example.habittracker

import HabitListAdapter
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.habittracker.databinding.HabitListBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HabitList : Fragment() {

    companion object {

        private var habitArray: ArrayList<Habit> = ArrayList()

        fun saveHabit(newHabit: Habit): Int {
            habitArray.add(newHabit)
            return habitArray.indexOf(newHabit)
        }

        fun getHabit(i : Int): Habit {
            return habitArray.get(i)
        }

        fun deleteHabit(habit : Habit){
            habitArray.remove(habit)
        }
    }

        private var _binding: HabitListBinding? = null


        // This property is only valid between onCreateView and
        // onDestroyView.
        private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = HabitListBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView?.apply{
            adapter = HabitListAdapter(habitArray)
            if (habitArray.size > 0){
                binding.emptyView.text = ""
            } else {
                binding.emptyView.text = "No Habits yet! Create one! ->"
            }
        }

        binding.addHabit.setOnClickListener {
            Log.d(TAG, "Create Habit Button selected.")
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}