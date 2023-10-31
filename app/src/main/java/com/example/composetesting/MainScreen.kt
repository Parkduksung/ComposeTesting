package com.example.composetesting

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


//cmd+shift+T => Test
@Composable
fun MainScreen(
    navController: NavController
) {

    var clickNum by remember { mutableStateOf(0) }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        //add semantics
        Text(
            text = "Hello Test! click count : $clickNum",
            modifier = Modifier.semantics { testTag = "sample_text" })


        Button(
            onClick = {
                if (clickNum > 10) {
                    navController.navigate(Screen.Sub.route)
                } else {
                    clickNum++
                }
            },
            modifier = Modifier
                .testTag("sample_button")
                .align(Alignment.BottomCenter)
                .padding(bottom = 20.dp)
        ) {
            Text(text = "Click Me!")
        }
    }

}