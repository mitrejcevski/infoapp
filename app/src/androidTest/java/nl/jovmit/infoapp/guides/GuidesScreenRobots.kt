package nl.jovmit.infoapp.guides

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
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
}
