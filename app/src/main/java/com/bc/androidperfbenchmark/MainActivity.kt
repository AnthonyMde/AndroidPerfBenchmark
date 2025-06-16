package com.bc.androidperfbenchmark

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.bc.androidperfbenchmark.ui.theme.AndroidPerfBenchmarkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val infiniteTransition = rememberInfiniteTransition()
            val angle by infiniteTransition.animateFloat(
                initialValue = 0f,
                targetValue = 360f,
                animationSpec = infiniteRepeatable(
                    animation = tween(durationMillis = 1000, easing = LinearEasing)
                )
            )

            AndroidPerfBenchmarkTheme {
                Column(
                    modifier = Modifier
                        .safeContentPadding()
                        .fillMaxSize()
                        .background(Color.White),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    LazyColumn {
                        items(300, key = { it }) {
                            TestRow(angle)
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun RotatingImage(@DrawableRes drawable: Int, angle: Float) {
        AsyncImage(
            model = drawable,
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .clip(RoundedCornerShape(8.dp))
                .rotate(angle)
        )
    }

    @Composable
    fun TestRow(angle: Float) {
        LazyRow {
            itemsIndexed(
                repeatedPictureList,
                key = { item, index -> "$item-$index" }) { index, drawable ->
                Box(modifier = Modifier.size(50.dp)) {
                    RotatingImage(drawable, angle)
                }
            }
        }
    }

    val pictureList = listOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3
    )

    @Stable
    val repeatedPictureList = buildList {
        repeat(10) {
            addAll(pictureList)
        }
    }
}
