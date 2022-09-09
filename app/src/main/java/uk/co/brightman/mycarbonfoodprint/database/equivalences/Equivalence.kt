package uk.co.brightman.mycarbonfoodprint.database.equivalences

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "equivalence_table")
data class Equivalence(
    @PrimaryKey(autoGenerate = true)
    val equivalenceId: Long = 0L,

    @ColumnInfo(name = "name")
    var name: String = "default_name",

    @ColumnInfo(name = "type")
    var type: String = "default_type",

    @ColumnInfo(name = "unit")
    var unit: String = "default_unit",

    @ColumnInfo(name = "value")
    var value: Double = 0.00
)