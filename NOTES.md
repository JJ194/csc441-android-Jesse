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

