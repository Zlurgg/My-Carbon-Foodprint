package uk.co.brightman.mycarbonfoodprint.database.meals

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "meal_table")
data class Meal(
    @PrimaryKey(autoGenerate = true)
    val mealId: Long = 0L,

    @ColumnInfo(name = "name")
    var name: String = "default_name",

    @ColumnInfo(name = "ingredients")
    var ingredients: List<String> =
        listOf("default_ingredient_one", "default_ingredient_two", "default_ingredient_three")
)