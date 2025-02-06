package com.example.hw2_3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hw2_3.ui.theme.Hw2_3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Hw2_3Theme {
                val music = "反方向的钟"
                Column(
                    modifier = Modifier.fillMaxSize(1f).padding(horizontal = 3.dp, vertical = 10.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    musicPlayer(music = music)
                }
            }
        }
    }

    @Composable
    fun musicPlayer(music: String) {
        var clicked by rememberSaveable { mutableStateOf(false) }
        Box(
            modifier =
                Modifier.fillMaxWidth(0.7f).height(300.dp).clip(RoundedCornerShape(10.dp)).background(
                    brush =
                        Brush.linearGradient(
                            colors =
                                listOf(
                                    Color(0xFF3b8196),
                                    Color(0xFF31588f),
                                    Color(0xFF243982),
                                ),
                        ),
                ),
        ) {
            Column(
                modifier = Modifier.fillMaxSize().padding(all = 10.dp),
                verticalArrangement = Arrangement.SpaceAround,
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().fillMaxHeight(0.6f),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.mus),
                        contentDescription = "Jay Chou",
                        modifier = Modifier.height(150.dp).width(150.dp).clip(RoundedCornerShape(10.dp)),
                    )
                    Text(text = music, modifier = Modifier, softWrap = true, color = Color(0xFFd0f2f2), fontSize = 15.sp)
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    TextButton(onClick = { Unit }) {
                        Image(
                            painter = painterResource(R.drawable.previous),
                            contentDescription = "previous",
                            modifier = Modifier.height(20.dp).width(20.dp),
                        )
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                    TextButton(onClick = { clicked = !clicked}) {
                        if (clicked) {
                            Image(
                                painter = painterResource(R.drawable.pause),
                                contentDescription = "Pause",
                                modifier = Modifier.height(40.dp).width(40.dp),
                            )
                        } else {
                            Image(
                                painter = painterResource(R.drawable.play),
                                contentDescription = "Play",
                                modifier = Modifier.height(30.dp).width(30.dp),
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(20.dp))
                    TextButton(onClick = { Unit }) {
                        Image(
                            painter = painterResource(R.drawable.next),
                            contentDescription = "Next",
                            modifier = Modifier.height(20.dp).width(20.dp),
                        )
                    }
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun test() {
        Hw2_3Theme {
            val music = "反方向的钟"
            Column(
                modifier = Modifier.fillMaxSize(1f).padding(horizontal = 3.dp, vertical = 10.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                musicPlayer(music = music)
            }
        }
    }
}
