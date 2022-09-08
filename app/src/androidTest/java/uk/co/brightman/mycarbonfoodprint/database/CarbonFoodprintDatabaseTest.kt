package uk.co.brightman.mycarbonfoodprint.database

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import uk.co.brightman.mycarbonfoodprint.database.meals.Meal
import uk.co.brightman.mycarbonfoodprint.database.meals.MealDao
import uk.co.brightman.mycarbonfoodprint.database.users.User
import uk.co.brightman.mycarbonfoodprint.database.users.UserDao
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class CarbonFoodprintDatabaseTest {

    private lateinit var userDao: UserDao
    private lateinit var mealDao: MealDao
    private lateinit var db: CarbonFoodPrintDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        db = Room.inMemoryDatabaseBuilder(context, CarbonFoodPrintDatabase::class.java)
            // Allowing main thread queries, just for testing.
            .allowMainThreadQueries()
            .build()
        userDao = db.userDao
        mealDao = db.mealDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetUser() {
        val user = User()
        userDao.insert(user)
        val oneUser = userDao.getSingleUser()
        Assert.assertEquals(oneUser?.userId, 1)
    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetMeal() {
        val meal = Meal()
        mealDao.insert(meal)
        val oneMeal = mealDao.getSingleMeal()
        Assert.assertEquals(oneMeal?.mealId, 1)
    }
}