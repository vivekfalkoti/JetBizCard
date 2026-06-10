package com.example.jetbizcard

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetbizcard.ui.theme.JetBizCardTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetBizCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Card(
            modifier = Modifier
                .width(100.dp)
                .height(390.dp)
                .padding(20.dp),
            shape = RoundedCornerShape(30.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
        ) {
            Column(
                modifier = Modifier
                    .height(600.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CreateImageProfile()
                HorizontalDivider(thickness = 5.dp, color = Color.LightGray)
                CreateProfileInfo()
                Button(onClick = {}, Modifier.padding(top = 30.dp)) {
                    Text(text = "Portfolio", style = MaterialTheme.typography.headlineSmall)
                }
            }

        }
    }
}

@Composable
private fun CreateProfileInfo() {
    Text(
        modifier = Modifier.padding(top = 50.dp),
        text = "Vivek Falkoti",
        style = MaterialTheme.typography.headlineLarge,
        color = MaterialTheme.colorScheme.primary
    )
    Text(
        modifier = Modifier.padding(top = 20.dp),
        text = "Native Android Developer",
        style = MaterialTheme.typography.headlineSmall
    )
    Text(
        modifier = Modifier.padding(top = 20.dp),
        text = "Linkedln : @vivekfalkoti",
        style = MaterialTheme.typography.headlineSmall
    )
}

@Composable
private fun ColumnScope.CreateImageProfile() {
    Surface(
        modifier = Modifier
            .size(280.dp)
            .padding(35.dp),
        shape = CircleShape,
        border = BorderStroke(1.dp, Color.White),
        shadowElevation = 4.dp
    ) {
        Image(
            painter = painterResource(id = R.drawable.vf_image),
            contentDescription = "profile image",
            modifier = Modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetBizCardTheme {
        CreateBizCard()
    }
}