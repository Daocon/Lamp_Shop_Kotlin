package com.example.lampshop_kotlin.ui.screens.home


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lampshop_kotlin.R
import com.example.lampshop_kotlin.domain.model.product.Product
import com.example.lampshop_kotlin.navigation.BottomBarScreen
import com.example.lampshop_kotlin.ui.screens.home.component.CategoryTabBar
import com.example.lampshop_kotlin.ui.screens.home.component.ProductCard
import com.example.lampshop_kotlin.ui.theme.GreyLight
import com.example.lampshop_kotlin.ui.theme.PrimaryColor
import com.example.lampshop_kotlin.ui.theme.gelasioFont
import com.example.lampshop_kotlin.ui.theme.merriweatherFont


@Composable
fun HomeScreen(navController: NavController,) {

    var categorySelect by rememberSaveable {
        mutableIntStateOf(0)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = stringResource(
                        id = R.string.search
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .clickable {

                        }
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .weight(10f)
                        .padding(5.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.make_home),
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Normal,
                            lineHeight = 25.sp,
                            fontFamily = gelasioFont,
                            color = GreyLight
                        )
                    )
                    Text(
                        text = stringResource(id = R.string.beautiful).uppercase(),
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.ExtraBold,
                            lineHeight = 25.sp,
                            fontFamily = gelasioFont,
                            color = PrimaryColor
                        )
                    )
                }
                Icon(
                    painter = painterResource(id = R.drawable.ic_cart),
                    contentDescription = stringResource(
                        id = R.string.cart
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .padding(5.dp)
                        .clickable {
                        }
                )
            }
            CategoryTabBar(
                modifier = Modifier
                    .padding(start = 16.dp),
                onChangeSelected = {
                    categorySelect = it
                },
                selectCategory = categorySelect
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.Center,
                contentPadding = PaddingValues(start = 30.dp, end = 0.dp)
            ) {
                if (listProduct != null) {
                    if (listProduct.isNotEmpty()) {
                        if (categorySelect == 0) {
                            listProduct.forEach { product ->
                                item {
                                    ProductCard(
                                        product = product,
                                        onAddToCart = {
                                        },
                                        onProductClick = {
                                            navController.navigate(
                                                BottomBarScreen.Detail.route
                                            )
                                        }
                                    )
                                }
                            }
                        } else {
                            val filteredList = listProduct.filter {
                                it.categoryId == categorySelect
                            }
                            if (filteredList.isEmpty()) {
                                item {
                                    Text(
                                        text = stringResource(id = R.string.no_products_found),
                                        style = TextStyle(
                                            fontSize = 18.sp,
                                            fontWeight = FontWeight.Normal,
                                            lineHeight = 25.sp,
                                            fontFamily = merriweatherFont,
                                            color = GreyLight
                                        )
                                    )
                                }
                            } else {
                                filteredList.forEach { product ->
                                    item {
                                        ProductCard(
                                            product = product,
                                            onAddToCart = {
                                            },
                                            onProductClick = {
                                            }
                                        )
                                    }
                                }
                            }
                        }
                    }
                } else {
                    item {
                        Text(
                            text = stringResource(id = R.string.no_products_found),
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Normal,
                                lineHeight = 25.sp,
                                fontFamily = merriweatherFont,
                                color = GreyLight
                            )
                        )
                    }
                }
            }
        }
    }
}

val listProduct = listOf<Product>(
    Product(
        productId = 1,
        name = "Lamp",
        price = 100,
        description = "Lamp",
        colors = listOf("red", "green", "blue"),
        images = listOf("https://images.urbndata.com/is/image/UrbanOutfitters/82877101_020_b?"),
        createdAt = "2021-10-10",
        categoryId = 5
    ),
    Product(
        productId = 2,
        name = "Chair",
        price = 200,
        description = "Chair",
        colors = listOf("red", "green", "blue"),
        images = listOf("https://images.urbndata.com/is/image/UrbanOutfitters/82877101_020_b?"),
        createdAt = "2021-10-10",
        categoryId = 1
    ),
    Product(
        productId = 3,
        name = "Table",
        price = 300,
        description = "Table",
        colors = listOf("red", "green", "blue"),
        images = listOf("https://images.urbndata.com/is/image/UrbanOutfitters/82877101_020_b?"),
        createdAt = "2021-10-10",
        categoryId = 3
    ),
)







@Preview(showBackground = true)
@Composable
fun PreHomeScreen() {
//    HomeScreen()
}
