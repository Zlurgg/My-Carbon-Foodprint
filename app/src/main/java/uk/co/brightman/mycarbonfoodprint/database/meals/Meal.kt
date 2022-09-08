package uk.co.brightman.mycarbonfoodprint.database.meals

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "meal_table")
data class Meal(
    @PrimaryKey(autoGenerate = true)
    var mealId: Long = 0L,

    @ColumnInfo(name = "name")
    val name: String = "default_name",

    @ColumnInfo(name = "ingredients")
    val ingredients: List<String> =
        listOf("default_ingredient_one", "default_ingredient_two", "default_ingredient_three")
)