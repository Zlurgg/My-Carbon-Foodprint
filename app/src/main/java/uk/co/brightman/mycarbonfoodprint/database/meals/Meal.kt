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
        listOf("default_ingredient_one", "default_ingredient_two", "default_ingredient_three"),

    /** should meals have a stored co2e to save calculating it on the fly each time **/
    @ColumnInfo(name = "CO2eValue")
    var c02eValue: Double = 0.00
)