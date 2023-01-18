package com.example.nyobahabitroom

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface HabitDao {
    @Query("SELECT * FROM habit_table")
    fun getHabit(): List<Habit>

    @Query("SELECT * FROM habit_table WHERE id = :habitId")
    fun getHabitById(habitId: String): Habit

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(habit: List<Habit>)

    @Update
    suspend fun update(habit: Habit)

    @Delete
    suspend fun delete(habit: Habit)
}