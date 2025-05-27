package com.bc.androidperfbenchmark

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.bc.androidperfbenchmark.component.ScrollingListPerf
import com.bc.androidperfbenchmark.ui.theme.AndroidPerfBenchmarkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidPerfBenchmarkTheme {
                Column(
                    modifier = Modifier
                        .safeContentPadding()
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    ScrollingListPerf()
//                        ColumnPerf()
                }
            }
        }
    }
}
