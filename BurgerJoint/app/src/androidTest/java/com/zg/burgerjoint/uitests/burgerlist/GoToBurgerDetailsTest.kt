package com.zg.burgerjoint.uitests.burgerlist

import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.zg.burgerjoint.R
import com.zg.burgerjoint.activities.MainActivity
import com.zg.burgerjoint.viewholders.BurgerViewHolder
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class GoToBurgerDetailsTest {

    private val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Before
    open fun setUp() {
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun tapOnBurger_navigateToBurgerDetails() {
        Espresso.onView(ViewMatchers.withId(R.id.rvBurgerList))
            .perform(RecyclerViewActions.actionOnItemAtPosition<BurgerViewHolder>
                (0,ViewActions.click()))
        Espresso.onView(ViewMatchers.withId(R.id.tvDescription))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}