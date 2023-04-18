package info.fekri.dunibazaar.ui.features.signUp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import info.fekri.dunibazaar.R
import info.fekri.dunibazaar.ui.features.IntroScreen
import info.fekri.dunibazaar.ui.theme.BackgroundMain
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
