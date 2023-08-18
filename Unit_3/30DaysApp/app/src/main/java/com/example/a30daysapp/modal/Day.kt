package com.example.a30daysapp.modal

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30daysapp.modal.Quotes.quotes
import com.example.a30daysapp.ui.theme._30DaysAppTheme

@Composable
fun Day(quote: Quota, modifier: Modifier = Modifier){
    var isDisplayedQuote by remember { mutableStateOf(false) }

    Card{
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)

        ){
            Text(text = "Quote of the day ${quote.id}:",
                style = MaterialTheme.typography.titleSmall)
            Text(
                text = stringResource(id = quote.nameRes),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )


            AnimatedVisibility(
                visible = isDisplayedQuote,
                enter = expandHorizontally( ),
                exit = shrinkHorizontally(
                    animationSpec = tween(durationMillis = 1500),
                    shrinkTowards = Alignment.End
                ) { fullWidth ->
                    fullWidth / 4
                }
            ) {

                if (isDisplayedQuote) {
                    FullDislay(quote)
                }

            }
            if (!isDisplayedQuote) {

                Display(quote)
            }

            Button(onClick = { isDisplayedQuote = !isDisplayedQuote},
                modifier = Modifier.padding(bottom = 15.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor =
                    if (isDisplayedQuote) MaterialTheme.colorScheme.onPrimary
                    else MaterialTheme.colorScheme.onError,
                    contentColor = MaterialTheme.colorScheme.primary,
                )

            ) {
                Text(if (isDisplayedQuote) "Hide quote" else "Show quote",
                style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DayPreview() {

    _30DaysAppTheme {
        Day(quotes[1])
    }
}