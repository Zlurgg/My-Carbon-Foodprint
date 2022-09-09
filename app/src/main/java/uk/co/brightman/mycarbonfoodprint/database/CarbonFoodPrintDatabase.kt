package uk.co.brightman.mycarbonfoodprint.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import uk.co.brightman.mycarbonfoodprint.database.equivalences.Equivalence
import uk.co.brightman.mycarbonfoodprint.database.equivalences.EquivalenceDao
import uk.co.brightman.mycarbonfoodprint.database.ingredients.Ingredient
import uk.co.brightman.mycarbonfoodprint.database.ingredients.IngredientDao
import uk.co.brightman.mycarbonfoodprint.database.meals.Meal
import uk.co.brightman.mycarbonfoodprint.database.meals.MealDao
import uk.co.brightman.mycarbonfoodprint.database.users.User
import uk.co.brightman.mycarbonfoodprint.database.users.UserDao
import uk.co.brightman.mycarbonfoodprint.util.Converters

@Database(entities = [User::class, Ingredient::class, Meal::class, Equivalence::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class CarbonFoodPrintDatabase: RoomDatabase() {

    abstract val userDao: UserDao
    abstract val ingredientDao: IngredientDao
    abstract val mealDao: MealDao
    abstract val equivalenceDao: EquivalenceDao

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