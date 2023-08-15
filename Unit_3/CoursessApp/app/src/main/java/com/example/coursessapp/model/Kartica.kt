package com.example.coursessapp.model

import DataSource.topics
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coursessapp.R
import com.example.coursessapp.ui.theme.CoursessAppTheme

@SuppressLint("InvalidColorHexValue")
@Composable
fun CardTopic(
    topic: Topic
){
    val imgSize = 68.dp
    val bgColor = Color(0xFFE70EC)
    Card (

    )
    {
        Row( modifier = Modifier
            .defaultMinSize(170.dp).background(color = bgColor)
        ) {
            Box {
                Image(
                    painter = painterResource(id = topic.icon_topic),
                    contentDescription = stringResource(id = topic.topic_description),
                    modifier = Modifier
                        .size(width = imgSize, height =imgSize)
                        //.clip(RoundedCornerShape(topStart = 8.dp, bottomStart = 8.dp))
                        .aspectRatio(1f),
                    contentScale = ContentScale.Crop,
                )
            }
            Column(

            ) {
                Text(
                    text = stringResource(id = topic.topic_description),
                    style = MaterialTheme.typography.bodySmall,
                    overflow = TextOverflow.Clip,

                    modifier = Modifier
                        .padding(
                            start = 16.dp, top = 16.dp,
                            end = 16.dp, bottom = 8.dp
                        )
                )
                Row(verticalAlignment = Alignment.CenterVertically
                    ) {
                    Icon(
                        painter = painterResource(id = R.drawable.raw_githubusercontent_com_android_compose_samples_main_owl_app_src_main_res_drawable_ic_grain),
                        contentDescription = "Icon",
                        modifier = Modifier
                            .padding(start =16.dp)
                    )
                    Text(
                        text = topic.users.toString(),
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier
                            .padding(start=8.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CourseAppPreview() {
    CoursessAppTheme {
            CardTopic(topic = topics[4])


    }
}