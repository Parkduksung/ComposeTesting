package com.example.composetesting

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performScrollTo
import androidx.compose.ui.test.performScrollToIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.random.Random
import kotlin.random.nextInt


class SubScreenKtTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var navController: NavController

    @Before
    fun setUp() {
        composeTestRule.setContent {
            navController = rememberNavController()
            SubScreen(navController = navController)
        }
    }

    @Test
    fun randomScrollTest() {

        val random = Random.nextInt(1..1000)

        composeTestRule.onNodeWithTag(testTag = "TestLazyColumn").performScrollToIndex(random - 1)

        composeTestRule.onNodeWithText(text = "Hello SubScreen! $random").assertIsDisplayed()
    }


}