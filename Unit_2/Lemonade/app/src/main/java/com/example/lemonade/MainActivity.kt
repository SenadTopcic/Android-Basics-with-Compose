package com.example.lemonade

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                Lemonade()
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Lemonade(modifier : Modifier = Modifier
    ){
    var result by remember {
        mutableStateOf(1)
    }
    var increment =1
    var randomSqueese by remember { mutableStateOf((2..4).random())}
    var shouldHandleClick by remember { mutableStateOf(true) }

    val lemonadeProcess = when(result){
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    val lemonadeDisplay = when(result){
        1 -> R.string.lemon_tree_displ
        2 -> R.string.lemon_squeese_displ
        3 -> R.string.lemon_drink_displ
        else -> R.string.lemon_empty_displ
    }
    val lemonadeContentDisplay = when(result){
        1 -> R.string.lemon_tree_content_description
        2 -> R.string.lemon_lemon_content_description
        3 -> R.string.lemon_glass_of_lemonade_content_description
        else -> R.string.lemon_empty_glass_content_description
    }

    Surface (
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,

            ) {
            Image(
                painter = painterResource(lemonadeProcess),
                contentDescription = stringResource(lemonadeContentDisplay),
                modifier = Modifier
                    .clickable {

                            if (result == 2) {
                                shouldHandleClick = false
                               // var randomSqueese = (2..4).random()
                                if (increment == randomSqueese) {
                                        increment = 0
                                        shouldHandleClick = true
                                    ++result
                                    if(shouldHandleClick) {
                                        randomSqueese = (2..4).random()
                                    }
                                }
                                increment++
                            }else if (shouldHandleClick) {
                            if (result == 4) result = 1
                            else ++result
                        }
                    }
            )
            Spacer(modifier = Modifier.height(16.dp))
            GetDescription(stringResource(lemonadeDisplay))
        }
    }

}


@Composable
fun GetDescription(
    text: String,
    modifier: Modifier = Modifier,

    ){
    Text(
        text = text,
        fontSize = 18.sp,
        modifier = modifier
        )
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    LemonadeTheme {
        Lemonade()
    }
}