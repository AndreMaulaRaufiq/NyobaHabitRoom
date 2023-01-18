package com.example.nyobahabitroom

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import java.text.SimpleDateFormat
import java.util.*

class HabitTrack : Fragment() {

    companion object {
        const val INTENT_PARCELABLE = "OBJECT_INTENT"
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_habit_track, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textViewdate: TextView = view.findViewById(R.id.habit_track_date)
        val textViewday: TextView = view.findViewById(R.id.habit_track_day)
        val simpleDayFormat = SimpleDateFormat("EEEE", Locale.getDefault())
        val simpleDateFormat = SimpleDateFormat("dd MM yyyy", Locale.getDefault())
        val currentDate: String = simpleDateFormat.format(Date())
        textViewdate.text = currentDate
        val currentDay: String = simpleDayFormat.format(Date())
        textViewday.text = currentDay

        val habit = arguments?.getParcelable<Habit>(HabitDetailActivity.INTENT_PARCELABLE)

        val bundle = arguments
        val message = bundle!!.getString("mText")
        val img = bundle!!.getInt("mImage")

        val habitImg = view.findViewById<ImageView>(R.id.ivDetailHabit)
        habitImg.setImageResource(habit?.image!!)
        val habitDescription = view.findViewById<TextView>(R.id.textView_habitdetail)
        habitDescription.text = habit.description

        val btn_add = view.findViewById<ImageView>(R.id.fab_add)
        btn_add.setOnClickListener {
            startActivity(Intent(activity, HabitList::class.java))
        }
    }
}