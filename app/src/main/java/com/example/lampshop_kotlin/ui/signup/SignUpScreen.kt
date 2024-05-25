package com.example.lampshop_kotlin.ui.signup

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lampshop_kotlin.R
import com.example.lampshop_kotlin.ui.components.HeaderText
import com.example.lampshop_kotlin.ui.components.LoginTextField
import com.example.lampshop_kotlin.ui.login.defaultPadding

@Composable
fun SignUpScreen(
    onSignUpClick: () -> Unit,
    onLoginClick: () -> Unit,
) {
    val context = LocalContext.current
    val (name, setName) = rememberSaveable {
        mutableStateOf("")
    }
    val (email, setEmail) = rememberSaveable {
        mutableStateOf("")
    }
    val (phone, setPhone) = rememberSaveable {
        mutableStateOf("")
    }
    val (password, setPassword) = rememberSaveable {
        mutableStateOf("")
    }
    val (cfpass, setcfpass) = rememberSaveable {
        mutableStateOf("")
    }
    val (agree, onAgreeChange) = rememberSaveable {
        mutableStateOf(false)
    }

    var isPasswordSame by remember {
        mutableStateOf(false)
    }

    val isFieldNotEmpty = name.isNotEmpty() && email.isNotEmpty() && phone.isNotEmpty()
            && password.isNotEmpty() && cfpass.isNotEmpty()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(defaultPadding)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedVisibility(visible = isPasswordSame) {
            Text(
                text = "Password is not Matching",
                color = MaterialTheme.colorScheme.error
            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            HeaderText(
                text = "Join with us",
                color = Color(0xFF0A6851),
                modifier = Modifier
                    .padding(vertical = defaultPadding)
            )

            Image(
                painter = painterResource(id = R.drawable.light),
                contentDescription = "Light Sign up",
                modifier = Modifier.size(80.dp)
            )
        }

        Spacer(modifier = Modifier.height(defaultPadding + 20.dp))

        LoginTextField(
            value = name,
            onValueChange = setName,
            labelText = "Name",
            leadingIcon = Icons.Default.Person,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(defaultPadding))
        LoginTextField(
            value = email,
            onValueChange = setEmail,
            labelText = "Email",
            leadingIcon = Icons.Default.Email,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(defaultPadding))
        LoginTextField(
            value = phone,
            onValueChange = setPhone,
            labelText = "Phone Number",
            leadingIcon = Icons.Default.Phone,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(defaultPadding))
        LoginTextField(
            value = password,
            onValueChange = setPassword,
            labelText = "Password",
            leadingIcon = Icons.Default.Lock,
            modifier = Modifier.fillMaxWidth(),
            keyboardType = KeyboardType.Password,
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(defaultPadding))
        LoginTextField(
            value = cfpass,
            onValueChange = setcfpass,
            labelText = "Confirm Password",
            leadingIcon = Icons.Default.Lock,
            modifier = Modifier.fillMaxWidth(),
            keyboardType = KeyboardType.Password,
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(defaultPadding))
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val privacyText = "Privacy"
            val policyText = "Policy"
            val annotatedString = buildAnnotatedString {
                withStyle(SpanStyle(color = MaterialTheme.colorScheme.onBackground)) {
                    append("I Agree with")
                }
                append(" ")
                withStyle(SpanStyle(color = Color(0xFF058364))) {
                    pushStringAnnotation(tag = privacyText, privacyText)
                    append(privacyText)
                }
                append(" And ")
                withStyle(SpanStyle(color = Color(0xFF058364))) {
                    pushStringAnnotation(tag = policyText, policyText)
                    append(policyText)
                }
            }
            Checkbox(checked = agree, onCheckedChange = onAgreeChange)
            ClickableText(text = annotatedString) { offset ->
                annotatedString.getStringAnnotations(offset, offset).forEach {
                    when (it.tag) {
                        privacyText -> {
                            Toast.makeText(context, "Privacy Text Clicked", Toast.LENGTH_SHORT)
                                .show()
                        }

                        policyText -> {
                            Toast.makeText(context, "Policy Text Clicked", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(defaultPadding + 8.dp))

        Button(
            onClick = {
                isPasswordSame = password != cfpass
                if (!isPasswordSame) {
                    onSignUpClick()
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xA33DBBA2)
            ),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            border = BorderStroke(2.dp, Color(0xA32E8171)),
            enabled = isFieldNotEmpty
        ) {
            Text(text = "Signup")
        }

        Spacer(modifier = Modifier.height(defaultPadding))
        val signTx = "Sign In"
        val signInAnnotation = buildAnnotatedString {
            withStyle(SpanStyle(color = MaterialTheme.colorScheme.onBackground)) {
                append("Allready have an account?")
            }
            append(" ")
            withStyle(SpanStyle(color = Color(0xFF058364))) {
                pushStringAnnotation(signTx, signTx)
                append(signTx)
            }
        }
        ClickableText(text = signInAnnotation) { offset ->
            signInAnnotation.getStringAnnotations(offset, offset).forEach {
                if (it.tag == signTx) {
                    Toast.makeText(context, "Sign in Clicked", Toast.LENGTH_SHORT).show()
                    onLoginClick()
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreSignUp() {
    MaterialTheme {
        SignUpScreen({}, {})
    }
}