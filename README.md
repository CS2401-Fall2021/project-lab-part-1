# Project Lab: Part 1 DUE OCTOBER 19 at NOON (Midday, lunchtime, mediodía, 12:00) 

### si te entregas por la tarde... es tarde
### If you submit in the afternoon, it's considered late

This lab will be the first part in a series of labs which will result in a text-based adventure game structure that you can use to auto-generate games, test them, and ensure that they are solveable. 

In this portion of the lab, you will be creating the objects and methods to represent the functioning portions of the game.

You are in a long hallway with lots of rooms some of which might be locked. The rooms can contain keys that can be used to unlock other doors, and treasure. The goal of the game is to find the treasure. 

## GRADING
In order to get a grade for this lab, you will need to schedule time with Marissa Stephens, Lidice, Susana, or Dustyn the week after the lab is due to run through your code, and your game. You must schedule a time slot by OCTOBER 19 at NOON. To Schedule, choose an appointment slot on this spreadsheet:


[LINK TO SCHEDULE](https://minersutep-my.sharepoint.com/:x:/g/personal/mastephens_utep_edu/EUSe5sQnE05ImfW3DZANmlMBZsiFuT8dtgd5Wo0UAL1PIg?e=oeezWj)

### 1) A GAME starts at an initial ROOM, and an empty array of keys that have been found.

### 2) Each  ROOM in game has the following information
* Welcome Message
* Whether or not it contains the treasure 
* Some number of KEYS
* If this ROOM is locked or not
* The ID of the key that unlocks this ROOM

### 3) Each KEY in the game has a specific integer ID

### HALLWAY STEPS

Every time you enter the hallway you:
1. Check which of the ROOMS are available: that is they are unlocked or unlockable by the KEYS
2. Print out the index of the Rooms that you can enter, and prompt the user to input a room they want to enter
3. Parse the user's input into an integer, if it is an available room index, Perform the RoomSteps for that room.
4. Otherwise, re-prompt the user


### Room Steps
1. Print out the welcome message
2. If the treasue is at the point, print a *congratulations message* and end the game
3. If there are KEYS in this room, print a message that a key has been found, and add it to the keys found array. The key's integer is the index in the array.
4. Return the the Hallway


## Part 1: The KEY Class (10 pts)
This will create a fairly simple object but is good practice to make sure you understand how to create a class and use it to make an object.
1. Create a Key.java file
2. It should contain integer ID that is assigned in the constructor method

## Part 2: The ROOM Class (20 pts)
This creates an object that represents the information about the room. 
1. Create Room.java file
2. It should take in the following values in the constructor
   * A welcome message
   * If if contains the treasure
   * It's initial state of being locked
   * The ID of the key that opens it
   * What KEYs it contains
3. Have a method unlock(int key), which sets the value representing the locked state to true if the input key matches the key that unlocks the room. If successful, it should return true. Otherwise, it returns false and does not change the locked state.


## Part 3: The GAME Class (70 pts total)
Game.java should have the following methods:
### 3.1 Room[] createSimpleGame(int numKey) (20 pts)
Returns an array of ROOMs, with at most numKeys keys. Be creative, but it must return at least 5 rooms.

### 3.2 printHallway(Room[] rooms, boolean[] keysFound) (20 pts)
Performs the Hallway Steps listed above. You might want to read the Helpful tool: Scanner.java section before implementing.

### 3.3 printRoom(Room room, boolean[] keysFound) (10 pts)
Performs Room steps 1-4 listed above. 

### 3.4 main()
* defines a numKey greater than 3
* Calls createSimpleGame with numKey
* creates a boolean[] of keysFound the length of numKey
* Begins the game by calling printHallway. 


## Helpful tool: Scanner.java 
To read in a user's input, you need to use the Scanner.java class. 

at the top of the file, above the class defition:
```
import java.util.Scanner;
```

to use the scanner
```
 Scanner scanner = new Scanner(System.in);
 String line = scanner.nextLine();
 ```
 to try to parse the string to an integer
 
 ```
 Integer.parseInt(myString);
 ```
 
 Note that this will throw a NumberFormatException if the string does not contain a parsable integer. So we need to wrap it in a try...catch statement
 
 So we need to wrap it in a 
 
 ```
 try{ 
     Integer.parseInt(line);
 } catch(NumberFormatException e){
     // do something else. We can't interpret the int
 }
 ```
## Grading Reminder
In order to get a grade for this lab, you will need to schedule an appointment with either Marissa Stephens (Lab instrucor), Lidice(TA) or Susana/Dusytn(IA) to review your code and run through your game. 

## Take it Further
1. Add some cool ascii art to each room's message (You can reuse what you had for Lab 2)
2. Implement a new feature of your game. Maybe a secret tunnel that leads to a different room? or monsters in the room that automatically end the game?
3. Break out the portions of PrintHallway() into smaller methods that encompass smaller tasks
4. Add some customization to your game. Are you an explorer in a haunted house? A starship traveling through wormholes to different galaxies? Be creative!

