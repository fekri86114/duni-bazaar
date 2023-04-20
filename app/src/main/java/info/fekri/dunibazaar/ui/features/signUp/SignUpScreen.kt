package info.fekri.dunibazaar.ui.features.signUp

import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dev.burnoo.cokoin.navigation.getNavController
import dev.burnoo.cokoin.navigation.getNavViewModel
import dev.burnoo.cokoin.viewmodel.getViewModel
import info.fekri.dunibazaar.R
import info.fekri.dunibazaar.ui.features.IntroScreen
import info.fekri.dunibazaar.ui.theme.BackgroundMain
import info.fekri.dunibazaar.ui.theme.Blue
import info.fekri.dunibazaar.ui.theme.MainAppTheme
import info.fekri.dunibazaar.ui.theme.Shapes
import info.fekri.dunibazaar.util.MyScreens
import info.fekri.dunibazaar.util.NetworkChecker

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
    /* set UI changes here */
    val uiController = rememberSystemUiController()
    SideEffect { uiController.setStatusBarColor(Blue) }

    val navigation = getNavController()
    val viewModel = getNavViewModel<SignUpViewModel>()

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

            MainCardView(navigation, viewModel = viewModel) {
                viewModel.signUpUser()
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
fun MainCardView(navigation: NavController, viewModel: SignUpViewModel, signUpEvent: () -> Unit) {
    val name = viewModel.name.observeAsState("")
    val email = viewModel.email.observeAsState("")
    val password = viewModel.password.observeAsState("")
    val confirmPassword = viewModel.confirmPassword.observeAsState("")
    val context = LocalContext.current

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
            ) { viewModel.name.value = it }

            MainTextField(
                edtValue = email.value,
                icon = R.drawable.ic_email,
                hint = "Email"
            ) { viewModel.email.value = it }

            PasswordTextField(
                edtValue = password.value,
                icon = R.drawable.ic_password,
                hint = "Password"
            ) { viewModel.password.value = it }

            PasswordTextField(
                edtValue = confirmPassword.value,
                icon = R.drawable.ic_password,
                hint = "Confirm Password"
            ) { viewModel.confirmPassword.value = it }

            Button(
                onClick = {
                    if (
                        name.value.isNotEmpty() &&
                        email.value.isNotEmpty() &&
                        password.value.isNotEmpty() &&
                        confirmPassword.value.isNotEmpty()
                    ) {
                        // check user input -->
                        if (password.value == confirmPassword.value) {
                            if (password.value.length >= 8) {
                                /* email checker */
                                if (Patterns.EMAIL_ADDRESS.matcher(email.value).matches()) {
                                    if (NetworkChecker(context).isInternetConnected) {
                                        signUpEvent.invoke()
                                    } else {
                                        Toast
                                            .makeText(
                                                context,
                                                "Please, Connect to Internet!",
                                                Toast.LENGTH_SHORT
                                            ).show()
                                    }
                                } else {
                                    Toast.makeText(
                                        context,
                                        "Email format is not true!",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            } else {
                                Toast.makeText(
                                    context,
                                    "Password characters are not more than 8!",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        } else {
                            Toast.makeText(
                                context,
                                "Passwords aren't them same!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } else {
                        Toast
                            .makeText(
                                context,
                                "Please, fill out the blanks!",
                                Toast.LENGTH_SHORT
                            ).show()
                    }

                },
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

                TextButton(
                    onClick = {
                        navigation.navigate(MyScreens.SignInScreen.route) {
                            /* delete from back-stack */
                            popUpTo(MyScreens.SignUpScreen.route) { inclusive = true }
                        }
                    }
                ) {
                    Text(text = "Login", color = Blue)
                }

            }

        }
    }

}

@Composable
fun MainTextField(edtValue: String, icon: Int, hint: String, onValueChanges: (String) -> Unit) {

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

@Composable
fun PasswordTextField(edtValue: String, icon: Int, hint: String, onValueChanges: (String) -> Unit) {
    val passwordVisible = remember { mutableStateOf(false) }

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
            .padding(top = 12.dp),
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val image = if (passwordVisible.value) painterResource(id = R.drawable.ic_invisible)
            else painterResource(id = R.drawable.ic_visible)

            Icon(
                painter = image,
                contentDescription = null,
                modifier = Modifier.clickable { passwordVisible.value = !passwordVisible.value }
            )
        }
    )

}
