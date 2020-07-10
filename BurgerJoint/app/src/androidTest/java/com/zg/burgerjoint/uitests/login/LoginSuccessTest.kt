package com.zg.burgerjoint.uitests.login

import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.zg.burgerjoint.R
import com.zg.burgerjoint.activities.LoginActivity
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
open class LoginSuccessTest {

    private val activityTestRule = ActivityTestRule<LoginActivity>(LoginActivity::class.java)

    @Before
    open fun setUp(){
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun checkLoginButtonIsDisplayed() {
        Espresso.onView(ViewMatchers.withId(R.id.btnLogin))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun enterInformation_navigateToMainScreen(){
        Espresso.onView(ViewMatchers.withId(R.id.etUserName)).perform(
            ViewActions.typeText(TEST_USER_NAME),
            ViewActions.closeSoftKeyboard()
        )
        Espresso.onView(ViewMatchers.withId(R.id.etPassword)).perform(
            ViewActions.typeText(TEST_PASSWORD),
            ViewActions.closeSoftKeyboard()
        )
        Espresso.onView(ViewMatchers.withId(R.id.btnLogin)).perform(ViewActions.click())
        Espresso.onView((ViewMatchers.withId(R.id.rvBurgerList)))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    companion object {
        const val TEST_USER_NAME = "Pyae Thet Htar"
        const val TEST_PASSWORD = "123456"
    }
}