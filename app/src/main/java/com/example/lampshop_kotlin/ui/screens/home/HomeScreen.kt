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
import androidx.compose.runtime.livedata.observeAsState
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.lampshop_kotlin.R
import com.example.lampshop_kotlin.navigation.BottomBarScreen
import com.example.lampshop_kotlin.ui.screens.home.component.CategoryTabBar
import com.example.lampshop_kotlin.ui.screens.home.component.LampCard
//import com.example.lampshop_kotlin.ui.screens.home.component.ProductCard
import com.example.lampshop_kotlin.ui.theme.GreyLight
import com.example.lampshop_kotlin.ui.theme.PrimaryColor
import com.example.lampshop_kotlin.ui.theme.gelasioFont
import com.example.lampshop_kotlin.ui.theme.merriweatherFont


@Composable
fun HomeScreen(navController: NavController) {

    val lampViewModel: LampViewModel = viewModel()
    val lampsState = lampViewModel.lamps.observeAsState(initial = emptyList())
    val lamps = lampsState.value

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
                contentPadding = PaddingValues(start = 30.dp, end = 0.dp)
            ) {
                if (lamps != null) {
                    if (lamps.isNotEmpty()) {
                        if (categorySelect == 0) {
                            lamps.forEach { product ->
                                item {
                                    LampCard(
                                        lamp = product,
                                        onAddToCart = {},
                                        onProductClick = {
                                            navController.navigate("${BottomBarScreen.Detail.route}/${product.id}")
                                        }
                                    )
                                }
                            }
                        } else {
                            val filteredList = lamps.filter {
                                it.id_category == categorySelect.toString()
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
                                        LampCard(
                                            lamp = product,
                                            onAddToCart = {
                                            },
                                            onProductClick = {
                                                navController.navigate(BottomBarScreen.Detail.route)
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


@Preview(showBackground = true)
@Composable
fun PreHomeScreen() {
//    HomeScreen()
}
