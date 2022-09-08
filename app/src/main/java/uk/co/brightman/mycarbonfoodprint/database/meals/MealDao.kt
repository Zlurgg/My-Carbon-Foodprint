package uk.co.brightman.mycarbonfoodprint.database.meals

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface MealDao {
    @Insert
    fun insert(meal: Meal)

    @Update
    fun update(meal: Meal)

    @Query("SELECT * from meal_table WHERE mealId = :key")
    fun get(key: Long): Meal?

    @Query("DELETE FROM meal_table")
    fun clear()

    @Query("SELECT * FROM meal_table ORDER BY name DESC")
    fun getAllMeals(): LiveData<List<Meal>>

}