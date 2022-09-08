package uk.co.brightman.mycarbonfoodprint.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uk.co.brightman.mycarbonfoodprint.database.meals.Meal
import uk.co.brightman.mycarbonfoodprint.database.meals.MealDao
import uk.co.brightman.mycarbonfoodprint.database.users.User
import uk.co.brightman.mycarbonfoodprint.database.users.UserDao

@Database(entities = [User::class, Meal::class], version = 1, exportSchema = false)
abstract class CarbonFoodPrintDatabase: RoomDatabase() {

    abstract val userDao: UserDao
    abstract val mealDao: MealDao

    companion object {
        @Volatile
        private var INSTANCE: CarbonFoodPrintDatabase? = null

        fun getInstance(context: Context): CarbonFoodPrintDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CarbonFoodPrintDatabase::class.java,
                        "carbon_foodprint_database")
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}