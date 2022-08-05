package com.example.habittracker
import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.habittracker.databinding.HabitRowsBinding

class HabitListAdapter(
    private val habitArray: ArrayList<Habit>
    ) : RecyclerView.Adapter<HabitListAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            HabitRowsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
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
            if (habitItem.isComplete) {
                Log.d(TAG, "$name is marked complete")
            } else {
                Log.d(TAG, "$name is marked incomplete")
            }
        }

        holder.editButton.setOnClickListener {
            Log.d(TAG, "Edit Button selected for $name...")
            HabitList.setPos(position)
            Navigation
                .createNavigateOnClickListener(R.id.action_FirstFragment_to_ThirdFragment).onClick(holder.editButton)
        }

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return habitArray.size
    }

    // Holds the views for adding it to image and text
    inner class ViewHolder(binding: HabitRowsBinding)
        : RecyclerView.ViewHolder(binding.root) {
        val textView: TextView = binding.habitItemName
        val checkBox: CheckBox = binding.itemCheckbox
        val editButton: ImageButton = binding.editButton
        }
}