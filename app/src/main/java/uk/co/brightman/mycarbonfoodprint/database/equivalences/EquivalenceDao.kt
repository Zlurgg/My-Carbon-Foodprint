package uk.co.brightman.mycarbonfoodprint.database.equivalences

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface EquivalenceDao {
    @Insert
    fun insert(equivalence: Equivalence)

    @Update
    fun update(equivalence: Equivalence)

    @Query("SELECT * from equivalence_table WHERE equivalenceId = :key")
    fun get(key: Long): Equivalence?

    @Query("DELETE FROM equivalence_table")
    fun clear()

    @Query("SELECT * FROM equivalence_table ORDER BY name DESC")
    fun getAllMeals(): LiveData<List<Equivalence>>

}