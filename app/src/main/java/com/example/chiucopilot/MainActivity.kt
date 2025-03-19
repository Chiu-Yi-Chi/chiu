package com.example.chiucopilot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chiucopilot.ui.theme.ChiucopilotTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChiucopilotTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MultiplicationTable(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MultiplicationTable(modifier: Modifier = Modifier) {
    // 使用 LazyColumn 顯示 99 乘法
    LazyColumn(modifier = modifier.padding(16.dp)) {
        items(9) { i -> // 1 到 9
            Row(modifier = Modifier.fillMaxWidth()) {
                for (j in 1..9) { // 1 到 9
                    Text(
                        text = "${i + 1} x ${j} = ${(i + 1) * j}",
                        modifier = Modifier.weight(1f).padding(4.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MultiplicationTablePreview() {
    ChiucopilotTheme {
        MultiplicationTable()
    }
}
