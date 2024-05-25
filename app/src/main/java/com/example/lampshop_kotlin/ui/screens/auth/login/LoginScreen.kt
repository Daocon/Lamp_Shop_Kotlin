package com.example.lampshop_kotlin.ui.screens.auth.login

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lampshop_kotlin.R
import com.example.lampshop_kotlin.ui.components.HeaderText
import com.example.lampshop_kotlin.ui.components.LoginTextField

val defaultPadding = 16.dp
val itemSpacing = 8.dp

@Composable
fun LoginScreen(onSignUpClick: () -> Unit, onLoginClick: () -> Unit) {
    val context = LocalContext.current

    val (email, setEmail) = rememberSaveable {
        mutableStateOf("")
    }
    val (password, setPassoword) = rememberSaveable {
        mutableStateOf("")
    }
    val (checked, onCheckedChange) = rememberSaveable {
        mutableStateOf(false)
    }

    val isFieldEmpty = email.isNotEmpty() && password.isNotEmpty()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(defaultPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderText(
            text = "Hi, I'm LampShop...",
            color = Color(0xFF0A6851),
            modifier = Modifier
                .padding(vertical = defaultPadding)
                .align(Alignment.Start)
        )
        Spacer(modifier = Modifier.height(itemSpacing))
        Image(
            painter = painterResource(id = R.drawable.lamp),
            contentDescription = "Logo Lamp",
            modifier = Modifier.size(150.dp))
        Spacer(modifier = Modifier.height(itemSpacing))
        LoginTextField(
            value = email,
            onValueChange = setEmail,
            labelText = "Email",
            leadingIcon = Icons.Default.Email,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(itemSpacing))
        LoginTextField(
            value = password,
            onValueChange = setPassoword,
            labelText = "Password",
            leadingIcon = Icons.Default.Lock,
            modifier = Modifier.fillMaxWidth(),
            keyboardType = KeyboardType.Password,
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(itemSpacing))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(checked = checked, onCheckedChange = onCheckedChange)
                Text(text = "Remember me")
            }
            TextButton(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.LightGray
                )
            ) {
                Text(text = "Forgot password?")
            }
        }

        //elevation = ButtonDefaults.buttonElevation(
        //                defaultElevation = 6.dp,
        //                pressedElevation = 10.dp,
        //            ),

        Button(
            onClick = onLoginClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xA33DBBA2)
            ),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            border = BorderStroke(2.dp, Color(0xA32E8171)),
            enabled = isFieldEmpty
        ) {
            Text(text = "Login")
        }

        AnotherOption(
            onIconClick = { index ->
                when (index) {
                    0 -> Toast.makeText(context, "Facebook", Toast.LENGTH_SHORT).show()
                    1 -> Toast.makeText(context, "Github", Toast.LENGTH_SHORT).show()
                    2 -> Toast.makeText(context, "Google", Toast.LENGTH_SHORT).show()
                }
            },
            onSignUpClick = onSignUpClick,
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(align = Alignment.BottomCenter)
        )
    }
}

@Composable
fun AnotherOption(
    onIconClick: (index: Int) -> Unit,
    onSignUpClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val iconList = listOf(
        R.drawable.facebook,
        R.drawable.github,
        R.drawable.google
    )
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Or login with")
        Spacer(modifier = Modifier.height(itemSpacing))
        Row(horizontalArrangement = Arrangement.SpaceAround) {
            iconList.forEachIndexed { index, iconResID ->
                Spacer(modifier = Modifier.width(defaultPadding))
                Icon(
                    painter = painterResource(id = iconResID),
                    contentDescription = "Authertive login",
                    modifier = Modifier
                        .size(32.dp)
                        .clickable {
                            onIconClick(index)
                        }
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(defaultPadding))
            }
            Spacer(modifier = Modifier.height(itemSpacing))
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Don't have an account?")
            Spacer(modifier = Modifier.height(itemSpacing))
            TextButton(
                onClick = onSignUpClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color(0xFF3DBBA2)
                )
            ) {
                Text(text = "Sign up")
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun PreLogin() {
    MaterialTheme {
        LoginScreen({}, {})
    }
}