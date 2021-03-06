package nl.jovmit.infoapp.guides

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class GuidesActivityActivityTest {

    @Rule
    @JvmField
    val rule = ActivityTestRule<GuidesActivity>(GuidesActivity::class.java)

    @Test
    fun screen_should_apply_correct_title() {
        guidesScreen {
            appliesCorrectTitle
        }
    }

    @Test
    fun screen_should_include_guides_recycler() {
        guidesScreen {
            containsGuidesRecycler
        }
    }

    @Test
    fun recycler_should_display_items_info() {
        guidesScreen {
            guidesRecycler {
                hasOnFirstPosition("name 1", "city 1, state 1", "endDate 1")
            }
        }
    }
}