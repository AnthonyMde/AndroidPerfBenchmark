package com.bc.androidperfbenchmark.component

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
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.bc.androidperfbenchmark.R
import com.bc.androidperfbenchmark.anim.infiniteRotatingAnim

@Composable
fun ScrollingListPerf() {
    val images = remember {
        listOf(
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3
        )
    }
    
    val rowImages = remember {
        List(30) { index -> images[index % 3] }
    }
    
    // Single shared rotation animation state for all images
    val rotation by infiniteRotatingAnim()
    
    LazyColumn {
        items(300) { _ ->
            LazyRow {
                items(rowImages) { imageRes ->
                    RotatingImage(
                        imageRes = imageRes,
                        rotation = rotation
                    )
                }
            }
        }
    }
}

@Composable
private fun RotatingImage(
    imageRes: Int,
    rotation: Float
) {
    Box(modifier = Modifier.size(50.dp)) {
        AsyncImage(
            model = imageRes,
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .rotate(rotation)
        )
    }
}