package edu.lemoyne.campusapp

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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

const val MAX_NAME_LENGTH = 30

// --- Class 8: Step 2: One rule for boardgame names ---
fun validateNewGameName(input: String, existing: List<String>): String? {
    val name = input.trim()
    return when {
        name.isEmpty() -> "Enter a board game"
        name.length < 3 -> "Too short, 3 characters minimum"
        name.length > MAX_NAME_LENGTH -> "Enter $MAX_NAME_LENGTH or less"
        name.contains("  ") -> "No double spaces"
        existing.any { it.equals(name, ignoreCase = true) } -> "\"$name\" is already on the list"
        else -> null
    }
}

// --- Class 9: Step 2: One owner for the all the data ---
@Composable
fun CampusAppScreen(modifier: Modifier = Modifier) {
    val boardGames = remember {
        mutableStateListOf("Orleans", "Kingsburgh", "Ark Nova", "Terra Mystica")
    }

    //-- Class 9: Step 4: Which screen is showing a state --//

    var currentScreen by rememberSaveable { mutableStateOf("home") }

    when (currentScreen) {
        "home" -> HomeScreen(
            boardGames = boardGames,
            onAddGame = { boardGames.add(it) },
            onSeeAll = { currentScreen = "list" },
            modifier = modifier
        )
        "list" -> ListScreen(
            boardGames = boardGames,
            onBack = { currentScreen = "home" },
            modifier = modifier
        )
    }
}

// --- Class 9: Step 2: Home screen gets its data from the outside ---//
@Composable
fun HomeScreen(
    boardGames: List<String>,
    onAddGame: (String) -> Unit,
    onSeeAll: () -> Unit,
    modifier: Modifier = Modifier
) {
    //-- Class 7: Step 3: What's typed lives in the state
    var newGame by remember { mutableStateOf("") }

    //-- Class 8: Step 3: The error message lives in the state too-- //
    var error by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.header),
            contentDescription = "A penguin pile up, in German.",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Boardgame Planner",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        //-- Class 7: Step3: The fields of text --//
        OutlinedTextField(
            value = newGame,
            //-- Class 8: Step 4: The field pushed back--//
            onValueChange = {
                newGame = it.take(MAX_NAME_LENGTH)
                error = null
            },
            label = { Text("Game Name") },
            singleLine = true,
            isError = error != null,
            modifier = Modifier.fillMaxWidth()
        )
        //-- Class 8: Step 3: Show the problem --//
        error?.let { message ->
            Text(
                text = message,
                color = MaterialTheme.colorScheme.error,
                fontSize = 14.sp
            )
        }

        Text(
            text = "${newGame.length} / $MAX_NAME_LENGTH",
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(8.dp))

        //-- Class 7: Step 4: The button changes the state --//
        Button(
            onClick = {
                //-- Class 8: Step 3: check it before you add it --//
                val problem = validateNewGameName(input = newGame, existing = boardGames)
                if (problem == null) {
                    onAddGame(newGame.trim())
                    newGame = ""
                    error = null
                } else {
                    error = problem
                }
            },
            //-- Class 8: Step 5: The sign on the door, not the lock --//
            enabled = newGame.isNotBlank()
        ) {
            Text("Add Boardgame")
        }

        Spacer(modifier = Modifier.height(24.dp))

        //-- Class 7: Step 2: Draw the list --//
        Text(
            text = if (boardGames.size == 1) "1 Board Game" else "${boardGames.size} Boardgames",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        //-- Class 9: Step 5: A path to the second screen --//
        Button(onClick = onSeeAll) {
            Text("See all games")
        }
    }
}

// --- Class 9 · Step 3: Second screen ---
@Composable
fun ListScreen(
    boardGames: List<String>,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    //-- Class 9: Step 6: The phone's back button goes home too --//
    BackHandler { onBack() }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {
        TextButton(onClick = onBack) {
            Text("< Back")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "All Board Games",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        for (game in boardGames) {
            Text(
                text = game,
                fontSize = 18.sp,
                modifier = Modifier.padding(vertical = 6.dp)
            )
        }
    }
}

//-- Class 9: Step 2: The previews need sample data now too --//
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    CampusAppTheme {
        HomeScreen(
            boardGames = listOf("Orleans", "Kingsburgh", "Ark Nova"),
            onAddGame = {},
            onSeeAll = {}
        )
    }
}

//-- Class 9: Step 7: Preview the list screen --//
@Preview(showBackground = true)
@Composable
fun ListScreenPreview() {
    CampusAppTheme {
        ListScreen(
            boardGames = listOf("Orleans", "Kingsburgh", "Ark Nova", "Terra Mystica"),
            onBack = {}
        )
    }
}