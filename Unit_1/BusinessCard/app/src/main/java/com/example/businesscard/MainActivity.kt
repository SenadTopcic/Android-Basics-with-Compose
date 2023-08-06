package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}
@Composable
fun AndroidLogo(modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.android_logo)

    Image(
        painter = image,
        contentDescription ="android logo",
        modifier = Modifier
            .size(150.dp)
        )
}

@Composable
fun StopcicLogo(modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.logo)

    Image(painter = image, contentDescription ="android logo",
        modifier = Modifier
            .size(130.dp)
    )
}
@Composable
fun Intro(name: Int, occupation: Int, modifier: Modifier = Modifier){
    Column (

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = stringResource(name),
            color = Color(0xFF3ddc84),
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier

        )
        Text(
            text = stringResource(occupation),
            modifier = modifier
        )
    }
}
@Composable
fun ContactDetails(phone: Int, monkey: Int, email: Int, modifier: Modifier = Modifier){
    Text(
        text = stringResource(phone),
        modifier = modifier
    )
    Text(
        text = stringResource(monkey),
        modifier = modifier
    )
    Text(
        text = stringResource(email),
        modifier = modifier
    )
}
@Composable
fun BusinessCard( modifier: Modifier = Modifier) {

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxHeight(0.15F)
        ) {
            StopcicLogo()
        }
        Column  (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxHeight(0.5F)
        ){
            AndroidLogo()
            Intro(name = R.string.user_name, occupation = R.string.occupation)
        }
        Column (
            modifier = Modifier
                .fillMaxHeight(0.3f)
                .padding(start = 10.dp)
                .padding(top = 20.dp)
        ){
            ContactDetails(phone = R.string.phone, monkey = R.string.monkey, email = R.string.email)
        }
    }


}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}