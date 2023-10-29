package com.example.composetesting

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test


class MainScreenKtTest {


    @get:Rule
    val composeTestRule = createComposeRule()


    @Test
    fun initScreenTest() {

        //set content
        composeTestRule.setContent {
            SampleScreen()
        }

        //find node by tag and assert
        composeTestRule.onNodeWithTag("sample_text").assertExists()
    }

    @Test
    fun initScreenTextTest(){

        composeTestRule.setContent {
            SampleScreen()
        }

        //find node by text and assert
        composeTestRule.onNodeWithText("Hello Test!").assertExists()

    }

}