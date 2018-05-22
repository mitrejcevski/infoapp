package nl.jovmit.infoapp.guides

import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import nl.jovmit.infoapp.R
import nl.jovmit.infoapp.toolbarWithTitle

fun guidesScreen(block: GuidesScreenRobot.() -> Unit): GuidesScreenRobot {
    return GuidesScreenRobot().apply(block)
}

class GuidesScreenRobot {

    val appliesCorrectTitle =
            toolbarWithTitle(R.string.guides).check(matches(isDisplayed()))
}
