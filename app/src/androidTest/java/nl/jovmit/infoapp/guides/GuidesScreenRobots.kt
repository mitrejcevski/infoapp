package nl.jovmit.infoapp.guides

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import nl.jovmit.infoapp.R
import nl.jovmit.infoapp.toolbarWithTitle

fun guidesScreen(block: GuidesScreenRobot.() -> Unit): GuidesScreenRobot {
    return GuidesScreenRobot().apply(block)
}

class GuidesScreenRobot {

    val appliesCorrectTitle =
            toolbarWithTitle(R.string.guides).check(matches(isDisplayed()))

    val containsGuidesRecycler =
            onView(withId(R.id.guidesRecycler)).check(matches(isDisplayed()))

    fun guidesRecycler(block: GuidesRecyclerRobot.() -> Unit): GuidesRecyclerRobot {
        return GuidesRecyclerRobot().apply(block)
    }
}

class GuidesRecyclerRobot {

    fun hasOnFirstPosition(title: String, venue: String, endDate: String) {
        onView(withText(title)).check(matches(isDisplayed()))
        onView(withText(venue)).check(matches(isDisplayed()))
        onView(withText(endDate)).check(matches(isDisplayed()))
    }
}
