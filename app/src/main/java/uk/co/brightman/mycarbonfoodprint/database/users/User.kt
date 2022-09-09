package uk.co.brightman.mycarbonfoodprint.database.users

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val userId: Long = 0L,

    @ColumnInfo(name = "email_address")
    var emailAddress: String = "default_emailAddress",

    @ColumnInfo(name = "password")
    var password: String = "default_password",

    /** Should these be stored in a separate table referenced by this one **/
    @ColumnInfo(name = "daily_cO2e_value_breakfast")
    var dailyCO2eValueBreakfast: Double = 0.00,

    @ColumnInfo(name = "daily_cO2e_value_lunch")
    var dailyCO2eValueLunch: Double = 0.00,

    @ColumnInfo(name = "daily_cO2e_value_dinner")
    var dailyCO2eValueDinner: Double = 0.00,

    @ColumnInfo(name = "daily_cO2e_value_total")
    var dailyCO2eValueTotal: Double = 0.00
)