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