package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    stateForCompose()
                }
            }
        }
    }
}

@Composable
fun NewsStory() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.header),
            contentDescription = "This image was downloaded",
            modifier = Modifier
                .fillMaxWidth()
                .clickable { } // ignoring click for now
        )
        Spacer(modifier = Modifier
            .height(24.dp)
            .fillMaxWidth()) // acts as a space between two components
        Text(text = "This is string 1", fontWeight = FontWeight.ExtraBold)
        Spacer(modifier = Modifier
            .height(12.dp)
            .fillMaxWidth())
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "This is string 2")
            Text(text = "This is string 3")
        }
    }
}

@Composable
fun stateForCompose() {
    val count = remember {
        mutableStateOf(0)
    }

    Column {
        Button(
            onClick = { count.value++ },
            modifier = Modifier.padding(16.dp),
            colors = ButtonDefaults.buttonColors(   //to change button color or type we use something like this
                backgroundColor = if(count.value % 2 == 0) Color.Blue else Color.Cyan,
                contentColor = if(count.value % 2 == 0) Color.White else Color.Black    //this changes color of text
            )
        ) {
            Text(text = "This button was clicked ${count.value} times")
        }

        Divider(modifier = Modifier
            .height(24.dp)
            .fillMaxWidth(), color = colorResource(id = R.color.black))

        Button(
            onClick = { count.value = 0 },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Reset count value")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        stateForCompose()
    }
}