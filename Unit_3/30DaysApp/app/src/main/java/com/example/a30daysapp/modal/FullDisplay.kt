package com.example.a30daysapp.modal

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.a30daysapp.ui.theme._30DaysAppTheme

@Composable
fun FullDislay(quote: Quota, modifier: Modifier = Modifier){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding((16.dp))
    ) {
        Box {
            Column (
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(
                    painter = painterResource(id = quote.profileImageRes),
                    contentDescription = stringResource( id = quote.nameRes ),
                    contentScale  = ContentScale.Fit,
                    colorFilter = ColorFilter.colorMatrix(
                        ColorMatrix().apply { setToSaturation(0f) }),
                    modifier = Modifier
                        .width(200.dp)
                        .height(200.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
            }
        }
            SpeechBubble(quote=quote, modifier = Modifier.fillMaxWidth(1f))
    }
}

@Composable
fun SpeechBubble(quote: Quota, modifier: Modifier = Modifier, elevation: Dp = 8.dp) {
    Box(
        modifier = modifier
            .background(Color.White, shape = MaterialTheme.shapes.medium)
            .border(1.dp, Color.Black, shape = MaterialTheme.shapes.medium)
            .padding(8.dp),

    ) {
        Text(
            text= stringResource(id =quote.quotaRes ),
            modifier = Modifier
                .fillMaxWidth(),
            style = MaterialTheme.typography.labelSmall
        )
    }
}
@Preview(showBackground = true)
@Composable
fun FullDIsplayPreview() {
    val sampleQuote = Quotes.quotes[0]
    _30DaysAppTheme {
        FullDislay ( sampleQuote)
    }
}