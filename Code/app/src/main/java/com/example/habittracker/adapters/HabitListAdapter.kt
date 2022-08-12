package com.example.habittracker.adapters
import android.content.ContentValues.TAG
import android.util.Half.toFloat
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.habittracker.datalayer.Habit
import com.example.habittracker.R
import com.example.habittracker.databinding.HabitRowsBinding
import com.example.habittracker.viewmodel.CurHabitViewModel
import com.example.habittracker.viewmodel.HabitListViewModel

class HabitListAdapter(
    /* No longer passes in project, but OnProjectListern instead */
    private val onHabitClickListener: OnHabitClickListener
)
/* Extends */
    : RecyclerView.Adapter<HabitListAdapter.ViewHolder>() {

    // need an MutableListOf to hold the projects once we get them back from the db
    private val habitArray: MutableList<Habit> = mutableListOf()


    // function to replace item in project list
    fun replaceItems(myHabits: List<Habit>) {
        habitArray.clear()
        habitArray.addAll(myHabits)
        notifyDataSetChanged()
    }

    // need to create interface for OnProjectListener
    interface OnHabitClickListener {
        fun onHabitClick(habit: Habit)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(HabitRowsBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))

    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val habitItem = habitArray[position]

        // sets the name to the textView from our itemHolder class
        val name = habitItem.name
        holder.textView.text = name
        holder.checkBox.isChecked = habitItem.isComplete

        holder.checkBox.setOnClickListener{
            habitItem.isComplete = holder.checkBox.isChecked
            onHabitClickListener.onHabitClick(habitItem)
            if (habitItem.isComplete) {
                Log.d(TAG, "$name is marked complete")
            } else {
                Log.d(TAG, "$name is marked incomplete")
            }
        }

        holder.editButton.setOnClickListener {
            Log.d(TAG, "Edit Button selected for $name...")
            onHabitClickListener.onHabitClick(habitItem)
            Navigation
                .createNavigateOnClickListener(R.id.action_FirstFragment_to_ThirdFragment).onClick(holder.editButton)
        }

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return habitArray.size
    }

    fun getHabit(pos: Int): Habit {
        if (habitArray.size > 0) {
            return habitArray[pos]
        } else {
            return Habit(
                0,
                "",
                "",
                toFloat(0),
                "0:00",
                false)
        }
    }


    // Holds the views for adding it to image and text
    inner class ViewHolder(binding: HabitRowsBinding)
        : RecyclerView.ViewHolder(binding.root) {
        val textView: TextView = binding.habitItemName
        val checkBox: CheckBox = binding.itemCheckbox
        val editButton: ImageButton = binding.editButton
        }
}