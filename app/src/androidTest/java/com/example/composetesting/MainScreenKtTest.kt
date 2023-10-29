package com.example.composetesting

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
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
    fun initScreenTextTest() {

        //find node by text and assert
        composeTestRule.onNodeWithText("Hello Test! click count : 0").assertExists()

    }


    @Test
    fun clickButtonTest1() {

            //find node by tag and click
            composeTestRule.onNodeWithTag("sample_button").performClick()

            //find node by text and assert
            composeTestRule.onNodeWithText("Hello Test! click count : 1").assertExists()
    }


    @Test
    fun clickButtonTest2() {

        //find node by tag and click
        composeTestRule
            .onNodeWithTag("sample_button")

        val repeatCount = 5

        repeat(repeatCount){
            composeTestRule.onNodeWithTag("sample_button").performClick()
        }

        //find node by text and assert
        composeTestRule.onNodeWithText("Hello Test! click count : $repeatCount").assertExists()
    }

}