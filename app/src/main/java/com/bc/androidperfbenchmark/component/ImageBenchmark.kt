package com.bc.androidperfbenchmark.component

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.bc.androidperfbenchmark.R

@Composable
fun ImageBenchmark() {
    val infiniteTransition = rememberInfiniteTransition()
    val angle by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000, easing = LinearEasing)
        )
    )
    LazyColumn {
        items(3000, key = { it }) {
            ImageRow(angle)
        }
    }
}

@Composable
private fun ImageRow(angle: Float) {
    LazyRow {
        itemsIndexed(repeatedPictureList, key = { index, drawable ->
            "$drawable-$index"
        }) { index, drawable ->
            Box(modifier = Modifier.size(50.dp)) {
                RotatingImage(drawable, angle)
            }
        }
    }
}

@Composable
private fun RotatingImage(@DrawableRes drawable: Int, angle: Float) {
    AsyncImage(
        model = drawable,
        contentDescription = null,
        modifier = Modifier
            .size(50.dp)
            .clip(RoundedCornerShape(8.dp))
            .rotate(angle)
    )
}

private val pictureList = listOf(
    R.drawable.image1,
    R.drawable.image2,
    R.drawable.image3
)

private val repeatedPictureList = buildList {
    repeat(10) {
        addAll(pictureList)
    }
}