##-Checkpoint 1-##

#App name
Boardgame planner
-An app that tracks played and want to play boardgames; adds and removes boardgames as needed.

#Screens
**Home** - Here the user can enter a boardgame name, see how many characters out of 30 are being used in the text field, see how many games are on the list and click a button to see the all games list, click a link to an app about page. The home page also has a list of expansions that are waiting to be played, and a last updated date.

**List** - On this page the user can view the current list (scrollable) with a running count, remove individual games, remove all games, and go back to the home screen. If the list becomes empty, a message is displayed instructing the user to add one on the home screen. A link back to the home screen also is displayed.

**About** - This a short description of the app and the authors name, with a back button to the home screen.

## Input rules
| Input -> Result and/or red error message that clears when condition is fixed

| empty text field for game name -> Add game button greyed out
| game name too short, < 3 characters -> Error msg "Too short, 3 characters minimum"
| too long, 30+ characters -> no message, but MAX_NAME_LENGTH stops tracking further input after 30 chars
| double spaces -> error msg, "No double spaces"
| attempting to add duplicate boardgame (case sensitive) -> error msg, " "Orleans" is already on the list"
| on all board games page, if empty -> informational msg, "No games yet. Add one on the home screen please" with link back to home screen

# Known limitations
Besides the identified problem lab 9 with keeping new items when the screen is rotated, the app itself needs to expand more and give the user more organizational
controls. Adding a sorting function by alphabet would be helpful, and adding a date stamp when a game is added and being able to sort that way would also be useful to keep track of a growing list of games. The ability to save added games so they stay when the app is closed would also go a long way to making the app more user friendly. The same treatment is needed for the want to play list of expansions currently on the home screen.

# successful clone and run before submitting

# (git ls-files).Count = 70