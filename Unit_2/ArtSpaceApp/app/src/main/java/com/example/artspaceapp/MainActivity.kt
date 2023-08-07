package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpace()
                }
            }
        }
    }
}

@Composable
fun ArtSpace() {
    var imageId by remember { mutableStateOf(1) }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DisplayArt(imageId)
        DisplayInfo(imageId)
        DisplayFooter(
            imageId = imageId,
            onAction = { action ->
                when (action) {
                    Action.Rewind -> {
                        imageId = if (imageId == 1) 4 else imageId - 1
                    }
                    Action.Next -> {
                        imageId = if (imageId == 4) 1 else imageId + 1
                    }
                }
            }
        )
    }
}

enum class Action {
    Rewind, Next
}

@Composable
fun DisplayArt(imageId: Int) {
    var image = painterResource(id = GetMeImage(imageId))
    Image(painter = image, contentDescription = "desc")
}

@Composable
fun DisplayFooter(
    imageId: Int,
    onAction: (Action) -> Unit,
    modifier: Modifier = Modifier,
    verticalAlignment: Alignment = Alignment.Center,
    horizontal: Arrangement.HorizontalOrVertical = Arrangement.Center
) {
    Row(
        modifier = modifier,
        verticalAlignment  = Alignment.CenterVertically
    ) {
        androidx.compose.material3.Button(
            onClick = { onAction(Action.Rewind) },
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = "Rewind")
        }
        androidx.compose.material3.Button(
            onClick = { onAction(Action.Next) },
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = "Next")
        }
    }
}

@Composable
fun DisplayInfo(imageId: Int,modifier: Modifier = Modifier) {
    Column(
        verticalArrangement  = Arrangement.Center,
        horizontalAlignment  = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Text(
            fontSize = 23.sp,
            fontWeight = FontWeight.Bold,
            text = stringResource(id = GetMeTitle(imageId)),
            modifier = modifier
                .padding(10.dp)
        )
        Text(
            text = stringResource(id = GetMeImageDescription(imageId)) ,
            fontSize = 18.sp,
            fontStyle = FontStyle.Italic,
            modifier = modifier
                .padding(bottom = 10.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceAppTheme {
        ArtSpace()
    }
}


private fun GetMeImage(imageId: Int):Int{
    return when(imageId){
        1 -> R.drawable.borg_against_hu_0
        2 -> R.drawable.borg_against_hu_1
        3 -> R.drawable.borg_enjoying_i_0
        else -> R.drawable.borg_enjoying_i_1
    }
}
private fun GetMeImageDescription(imageId: Int):Int{
    return when(imageId){
        1 -> R.string.Borg_description_1
        2 -> R.string.Borg_description_2
        3 -> R.string.Borg_description_3
        else -> R.string.Borg_description_4
    }
}
private fun GetMeTitle(imageId: Int):Int{
    return when(imageId){
        1 -> R.string.Borg_title_1
        2 -> R.string.Borg_title_2
        3 -> R.string.Borg_title_3
        else -> R.string.Borg_title_4
    }
}
