
package com.example.lampshop_kotlin.ui.screens.favorite

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lampshop_kotlin.R
import com.example.lampshop_kotlin.ui.screens.favorite.component.FavoriteCard
//import com.example.lampshop_kotlin.ui.screens.home.listProduct
import com.example.lampshop_kotlin.ui.theme.PrimaryColor
import com.example.lampshop_kotlin.ui.theme.gelasioFont
import com.example.lampshop_kotlin.ui.theme.nunitoSansFont

@Composable
fun FavoriteScreen() {

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding()
        ) {
            item {
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
                        modifier = Modifier.weight(1f)
                    )
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .weight(10f)
                            .padding(5.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.favorites).uppercase(),
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

            }

//            items(listProduct.size) { index ->
//                val favorite = listProduct[index]
//                FavoriteCard(
//                    product = favorite,
//                    onFavoriteClick = {
//                    },
//                    onDeleteFavoriteClick = {
//                    },
//                    onAddFavoriteToBagClick = {
//                    }
//                )
//            }
        }
        Button(
            onClick = {
            },
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 0.2.dp,
                pressedElevation = 0.dp
            ),
            shape = RoundedCornerShape(15.dp),
            content = {
                Text(
                    text = "Add to Cart",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = nunitoSansFont
                    )
                )
            },
            contentPadding = PaddingValues(15.dp)
        )
    }


}