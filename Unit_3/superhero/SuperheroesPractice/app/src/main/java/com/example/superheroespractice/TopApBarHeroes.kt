package com.example.superheroespractice

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarHeroes(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        title = {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){

                Text(
                    text = "Superheroes",
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        modifier = modifier
    )
}