package com.example.nikeshoesapp.detailSection

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nikeshoesapp.homeSections.TopBar
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.nikeshoesapp.R


@Preview(showBackground = true)
@Composable
fun DetailScreen() {
    val buttonTexts = listOf("UK 6", "UK 7", "UK 8", "UK 9")

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        TopBar()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text(
                    text = "Size",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                buttonTexts.forEachIndexed { index, buttonText ->
                    var isSelected by remember { mutableStateOf(index == 0) }

                    Button(
                        onClick = { isSelected = !isSelected },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isSelected) Color.Black else Color.Transparent
                        ),
                        modifier = Modifier
                            .clip(RoundedCornerShape(16.dp))
                    ) {
                        Text(
                            text = buttonText,
                            color = if (isSelected) Color.White else Color.Gray
                        )
                    }
                }

                Spacer(modifier = Modifier.height(64.dp))

                Text(
                    text = "$30.99",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 16.dp)
                )
                Text(
                    text = "10% OFF",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(start = 20.dp),
                    color = Color.Red
                )
            }

            Column(
                modifier = Modifier
                    .padding(end = 16.dp, top = 64.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .height(300.dp)
                        .width(150.dp)
                        .scale(1.4f)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.nike),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize()
                            .zIndex(0f)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.red_shoe),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize()
                            .zIndex(1f)
                            .scale(1.5f)
                    )
                }
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(100.dp),
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .clickable {}
                        .border(1.dp, Color.Gray, MaterialTheme.shapes.small)
                        .padding(6.dp),
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Star,
                        contentDescription = null,
                        tint = Color.Yellow,
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = "Colour",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .clickable {}
                            .border(1.dp, Color.Gray, MaterialTheme.shapes.small)
                            .padding(6.dp),
                    ) {
                        Box(
                            modifier = Modifier
                                .background(Color.Red)
                                .size(15.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .clickable {}
                            .border(1.dp, Color.Gray, MaterialTheme.shapes.small)
                            .padding(6.dp),
                    ) {
                        Box(
                            modifier = Modifier
                                .background(Color.Blue)
                                .size(15.dp)
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))

        Box(
            modifier = Modifier
                .height(90.dp)
                .width(50.dp)
                .background(Color.Black, shape = RoundedCornerShape(16.dp))
                .clickable { }
        ) {
            Icon(
                imageVector = Icons.Rounded.ShoppingCart,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.Center)
            )
            Icon(
                imageVector = Icons.Rounded.KeyboardArrowDown,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.BottomCenter)
            )
        }

        Image(
            painter = painterResource(id = R.drawable.carpet),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
    }
}