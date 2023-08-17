package com.example.superheroespractice

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroespractice.model.Hero
import com.example.superheroespractice.model.HeroesRepository.heroes
import com.example.superheroespractice.ui.theme.SuperheroesPracticeTheme


@Composable
fun HeroesScreen(heroes: Hero, modifier: Modifier = Modifier){
    Card  (
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier
            //.fillMaxWidth()
           // .clip(MaterialTheme.shapes.large),

    ){
        Row(
          //  verticalAlignment = Alignment.CenterVertically,
          // horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
               // .height(104.dp)
                .padding(16.dp)
                .sizeIn(minHeight = 72.dp)
        ) {
            var heroAvatar =  painterResource(heroes.imageRes)
            var heroDescription = stringResource(id = heroes.descriptionRes)
            var heroName = stringResource(heroes.nameRes)
            Column (modifier = Modifier.weight(1f)){
                Text(text = heroName.toString(), style = MaterialTheme.typography.displaySmall)
                Text(text = heroDescription, style = MaterialTheme.typography.bodyLarge)
            }
            Spacer(Modifier.width(16.dp))
            Box (
                modifier = Modifier
                    .size(72.dp)
                    .clip(RoundedCornerShape(8.dp))
            ){

                Image(
                    painter = heroAvatar ,
                    contentDescription = heroDescription,
                    alignment = Alignment.TopCenter,
                    contentScale = ContentScale.FillWidth

                )
            }

        }
    }
}


