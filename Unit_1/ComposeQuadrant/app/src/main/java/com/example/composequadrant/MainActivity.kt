package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxHeight


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DisplayForuPart()
                }
            }
        }
    }
}
@Composable
fun Quadrant(title: Int, text: Int, backgroundColor : Color, modifier: Modifier = Modifier){
        Column(
            modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(backgroundColor)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            Text(
                text = stringResource(id = title),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)

            )
            Text(
                text = stringResource(id = text),
                textAlign = TextAlign.Justify,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()

            )
        }
}

@Composable
fun DisplayForuPart( modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight(0.5f)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Quadrant(R.string.title_one, R.string.text_one, Color(0xFFEADDFF), Modifier.weight(1f))
            Quadrant(R.string.title_two, R.string.text_two, Color(0xFFD0BCFF), Modifier.weight(1f))
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Quadrant(R.string.title_one, R.string.text_one, Color(0xFFB69DF8), Modifier.weight(1f))
            Quadrant(R.string.title_two, R.string.text_two, Color(0xFFF6EDFF), Modifier.weight(1f))
        }
    }
}



@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    ComposeQuadrantTheme {
        DisplayForuPart()
    }
}