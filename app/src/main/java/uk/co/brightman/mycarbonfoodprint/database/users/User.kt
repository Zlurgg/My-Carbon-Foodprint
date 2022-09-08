package uk.co.brightman.mycarbonfoodprint.database.users

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    var userId: String = UUID.randomUUID().toString(),

    @ColumnInfo(name = "email_address")
    val emailAddress: String = "default_emailaddress",

    @ColumnInfo(name = "password")
    val password: String = "default_password"
)