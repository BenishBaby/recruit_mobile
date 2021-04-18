package com.asb.mobiletest

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.asb.mobiletest.ui.MainActivity
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class ExampleInstrumentedTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.asb.mobiletest", appContext.packageName)
    }

    @Test
    fun testMainScreenUI(){
        onView(withId(R.id.recyclerview_transactions)).perform(ViewActions.swipeUp())
        Thread.sleep(1000)
        onView(withId(R.id.recyclerview_transactions)).perform(ViewActions.swipeDown())
        Thread.sleep(1000)
        onView(withId(R.id.recyclerview_transactions)).perform(ViewActions.swipeUp())
        Thread.sleep(1000)
        onView(withId(R.id.recyclerview_transactions)).perform(ViewActions.swipeDown())
        Thread.sleep(1000)

        onView(withId(R.id.recyclerview_transactions)).check(matches(withViewAtPosition(1, hasDescendant(allOf(withId(R.id.transaction_id), isDisplayed()))))).perform(
            click()
        )
        Thread.sleep(1000)



    }


    private fun withViewAtPosition(position: Int, itemMatcher: Matcher<View?>): Matcher<View?>? {
        return object : BoundedMatcher<View?, RecyclerView>(RecyclerView::class.java) {
            override fun describeTo(description: Description?) {
                itemMatcher.describeTo(description)
            }

            override fun matchesSafely(recyclerView: RecyclerView): Boolean {
                val viewHolder = recyclerView.findViewHolderForAdapterPosition(position)
                return viewHolder != null && itemMatcher.matches(viewHolder.itemView)
            }
        }
    }


}