package info.fekri.dunibazaar.ui.features.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import info.fekri.dunibazaar.R
import info.fekri.dunibazaar.ui.theme.BackgroundMain
import info.fekri.dunibazaar.ui.theme.CardViewBackground
import info.fekri.dunibazaar.ui.theme.MainAppTheme
import info.fekri.dunibazaar.ui.theme.Shapes

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainScreenPreview() {
    MainAppTheme {
        Surface(
            color = BackgroundMain,
            modifier = Modifier.fillMaxSize()
        ) {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {

    val uiController = rememberSystemUiController()
    SideEffect { uiController.setStatusBarColor(Color.White) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(bottom = 16.dp)
    ) {

        TopToolbar()

        CategoryBar()

        ProductSubject()

        ProductSubject()

        BigPictureAdvertise()

        ProductSubject()

        ProductSubject()

    }

}

// -------------------------------------------------------------------------

@Composable
fun TopToolbar() {
    TopAppBar(
        elevation = 0.dp,
        backgroundColor = Color.White,
        title = { Text(text = "DuniBazaar") },
        actions = {
            IconButton(onClick = {}) {
                Icon(Icons.Default.ShoppingCart, contentDescription = null)
            }

            IconButton(onClick = {}) {
                Icon(Icons.Default.Person, contentDescription = null)
            }
        }
    )
}

// -------------------------------------------------------------------------

@Composable
fun CategoryBar() {

    LazyRow(
        modifier = Modifier.padding(top = 16.dp),
        contentPadding = PaddingValues(end = 16.dp)
    ) {
        items(10) {
            CategoryItem()
        }
    }

}

@Composable
fun CategoryItem() {

    Column(
        modifier = Modifier
            .padding(start = 16.dp)
            .clickable { },
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Surface(
            shape = Shapes.medium,
            color = CardViewBackground,
        ) {
            Image(
                modifier = Modifier.padding(16.dp),
                painter = painterResource(id = R.drawable.ic_icon_app),
                contentDescription = null
            )
        }

        Text(
            text = "Hotels",
            modifier = Modifier.padding(top = 4.dp),
            style = TextStyle(color = Color.Gray)
        )

    }

}

// -------------------------------------------------------------------------

@Composable
fun ProductSubject() {

    Column(
        modifier = Modifier.padding(top = 32.dp)
    ) {
        Text(
            text = "Popular Destinations",
            modifier = Modifier.padding(start = 16.dp),
            style = MaterialTheme.typography.h6
        )

        ProductBar()
    }

}

@Composable
fun ProductBar() {
    LazyRow(
        modifier = Modifier.padding(top = 16.dp),
        contentPadding = PaddingValues(end = 16.dp)
    ) {
        items(10) { ProductItem() }
    }
}

@Composable
fun ProductItem() {

    Card(
        modifier = Modifier
            .padding(start = 16.dp)
            .clickable { },
        elevation = 4.dp,
        shape = Shapes.medium
    ) {

        Column {
            Image(
                modifier = Modifier.size(200.dp),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.img_intro),
                contentDescription = null
            )

            Column(
                modifier = Modifier.padding(10.dp)
            ) {
                Text(
                    text = "Diamond Woman Watches",
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium
                    )
                )
                Text(
                    modifier = Modifier.padding(top =  4.dp),
                    text = "86,000 Tomans",
                    style = TextStyle(fontSize = 14.sp)
                )
                Text(
                    text = "156 sold",
                    style = TextStyle(
                        color = Color.Gray,
                        fontSize = 13.sp
                    )
                )
            }
        }

    }

}

// -------------------------------------------------------------------------

@Composable
fun BigPictureAdvertise() {

    Image(
        modifier = Modifier
            .fillMaxWidth()
            .height(260.dp)
            .padding(top = 32.dp, start = 16.dp, end = 16.dp)
            .clip(Shapes.medium)
            .clickable {  },
        painter = painterResource(id = R.drawable.img_intro),
        contentDescription = null,
        contentScale = ContentScale.Crop,
    )

}

// -------------------------------------------------------------------------
