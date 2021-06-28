package com.wcc.whatdoilearn

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.wcc.whatdoilearn.view.NewItemActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityFunctionalTest {
    @get:Rule
    var activityTestRule =  ActivityTestRule(NewItemActivity::class.java)

    @Test
    fun givenNewItemWhenAddShouldReturnToMainScreen() {
        val itemTitle = "new Item"
        val itemDescription = "item description"

        onView(withId(R.id.titleEditText)).perform(typeText(itemTitle))
        onView(withId(R.id.descriptionEditText)).perform(typeText(itemDescription))
        onView(withId(R.id.saveButton)).perform(click())

        onView(withText("WhatDoILearn")).check(matches(isDisplayed()))
    }
}