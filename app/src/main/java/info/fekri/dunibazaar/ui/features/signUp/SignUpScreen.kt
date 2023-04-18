package info.fekri.dunibazaar.ui.features.signUp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import info.fekri.dunibazaar.R
import info.fekri.dunibazaar.ui.features.IntroScreen
import info.fekri.dunibazaar.ui.theme.BackgroundMain
import info.fekri.dunibazaar.ui.theme.Blue
import info.fekri.dunibazaar.ui.theme.MainAppTheme
import info.fekri.dunibazaar.ui.theme.Shapes

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUpPreview() {
    MainAppTheme {
        Surface(
            color = BackgroundMain,
            modifier = Modifier.fillMaxSize()
        ) {
            SignUpScreen()
        }
    }
}

@Composable
fun SignUpScreen() {

    Box {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f)
                .background(Blue)
        )
        
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.95f),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconApp()

            MainCardView {

            }
        }
        
    }

}

@Composable
fun IconApp() {
    Surface(
        modifier = Modifier
            .clip(CircleShape)
            .size(64.dp)
    ) {
       Image(
           modifier = Modifier.padding(14.dp),
           painter = painterResource(id = R.drawable.ic_icon_app),
           contentDescription = null
       )
    }
}

@Composable
fun MainCardView(signUpEvent: () -> Unit) {
    val name = remember { mutableStateOf("null") }
    val email = remember { mutableStateOf("null") }
    val password = remember { mutableStateOf("null") }
    val confirmPassword = remember { mutableStateOf("null") }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        elevation = 10.dp,
        shape = Shapes.medium
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                modifier = Modifier.padding(top = 18.dp, bottom = 18.dp),
                text = "Sign Up",
                style = TextStyle(color = Blue, fontSize = 28.sp, fontWeight = FontWeight.Bold)
            )

            MainTextField(
                edtValue = name.value,
                icon = R.drawable.ic_person,
                hint = "Your full name"
            ) { name.value = it }

            MainTextField(
                edtValue = email.value,
                icon = R.drawable.ic_email,
                hint = "Email"
            ) { email.value = it }

            MainTextField(
                edtValue = password.value,
                icon = R.drawable.ic_password,
                hint = "Password"
            ) { password.value = it }

            MainTextField(
                edtValue = confirmPassword.value,
                icon = R.drawable.ic_password,
                hint = "Confirm Password"
            ) { confirmPassword.value = it }

            Button(
                onClick = signUpEvent,
                modifier = Modifier.padding(top = 28.dp, bottom = 8.dp)
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "Register Account"
                )
            }

            Row(
                modifier = Modifier.padding(bottom = 18.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(text = "Already have an Account?")

                Spacer(modifier = Modifier.width(8.dp))

                TextButton(onClick = {}) {
                    Text(text = "Login", color = Blue)
                }

            }

        }
    }

}

@Composable
fun MainTextField(
    edtValue: String,
    icon: Int,
    hint: String,
    onValueChanges: (String) -> Unit
) {

    OutlinedTextField(
        value = edtValue,
        onValueChange = onValueChanges,
        label = { Text(text = hint) },
        placeholder = { Text(text = hint) },
        singleLine = true,
        shape = Shapes.medium,
        leadingIcon = { Icon(painterResource(id = icon), contentDescription = null) },
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .padding(top = 12.dp)
    )

}
