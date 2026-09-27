package edu.lemoyne.campusapp

import android.content.res.Configuration
import android.os.Bundle
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.lemoyne.campusapp.ui.theme.CampusAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CampusAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


// --- Class 6: Step 1:  My own screen ---
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    // ---- Class 6: Step 3: A column, so things stack ---
    Column(
        modifier = modifier
        .fillMaxWidth()
        .padding(24.dp)
    )

    {
        //--- Lab 6: Step 3: Adding a picture ---//
        Image(
            painter = painterResource(id = R.drawable.header),
            contentDescription = "A penguin pile up, in German.",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        )
        // --- Class 6: Step 4: real styling---
        Text(
            text = "Boardgame Planner",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )

        //--- Lab 6: Task 1: Customizing my screen more ----//
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "---Board games I want to play---",
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(24.dp))

        //-- Lab 6 Task 1: Sub header added, modified list.---
        Text(
            text = "I have played these, but want to play again:" ,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold

        )

        Text(text = "Orleans", fontSize = 16.sp)
        Text(text = "Kingsburgh", fontSize = 16.sp)
        Text(text = "Ark Nova", fontSize = 16.sp)
        Text(text = "Terra Mystica",fontSize = 16.sp)

        //--- Lab 6 Task1: New header and list added.---
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Expansions I want to play:",
            fontSize = 18.sp,
            fontWeight = FontWeight.W900
        )

        Text(text = "MagLev map pack 2", fontSize = 14.sp)
        Text(text = "Forest Shuffle: Alpine", fontSize = 14.sp)
        Text(text = "Slay the Spire: Downfall", fontSize = 14.sp)
        Text(text = "Everdell: Newleaf", fontSize = 14.sp)

        //---Lab 6: Task 2: A footer--//
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Last updated September 2026",
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.outline
        )
    }



}
//---Lab 6: Task 4: Dark mode ----
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomeScreenDarkPreview(){
    CampusAppTheme() {
        Surface {
            HomeScreen()
        }
    }
}
@Preview
@Composable
fun HomeScreenPreview() {
    CampusAppTheme {
        HomeScreen()
    }
}