package com.example.nikeshoesapp.homeSections

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nikeshoesapp.R
import com.example.nikeshoesapp.data.ShopProducts
import com.example.nikeshoesapp.ui.theme.LightGray

var shopProducts = listOf(

    ShopProducts(
        image = R.drawable.backsack,
        title = "React Presto",
        price = "$25.99"
    ),
    ShopProducts(
        image = R.drawable.blue,
        title = "Air Max Indigo",
        price = "$21.99"
    ),
    ShopProducts(
        image = R.drawable.green,
        title = "React Forest",
        price = "$439.99"
    ),
    ShopProducts(
        image = R.drawable.shoe,
        title = "Air Max 97",
        price = "$19.99"
    )
)

@Composable
fun Products(category: String) {
    val filteredProducts = when (category) {
        "All" -> shopProducts
        "Sneaker" -> shopProducts.filter { it.title.contains("Air", ignoreCase = true) }
        "Running" -> shopProducts.filter { it.title.contains("Indigo", ignoreCase = true) }
        "Formal" -> shopProducts.filter { it.title.contains("Forest", ignoreCase = true) }
        "Basketball" -> shopProducts.filter { it.title.contains("React", ignoreCase = true) }

        else -> emptyList()
    }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(filteredProducts.size / 2) { rowIndex ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                ProductsItem(index = rowIndex * 2, product = filteredProducts[rowIndex * 2])
                ProductsItem(index = rowIndex * 2 + 1, product = filteredProducts[rowIndex * 2 + 1])
            }
        }
    }
}


@Composable
fun ProductsItem(
    index: Int,
    product: ShopProducts
) {

    val lastItemPaddingBottom = if (index == shopProducts.size - 1) 16.dp else 0.dp

    Box(modifier = Modifier
        .padding(top = 16.dp, bottom = lastItemPaddingBottom)
    ){
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(LightGray)
                .width(160.dp)
                .height(230.dp)
                .clickable { /* Обработка клика */ }
                .padding(vertical = 12.dp, horizontal = 16.dp),
        ) {
            Image(
                painter = painterResource(id = product.image),
                contentDescription = null,
                modifier = Modifier.size(150.dp).scale(1.3f)
            )

            Text(
                text = product.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = product.price
                )
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.White)
                        .clickable { /* Обработка клика */ }
                ) {
                    Icon(
                        imageVector = Icons.Rounded.ArrowForward,
                        contentDescription = null,
                        tint = Color.Black,
                        modifier = Modifier
                    )
                }
            }
        }
    }
}