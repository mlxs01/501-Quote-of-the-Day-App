package com.example.assignment2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.assignment2.ui.theme.Assignment2Theme
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assignment2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val motivations = arrayOf(
                        "We cannot solve problems with the kind of thinking we employed when we came up with them.",
                        "Learn as if you will live forever, live like you will die tomorrow.",
                        "Stay away from those people who try to disparage your ambitions. Small minds will always do that, but great minds will give you a feeling that you can become great too.",
                        "When you give joy to other people, you get more joy in return. You should give a good thought to the happiness that you can give out.",
                        "When you change your thoughts, remember to also change your world.",
                        "It is only when we take chances that our lives improve. The initial and the most difficult risk we need to take is to become honest.",
                        "Nature has given us all the pieces required to achieve exceptional wellness and health, but has left it to us to put these pieces together."
                    )
                    var clicked by remember { mutableIntStateOf(0) }
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .padding(16.dp) // I heard dp is the best use of
                        // pixel measurement in Android Studio
                    ) {
                        Button(onClick = {
                            clicked = (0..10).random() //one time change on clicked variable
                        }) {
                            Text("Give Quote")
                        }
                        Greeting(
                            quotes = motivations[clicked],
                            modifier = Modifier.padding(innerPadding)
                        )

                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(quotes: String, modifier: Modifier = Modifier) {
    Text(
        text = quotes,
        modifier = modifier,
        color = Color.Blue,
        fontStyle = FontStyle.Italic
    )
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Assignment2Theme {
        Greeting("Android")
    }
}