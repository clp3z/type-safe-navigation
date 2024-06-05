package com.clp3z.typesafenavigationexample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ContentScreen(
    title: String,
    backgroundColor: Color,
    isFirstLevel: Boolean,
    onButtonClick : (String) -> Unit,
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            if (!isFirstLevel) {
                TopAppBar(
                    title = { Text(text = title) },
                    navigationIcon = {
                        IconButton(onClick = { onBackClick() }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBackIosNew,
                                contentDescription = "Back"
                            )
                        }
                    }
                )
            }
        }
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor)
                .padding(it)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.h4
            )
            Spacer(modifier = Modifier.height(24.dp))
            if (isFirstLevel) {
                Button(
                    onClick = {
                        onButtonClick("${title.substringAfterLast(".")} Content")
                    }
                ) {
                    Text(text = "Navigate Level")
                }
            }
        }
    }
}

@Preview
@Composable
fun ContentScreenPreview() {
    ContentScreen(
        title = "Content Screen",
        backgroundColor = MaterialTheme.colors.secondary.copy(alpha = 0.2f),
        isFirstLevel = false,
        onButtonClick = {},
        onBackClick = {}
    )
}
