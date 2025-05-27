package com.bc.androidperfbenchmark.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bc.androidperfbenchmark.R
import com.bc.androidperfbenchmark.anim.infiniteRotatingAnim

@Composable
fun ScrollingListPerf() {
    val rotation by infiniteRotatingAnim()
    val painters = remember {
        pictureList
    }.map { painterResource(it) }

    LazyColumn {
        items(300) {
            RowListWithImages(rotation, painters)
        }
    }
}

@Composable
fun RowListWithImages(rotation: Float, painters: List<Painter>) {
    LazyRow {
        items(painters) { painter ->
            Box {
                Image(
                    painter,
                    contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
                        .rotate(rotation)
                )
            }
        }
    }
}

val pictureList = listOf(
    R.drawable.image1,
    R.drawable.image2,
    R.drawable.image3,
    R.drawable.image1,
    R.drawable.image2,
    R.drawable.image3,
    R.drawable.image1,
    R.drawable.image2,
    R.drawable.image3,
    R.drawable.image1,
    R.drawable.image2,
    R.drawable.image3,
    R.drawable.image1,
    R.drawable.image2,
    R.drawable.image3,
    R.drawable.image1,
    R.drawable.image2,
    R.drawable.image3,
    R.drawable.image1,
    R.drawable.image2,
    R.drawable.image3,
    R.drawable.image1,
    R.drawable.image2,
    R.drawable.image3,
    R.drawable.image1,
    R.drawable.image2,
    R.drawable.image3,
    R.drawable.image1,
    R.drawable.image2,
    R.drawable.image3,
)