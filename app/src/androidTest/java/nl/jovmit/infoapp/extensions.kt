package nl.jovmit.infoapp

import android.support.annotation.StringRes
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.v7.widget.Toolbar
import org.hamcrest.Matchers.allOf

fun toolbarWithTitle(@StringRes title: Int): ViewInteraction =
        onView(allOf(withText(title), withParent(isAssignableFrom(Toolbar::class.java))))