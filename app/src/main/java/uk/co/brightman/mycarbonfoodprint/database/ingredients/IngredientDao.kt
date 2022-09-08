package uk.co.brightman.mycarbonfoodprint.database.ingredients

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface IngredientDao {
    @Insert
    fun insert(ingredient: Ingredient)

    @Update
    fun update(ingredient: Ingredient)

    @Query("SELECT * from ingredient_table WHERE ingredientId = :key")
    fun get(key: Long): Ingredient?

    @Query("DELETE FROM ingredient_table")
    fun clear()

    @Query("SELECT * FROM ingredient_table ORDER BY name DESC")
    fun getAllIngredients(): LiveData<List<Ingredient>>
}