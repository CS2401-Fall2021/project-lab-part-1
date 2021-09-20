# Project Lab: Part 1

This lab will be the first part in a series of labs which will result in a text-based adventure game structure that you can use to auto-generate games, test them, and ensure that they are solveable. 

In this portion of the lab, you will be creating the objects and methods to represent the functioning portions of the game. 


A GAME starts at an initial POINT, and some number of KEYS

Each POINT in game has the following information
* Welcome Message
* Whether or not it contains the treasure 
* Some number of KEYS
* Some number of next POINTS
* The previous POINT that lead to this POINT. Note that this will not exisit for the initial starting POINT
* If this POINT is locked or not
* The ID of the key that unlocks this POINT

Each KEY in the game has a specific integer ID


Your GAME will need to do the following for each POINT:

1. Print out the welcome message
2. If the treasue is at the point, print a *congratulations message* and end the game
3. If there are KEYS in this room, print a message that a key has been found. 
4. Check which of the PASSAGEWAYS are available: that is they are unlocked or unlockable by the KEYS
5. Print a list of the available PASSAGEWAYS or the option to go *back* to the previous POINT (unless this does not exist, e.g. the starting POINT)
6. Read in user response via a scanner method
7. If the response can be interpreted, use that to determine which PASSAGEWAY is taken to your next POINT.
8. Otherwise, re-prompt the user 



Part 1: The KEY Class
This will create a fairly simple object but is good practice to make sure you understand how to create a class and use it to make an object.
1. Create a Key.java file
2. It should contain a unique, unchangeable integer ID that is assigned in the constructor method
3. There should be a *method* getKeyId() that returns the integer ID

Part 2: The POINT Class
To create this object, we need to know:
* If if contains the treasure
* It's initial state of being locked
* The ID of the key that opens it
* The previous POINT if it exisits
* What KEYs it contains
* What POINTs it leads to

Part 3: The GAME Class
Game.java should have the following methods
1. CreateSimpleGame(), which constructs a game with the following structure:
![image with 3 nodes](drawing.png)
2. PrintPoint(Point p), which performs steps 1-8 listed above.


