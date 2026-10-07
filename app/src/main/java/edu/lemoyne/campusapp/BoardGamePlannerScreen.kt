package edu.lemoyne.campusapp

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.lemoyne.campusapp.ui.theme.CampusAppTheme

// class 9 step 3
@Composable
fun ListScreen(
    BoardGames: List<android.R.string>,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding (24.dp)
    ){
        TextButton(onClick = onBack){
            Text(text = "back")
        }

        Text(
            text = "All Games",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))


    }
}
const val MAX_NAME_LENGTH = 30



//-- Class 8: Step 2: One rulebook for boardgame names --//
fun validateNewGameName(input: String, existing: List<String>): String? {
    val name = input.trim()
    return when {
        //-- Lab 8: Task 1: Min length --//
        name.isEmpty() -> "Enter a board game"
        name.length < 3 -> "Too short, 3 characters minimum"
        name.length > MAX_NAME_LENGTH -> "Enter $MAX_NAME_LENGTH or less"

        //-- Lab 8: Task 2: My own rule --//
        name.contains("  ") -> "No double spaces"
        existing.any { it.equals(name, ignoreCase = true) } -> "\"$name\" is already on the list"
        else -> null
    }
}
// class 9 step 2
@Composable
fun BoardGamePlannerScreen (

)
{
    fun HomeScreen(modifier: Modifier = Modifier){

    }
}
//-- Class 6: Step 1: My own screen --//
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    //-- Class 6: Step 3: A column, so things stack --//
    //-- Class 7: Step 2: The list lives in a state --//
    val BoardGames = remember {
        mutableStateListOf("Orleans", "Kingsburg", "Ark Nova", "Terra Mystica")
    }
    //Class 9 step 4
    var currentScreen by rememberSaveable { mutableStateOf( "home")}

    when (currentScreen){
        "home" -> HomeScreen(
        )
    }
    HomeScreen(

    )

    //-- Class 7: Step 2: The error message lives in the state too --//
    var error by remember { mutableStateOf<String?>(value = null) }

    //-- Class 7: Step 3: What's typed lives in the state --//
    var newGame by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {
        //-- Lab 6: Task 3: Adding a picture --//
        Image(
            painter = painterResource(id = R.drawable.header),
            contentDescription = "A penguin pile up, in German.",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        )

        //-- Class 6: Step 4: real styling --//
        Text(
            text = "Boardgame Planner",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )

        //-- Lab 6: Task 1: Customizing my screen more --//
        Spacer(modifier = Modifier.height(8.dp))

        //-- Class 7: Step 3a: The fields of text --//
        OutlinedTextField(
            value = newGame,
            //-- Class 8: Step 4: The field itself pushes back --//
            onValueChange = {
                newGame = it.take(MAX_NAME_LENGTH)
                error = null
            },
            label = { Text("Game Name") },
            singleLine = true,
            isError = error != null,
            modifier = Modifier.fillMaxWidth()
        )

        //-- Class 8: Step 3: show the problem --//
        error?.let { message ->
            Text(
                text = message,
                color = MaterialTheme.colorScheme.error,
                fontSize = 14.sp
            )
        }

        //-- Lab 7: Task 4: A live character counter --//
        Text(
            text = "${newGame.length} / $MAX_NAME_LENGTH",
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        //-- Class 7: Step 4: The button changes the state --//
        Button(
            onClick = {
                //-- Class 8: Step 3a: Check before you add --//
                val problem = validateNewGameName(input = newGame, existing = BoardGames)
                if (problem == null) {
                    //-- Class 9: Step 2a: Ask the owner to add it --//
                    BoardGames.add(newGame.trim())
                    newGame = ""
                } else {
                    error = problem
                }
            },
            //-- Class 8: Step 5: The sign on the door, not the lock --//
            enabled = newGame.isNotBlank()
        ) {
            Text("Add Boardgame")
        }

        //-- Lab 7: Task 1: Remove the last item --//
        Button(onClick = {
            if (BoardGames.isNotEmpty()) {
                BoardGames.removeAt(BoardGames.lastIndex)
            }
        }) {
            Text("Remove last game from list")
        }

        //-- Lab 7: Task 3: Clear all --//
        Button(onClick = {
            BoardGames.clear()
        }) {
            Text("Clear All")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "---Boardgames I want to play---",
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(24.dp))

        //-- Lab 6 Step 1: Subheader added, modified list --//
        Text(
            text = "I have played these, but want to play again:",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )

        //-- Class 7: Step 2a: Draw the list --//
        Text(
            //-- Lab 7: Task 2: Singular and plural --//
            text = if (BoardGames.size == 1) "1 Board Game" else "${BoardGames.size} Boardgames",
            fontWeight = FontWeight.Bold
        )

        for (BoardGames in BoardGames) {
            Text(text = BoardGames, fontSize = 18.sp)
        }

        //-- Lab 6 Task 1: New header and list added --//
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

        //-- Lab 6: Task 2: A footer --//
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Last updated September 2026",
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.outline
        )
        // CounterDemo()
    }
}

//-- Lab 6: Task 4: Dark mode --//
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomeScreenDarkPreview() {
    CampusAppTheme {
        Surface {
            BoardGamePlannerScreen()
        }
    }
}

//-- Class 6: Step 2: preview --//
@Preview
@Composable
fun HomeScreenPreview() {
    CampusAppTheme {
        BoardGamePlannerScreen()
    }
}

// Monday's bug and
//-- Class 7: Step 1: A counter that remembers --//
// @Composable
// fun CounterDemo() {
//     var count by rememberSaveable { mutableStateOf(0) }
//     Button(onClick = { count++ }) {
//         Text("Tapped $count times")
//     }
// }