package com.example.nikeshoesapp.homeSections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp




@Composable
fun Manage() {
    val buttonTexts = listOf("All", "Sneaker", "Running", "Formal", "Basketball")
    var selectedCategory by remember { mutableStateOf(buttonTexts[0]) }

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(buttonTexts.size) { index ->
            val category = buttonTexts[index]
            var isSelected by remember { mutableStateOf(category == selectedCategory) }

            Button(
                onClick = {
                    isSelected = !isSelected
                    if (isSelected) {
                        selectedCategory = category
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isSelected) Color.Black else Color.Transparent
                ),
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
            ) {
                Text(
                    text = category,
                    color = if (isSelected) Color.White else Color.Gray
                )
            }
        }
    }

    Products(selectedCategory)
}

