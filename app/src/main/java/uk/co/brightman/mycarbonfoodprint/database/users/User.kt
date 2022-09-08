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
    var password: String = "default_password"
)