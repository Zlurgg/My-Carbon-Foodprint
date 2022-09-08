package uk.co.brightman.mycarbonfoodprint.database

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import uk.co.brightman.mycarbonfoodprint.database.ingredients.Ingredient
import uk.co.brightman.mycarbonfoodprint.database.ingredients.IngredientDao
import uk.co.brightman.mycarbonfoodprint.database.meals.Meal
import uk.co.brightman.mycarbonfoodprint.database.meals.MealDao
import uk.co.brightman.mycarbonfoodprint.database.users.User
import uk.co.brightman.mycarbonfoodprint.database.users.UserDao
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class CarbonFoodprintDatabaseTest {

    private lateinit var userDao: UserDao
    private lateinit var ingredientDao: IngredientDao
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
        ingredientDao = db.ingredientDao
        mealDao = db.mealDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    /** create and check a default user fetch via id **/
    @Test
    @Throws(Exception::class)
    fun insertAndGetDefaultUser() {
        val user = User()
        userDao.insert(user)
        val oneUser = userDao.get(1L)
        Assert.assertEquals(oneUser?.emailAddress, "default_emailAddress")
        Assert.assertEquals(oneUser?.password, "default_password")
    }

    /** create and fetch a default ingredient fetch via id **/
    @Test
    @Throws(Exception::class)
    fun insertAndGetDefaultIngredient() {
        val ingredient = Ingredient()
        ingredientDao.insert(ingredient)
        val oneIngredient = ingredientDao.get(1L)
        Assert.assertEquals(oneIngredient?.name, "default_name")
        Assert.assertEquals(oneIngredient?.default, "domestic")
        Assert.assertEquals(oneIngredient?.cO2eValueDomestic, 0.00)
        Assert.assertEquals(oneIngredient?.cO2eValueInternational, 0.00)
    }

    /** create and fetch a default meal fetch via id **/
    @Test
    @Throws(Exception::class)
    fun insertAndGetDefaultMeal() {
        val meal = Meal()
        mealDao.insert(meal)
        val oneMeal = mealDao.get(1L)
        Assert.assertEquals(oneMeal?.name, "default_name")
        Assert.assertEquals(oneMeal?.ingredients, listOf("default_ingredient_one", "default_ingredient_two", "default_ingredient_three"))
    }
}