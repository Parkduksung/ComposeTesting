package com.example.composetesting

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test


class MainScreenKtTest {


    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()


    @Test
    fun initScreenTest() {

        //find node by tag and assert
        composeTestRule.onNodeWithTag("sample_text").assertExists()
    }

    @Test
    fun initScreenTextTest(){

        //find node by text and assert
        composeTestRule.onNodeWithText("Hello Test!").assertExists()

    }

}