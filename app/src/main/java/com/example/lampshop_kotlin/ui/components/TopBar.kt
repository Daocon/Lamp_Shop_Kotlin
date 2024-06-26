package com.example.lampshop_kotlin.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppBar(showSearchIcon: Boolean, title: String, iconLeft: ImageVector, iconRight: ImageVector) {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /* Handle navigation icon press */ }) {
                    Icon(iconLeft, contentDescription = "Back")
                }
                Text(text = title)
                if (showSearchIcon) {
                    IconButton(onClick = { /* Handle search icon press */ }) {
                        Icon(iconRight, contentDescription = "Search")
                    }
                } else {
                    Spacer(modifier = Modifier.size(48.dp))
                }
            }
        }
    )
}

@Preview
@Composable
fun PreviewMyAppBar() {

MyAppBar(showSearchIcon = true, title = "Home", iconLeft = Icons.Filled.ArrowBack, iconRight = Icons.Filled.Search)

}