package com.example.composetesting

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class MainScreenKtTest {


    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var navController: NavController

    @Before
    fun setUp(){
        composeTestRule.setContent {
            navController = rememberNavController()
            MainScreen(navController = navController)
        }
    }


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

    @Test
    fun `버튼을_10번_초과_눌렀을_시_서브화면으로_이동되어야한다`() {

        val repeatCount = 10

        repeat(repeatCount){
            composeTestRule.onNodeWithTag("sample_button").performClick()
        }

        //find node by text and assert
        composeTestRule.onNodeWithText("Hello Test! click count : $repeatCount").assertExists()

        //find node by tag and click
        composeTestRule.onNodeWithTag("sample_button").performClick()

        //find node by text and assert
        composeTestRule.onNodeWithText("Hello SubScreen!").assertExists()
    }
}