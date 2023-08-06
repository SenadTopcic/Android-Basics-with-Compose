package com.example.diceroler

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diceroler.ui.theme.DiceRolerTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRolerTheme {
                DiceRollerApp()
            }
        }
    }
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)//center components verticaly and horizontaly
){
    var diceResource by remember { mutableStateOf(R.drawable.dice_1) }
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Image(painter = painterResource(id = diceResource), contentDescription =diceResource.toString() )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { diceResource = rollDice() }){
            Text(text = stringResource(R.string.roll))
        }
    }
}

fun rollDice(): Int {
    val dicesList = listOf(
        R.drawable.dice_1,
        R.drawable.dice_2,
        R.drawable.dice_3,
        R.drawable.dice_4,
        R.drawable.dice_5,
        R.drawable.dice_6
    )
    return dicesList.random()
}


@Preview
@Composable
fun DiceRollerApp(){
    DiceWithButtonAndImage()
}

