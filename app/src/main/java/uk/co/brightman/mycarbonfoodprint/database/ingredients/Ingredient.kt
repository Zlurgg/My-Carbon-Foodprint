package uk.co.brightman.mycarbonfoodprint.database.ingredients

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ingredient_table")
data class Ingredient(
    @PrimaryKey(autoGenerate = true)
    var ingredientId: Long = 0L,

    @ColumnInfo(name = "name")
    var name: String = "default_name",

    @ColumnInfo(name = "default")
    var default: String = "domestic",

    @ColumnInfo(name = "domestic")
    var cO2eValueDomestic: Double = 0.00,

    @ColumnInfo(name = "international")
    var cO2eValueInternational: Double = 0.00
)