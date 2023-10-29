package com.example.composetesting

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag


//cmd+shift+T => Test
@Composable
fun SampleScreen() {

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        //add semantics
        Text(text = "Hello Test!", modifier = Modifier.semantics { testTag = "sample_text" })

    }

}