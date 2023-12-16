package com.example.nikeshoesapp.homeSections

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.nikeshoesapp.R
import com.example.nikeshoesapp.data.Products
import com.example.nikeshoesapp.ui.theme.Gray40
import com.example.nikeshoesapp.ui.theme.LightGray


var products = listOf(

    Products(
        textMedium = "20% Discount",
        textLow = "on the first purchase",
        textShop = "Shop now",
        image = R.drawable.blue
    ),
    Products(
        textMedium = "New! -10%!!",
        textLow = "go buy shoe!",
        textShop = "Shop now",
        image = R.drawable.green
    )
)


@Preview
@Composable
fun Slider() {
    LazyRow(
        modifier = Modifier
            .padding(top = 16.dp)
    ) {
        items(products.size) { index ->
            SliderItem(index)
        }
    }
}


@Composable
fun SliderItem(
    index: Int
) {
    val product = products[index]
    var lastItemPaddingEnd = 0.dp
    if (index == products.size - 1) {
        lastItemPaddingEnd = 16.dp
    }

    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = lastItemPaddingEnd)
    ) {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(color = LightGray)
                .width(320.dp)
                .height(160.dp)
                .clickable { }
                .padding(vertical = 12.dp, horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 8.dp, top = 16.dp)
            ) {
                Text(
                    text = product.textMedium,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = product.textLow,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Light
                )
                Button(
                    onClick = { /* ваш обработчик клика */ },
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .padding(top = 32.dp),
                    colors = ButtonDefaults.buttonColors(Color.Black)
                ) {
                    Text(
                        text = product.textShop,
                        color = Color.White,
                        fontSize = 12.sp
                    )
                }
            }

            Image(
                painter = painterResource(id = product.image),
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp)
                    .scale(1.5f)
                    .graphicsLayer(translationY = 10f, translationX = -20f)
            )
        }
    }
}