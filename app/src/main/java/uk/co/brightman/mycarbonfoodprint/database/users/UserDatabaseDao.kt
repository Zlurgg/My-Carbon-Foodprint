package uk.co.brightman.mycarbonfoodprint.database.users

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDatabaseDao {
    @Insert
    fun insert(user: User)

    @Update
    fun update(user: User)

    @Query("SELECT * from user_table WHERE userId = :key")
    fun get(key: Long): User?

    @Query("DELETE FROM user_table")
    fun clear()

    @Query("SELECT * FROM user_table ORDER BY userId DESC LIMIT 1")
    fun getSingleUser(): User?

    @Query("SELECT * FROM user_table ORDER BY email_address DESC")
    fun getAllUsers(): LiveData<List<User>>
}