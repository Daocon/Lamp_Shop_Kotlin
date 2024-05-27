package com.example.lampshop_kotlin.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lampshop_kotlin.R
import com.example.lampshop_kotlin.ui.theme.BlackText
import com.example.lampshop_kotlin.ui.theme.QuantityColor
import com.example.lampshop_kotlin.ui.theme.nunitoSansFont

@Composable
fun QuantityButton(
    modifier: Modifier = Modifier,
    quantity: Int = 1,
    onQuantityIncrease: (Int) -> Unit,
    onQuantityDecrease: (Int) -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = {
                onQuantityIncrease(quantity)
            },
            modifier = Modifier
                .padding(start = 20.dp)
                .background(QuantityColor, RoundedCornerShape(10.dp))
                .size(35.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = stringResource(id = R.string.increment)
            )
        }
        Text(
            text = "$quantity",
            maxLines = 1,
            style = TextStyle(
                color = BlackText,
                fontSize = 18.sp,
                lineHeight = 40.sp,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = nunitoSansFont
            ),
            modifier = Modifier.padding(start = 20.dp)
        )
        IconButton(
            onClick = {
                onQuantityDecrease(quantity)
            },
            modifier = Modifier
                .padding(start = 20.dp)
                .background(QuantityColor, RoundedCornerShape(10.dp))
                .size(35.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = stringResource(id = R.string.decrement)
            )
        }

    }
}