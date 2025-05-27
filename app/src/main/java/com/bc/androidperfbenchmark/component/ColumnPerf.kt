package com.bc.androidperfbenchmark.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bc.androidperfbenchmark.R
import com.bc.androidperfbenchmark.anim.infiniteRotatingAnim

const val NUMBER_OF_ROWS = 100
val images = listOf(
    R.drawable.image1,
    R.drawable.image2,
    R.drawable.image3,
    R.drawable.image1,
    R.drawable.image2,
)

@Composable
fun ColumnPerf() {
    repeat(NUMBER_OF_ROWS) {
        RowImages()
    }
}

@Composable
fun RowImages() {
    val rotation by infiniteRotatingAnim()
    Row {
        images.forEachIndexed { index, drawable ->
            Box {
                Image(
                    painterResource(drawable),
                    contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
                        .rotate(rotation)
                )
            }
        }
    }
}