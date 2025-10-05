package com.example.captaingame

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.captaingame.ui.theme.CaptainGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CaptainGameTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CaptainGame(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun CaptainGame(modifier: Modifier)
{
    var treasuresFound by remember { mutableStateOf(0) }
    val direction = remember { mutableStateOf("North") }
    val stormOrTreasure = remember { mutableStateOf("") }
    val context = LocalContext.current
    Column (modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center)
    {
        Text("Treasures Found: ${treasuresFound}")
        Text("Direction: ${direction.value}")
        Text("${stormOrTreasure.value}")
        Spacer(Modifier.padding(16.dp))
        Row () {
            Button({
                direction.value = "North"
                if (Random.nextBoolean()) {
                    treasuresFound += 1
                    stormOrTreasure.value = "Found a Treasure!"
                } else {
                    stormOrTreasure.value = "Storm Ahead!"
                }
                Toast.makeText(context, "Sail North!", Toast.LENGTH_SHORT).show()
            })
            {
                Text("Sail North!")
            }
            Spacer(Modifier.padding(16.dp))
            Button({
                direction.value = "South"
                if (Random.nextBoolean()) {
                    treasuresFound += 1
                    stormOrTreasure.value = "Found a Treasure!"
                } else {
                    stormOrTreasure.value = "Storm Ahead!"
                }
                Toast.makeText(context, "Sail South!", Toast.LENGTH_SHORT).show()
            })
            {
                Text("Sail South!")
            }
            Spacer(Modifier.padding(16.dp))
        }
        Row () {
            Button({
                direction.value = "East"
                if (Random.nextBoolean()) {
                    treasuresFound += 1
                    stormOrTreasure.value = "Found a Treasure!"
                } else {
                    stormOrTreasure.value = "Storm Ahead!"
                }
                Toast.makeText(context, "Sail East!", Toast.LENGTH_SHORT).show()
            })
            {
                Text("Sail  East!")
            }
            Spacer(Modifier.padding(16.dp))
            Button({
                direction.value = "West"
                if (Random.nextBoolean()) {
                    treasuresFound += 1
                    stormOrTreasure.value = "Found a Treasure!"
                } else {
                    stormOrTreasure.value = "Storm Ahead!"
                }
                Toast.makeText(context, "Sail West!", Toast.LENGTH_SHORT).show()
            })
            {
                Text("Sail  West!")
            }
            Spacer(Modifier.padding(16.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CaptainGamePreview() {
    CaptainGameTheme{
        CaptainGame(modifier = Modifier.fillMaxSize())
    }
}