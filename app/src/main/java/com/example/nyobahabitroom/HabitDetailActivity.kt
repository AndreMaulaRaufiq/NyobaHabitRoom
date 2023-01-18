package com.example.nyobahabitroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class HabitDetailActivity : AppCompatActivity() {


    companion object {
        const val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_habit_detail)
        supportActionBar?.hide()
        val habit = intent.getParcelableExtra<Habit>(HabitList.INTENT_PARCELABLE)

        val habitImg = findViewById<ImageView>(R.id.ivDetailHabit)
        habitImg.setImageResource(habit?.image!!)
        val habitDescription = findViewById<TextView>(R.id.textView_habitdetail)
        habitDescription.text = habit.description

        var quantity = 1
        val btn_increase_quantity = findViewById<ImageButton>(R.id.desc_quantity_increase)
        val btn_decrease_quantity = findViewById<ImageButton>(R.id.desc_quantity_decrease)
        val desc_quantity_value = findViewById<TextView>(R.id.desc_quantity_value)

        btn_increase_quantity.setOnClickListener {
            quantity++
            desc_quantity_value.text = quantity.toString()
        }
        btn_decrease_quantity.setOnClickListener {
            quantity--
            desc_quantity_value.text = quantity.toString()
        }

//        val mFragmentManager = supportFragmentManager
//        val mFragmentTransaction = mFragmentManager.beginTransaction()
//        val mFragment = HabitTrack()
//
//        val mBundle = Bundle()
//        mBundle.putString("mText",habitDescription.text.toString())
//        mBundle.putInt("mImage",habitImg.id)
//        mFragment.arguments = mBundle
//        mFragmentTransaction.add(R.id.rv_habits, mFragment).commit()

    }
}