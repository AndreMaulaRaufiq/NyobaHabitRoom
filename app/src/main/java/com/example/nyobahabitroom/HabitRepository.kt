package com.example.nyobahabitroom

class HabitRepository(private val habitDao: HabitDao) {
    fun allHabits() = habitDao.getHabit()
    fun getPlant(habitId: String) = habitDao.getHabitById(habitId)

    companion object {
        @Volatile private var instance: HabitRepository? = null

        fun getInstance(plantDao: HabitDao) =
            instance ?: synchronized(this) {
                instance ?: HabitRepository(plantDao).also { instance = it }
            }
    }
}