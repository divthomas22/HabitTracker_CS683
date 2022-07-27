
import android.content.ContentValues
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.habittracker.Habit
import com.example.habittracker.databinding.HabitRowsBinding

class HabitListAdapter(private val habitArray: ArrayList<Habit>) : RecyclerView.Adapter<HabitListAdapter.ViewHolder>() {

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
        holder.textView.text = habitItem.name
        holder.checkBox.isChecked = habitItem.isComplete

        holder.checkBox.setOnClickListener{
            val name = habitItem.name
            habitItem.isComplete = holder.checkBox.isChecked
            if (habitItem.isComplete == true) {
                Log.d(ContentValues.TAG, "$name is marked complete")
            } else {
                Log.d(ContentValues.TAG, "$name is marked incomplete")
            }
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
        }
}