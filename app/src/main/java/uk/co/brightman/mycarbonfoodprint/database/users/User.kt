package uk.co.brightman.mycarbonfoodprint.database.users

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    var userId: Long = 0L,

    @ColumnInfo(name = "email_address")
    val emailAddress: String = "",

    @ColumnInfo(name = "password")
    val password: String = ""
)