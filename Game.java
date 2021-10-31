import java.util.HashMap;
import java.util.Scanner;

public class Game {

  static HashMap<Integer,Integer> keysHash = new HashMap<Integer,Integer>();

  public static void main(String[] args) {
    //Variables and objects
    int numKeys = 7;
    boolean[] keysFound = new boolean[numKeys];
    //Initialize keysFound to be false
    for(boolean key : keysFound){
      key = false;
    }
    Room[] rooms = generateSimpleTreeGame(7,numKeys);
    printHallway(rooms,keysFound);

  }

  public static int scanNumericValue(int min, int max){
    //Variables
    Scanner sc = new Scanner(System.in);
    String input = "";
    int intInput;
    //Check that input scanned is a number, if not continue asking...
    while(true){
      try{
        System.out.print("-> ");
        input = sc.nextLine();
        intInput = Integer.parseInt(input);
        //Check that input is in range.
        if((min>0 && intInput<min) || (max>0 && intInput>max)){
          if(max>0){
            throw new Exception("Enter a value within range [" + min + "," + max + "].");
          }
          else{
            throw new Exception("Enter a value within range min: " + min +".");
          }
        }
        break;
      }catch (NumberFormatException nfe){
        System.out.println("Enter a valid a value.");
      } catch (Exception e) {
        System.out.println(e);
      }
    }
    return intInput;
  }

  public static Room[] generateSimpleTreeGame(int numRooms, int numKey) {

    Room[] rooms = new Room[7];
    String[] roomNames = new String[numRooms];
    Key[] singleKeys = new Key[numKey];

    //Create room names
    for(int i=0; i<roomNames.length; i++){
      roomNames[i] = "Room " + i;
    }
    //Create keys
    for(int i=0; i<singleKeys.length; i++){
      Key k = new Key(i);
      singleKeys[i] = k;
    }

    rooms[0] = new Room("Welcome to "+roomNames[0],false,6,false,new Key[]{singleKeys[0],singleKeys[1]});
    rooms[1] = new Room("Welcome to "+roomNames[1],true,5,false,new Key[]{singleKeys[2],singleKeys[3]});
    rooms[2] = new Room("Welcome to "+roomNames[2],true,4,false,new Key[]{singleKeys[4]});
    rooms[3] = new Room("Welcome to "+roomNames[3],true,3,false,new Key[]{singleKeys[5],new Key(-1)});
    rooms[4] = new Room("Welcome to "+roomNames[4],true,1,true,new Key[]{singleKeys[6]});
    rooms[5] = new Room("Welcome to "+roomNames[5],true,2,false,new Key[]{singleKeys[1]});
    rooms[6] = new Room("Welcome to "+roomNames[6],true,0,false,new Key[]{new Key(1000)});

    return rooms;
  }

  public static void printHallway(Room[] rooms, boolean[] keysFound){

    Scanner sc = new Scanner(System.in);
    boolean treasureFound = false;

    while(!treasureFound){
      System.out.println("\n>>>>>>>>>HALLWAY<<<<<<<<<");
      System.out.println("Hello! You're in the hallway...");
      //Unlock if possible and show the room status
      for(int i=0; i<rooms.length; i++){
        Room room = rooms[i];
        int id = room.getRoomID();
        if(!room.getIsLocked()){
          System.out.println("Room " + i + " | Unlocked");
        }
        else if(room.getIsLocked() && keysFound[id]){
          room.unlock(id);
          System.out.println("Room " + i + " | Unlocked (NEW)");
        }
        else{
          System.out.println("Room " + i + " | Locked");
        }
      }

      System.out.println("Select a room to find the treasure: ");
      int numR = scanNumericValue(0,rooms.length-1);

      if(!rooms[numR].getIsLocked()){
        treasureFound = printRoom(rooms[numR],keysFound);
      }
      else{
        System.out.println("Ups! Room is locked... choose another room.");
      }
    }
  }

  public static boolean printRoom(Room room, boolean[] keysFound){
    System.out.println("\n>>>>>>>>>ROOM<<<<<<<<<");
    //Print welcome message
    System.out.println(room.getWelcomeMsg());
    //Check for treasure
    if(room.getHasTreasure()){
      System.out.println("Congratulations! You found the treasure!");
      return true;
    }
    //Update keys
    for(Key key : room.getKeys()){
      int id = key.getId();
      keysHash.put(id,id);
      if(id>=0 && id< keysFound.length){
        keysFound[id] = true;
      }
    }
    System.out.println("Keys found:");
    System.out.println(keysHash.values());
    return false;
  }
}
