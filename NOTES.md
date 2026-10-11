1.) First built took about 3 minutes. Subsequent builds ran anywhere from 15 seconds to a minute.

2.) The backgrounds on the phone changed on their own.

3.) I'm still fully figuring out the right side of Android studio, where the device manager, gradle, etc. stay. Screen mirroring from my phone in this area has been inconsistent.

Week 5, Friday. Change one Modifier on your Column — the padding number, or swap .fillMaxWidth() for
.fillMaxSize(). Write down what you changed and what happened to the screen. One or two sentences.

I upped the padding to 32, and it didn't look too bad but there was a lot more noticable white space around the border of the screen. I also swapped in fillMaxHeight and the penguins took over the whole screen.

Week 6, Wednesday

1. I can't properly copy and paste, and have tried a good while to troubleshoot and fix. I still tried re-breaking the counter and looked in logcat, but couldn't see any changes for the counter. For the lab, I did see that logcat was tracking the out of bounds index error for removing boardgames, so logcat seems to track some things for me.
2. The counter is doing its job far as it knows, nothing has told the screen state to ask the counter for an update, and refresh the ui button with the count.
3. Remember remembers the count for when the screen state/ui drastically changes, and the counter button goes "off screen". When the screen is redrawn Remember will keep the count button up to date. Without it the count on the ui is lost and while the counter is still counting up, the button will start from zero, giving a false output.

Lab 8, task 1 -- It would get the min chars error message instead of enter a game name. I put it above and tried it and got the min char error message, since the add game is greyed out by the isNotBlank further down when the field is empty. So something has to go there, and one char is less than the three required so it gets the min char error.

Lab 8, task 2 -- My rule: No double spaces could be useful to save space for the 30 char limit.

Table 1:
1.) Typed 30 + chars | app cut string at 30 | correct
2.) Typed same name | app added | incorrect -> I didn't have fun validateNewGameName at top under Main. Moved to correct spot and works
3.) Typed 30+ chars | app counted but allowed 30 + chars to be added |incorrect -> outlinedTextField was after add button. Moved to correct spot so it gets input correctly.
4.) Typed double spaces between name in new game entry field | app did not add game and displayed error msg | correct
5.) Used clear all button | app cleared all | correct
6.) Add Boardgame button | app greys out and is unusable when add game field is blank | correct
7.) Used remove last game from list button | app remeved last game on list | correct
8.) Cleared list, added a game, then tried to add same game | app didn't add and displayed error msg | correct



Week 7, Wed.

1.) After rotating was still on the All Board Games screen. 2.) The two new board games were not on the list. 3.) It's a similar problem that we had with lists and screen states being redrawn. Saveable would seem to be a good way preserve the added game to the list on a redraw.





\##-Checkpoint 1-##



\#App name

Boardgame planner

\-An app that tracks played and want to play boardgames; adds and removes boardgames as needed.



\#Screens

\*\*Home\*\* - Here the user can enter a boardgame name, see how many characters out of 30 are being used in the text field, see how many games are on the list and click a button to see the all games list, click a link to an app about page. The home page also has a list of expansions that are waiting to be played, and a last updated date.



\*\*List\*\* - On this page the user can view the current list (scrollable) with a running count, remove individual games, remove all games, and go back to the home screen. If the list becomes empty, a message is displayed instructing the user to add one on the home screen. A link back to the home screen also is displayed.



\*\*About\*\* - This a short description of the app and the authors name, with a back button to the home screen.



\## Input rules

| Input -> Result and/or red error message that clears when condition is fixed



| empty text field for game name -> Add game button greyed out

| game name too short, < 3 characters -> Error msg "Too short, 3 characters minimum"

| too long, 30+ characters -> no message, but MAX\_NAME\_LENGTH stops tracking further input after 30 chars

| double spaces -> error msg, "No double spaces"

| attempting to add duplicate boardgame (case sensitive) -> error msg, " "Orleans" is already on the list"

| on all board games page, if empty -> informational msg, "No games yet. Add one on the home screen please" with link back to home screen



\# Known limitations

Besides the identified problem lab 9 with keeping new items when the screen is rotated, the app itself needs to expand more and give the user more organizational

controls. Adding a sorting function by alphabet would be helpful, and adding a date stamp when a game is added and being able to sort that way would also be useful to keep track of a growing list of games. The ability to save added games so they stay when the app is closed would also go a long way to making the app more user friendly. The same treatment is needed for the want to play list of expansions currently on the home screen. 



\# successful clone and run before submitting





