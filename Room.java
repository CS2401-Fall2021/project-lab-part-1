public class Room {

  //Attributes
  private String welcomeMessage;
  private boolean isLocked;
  public int roomID;
  private boolean hasTreasure;
  private Key[] keys;

  //Default Constructor
  public Room() {}

  //Other Constructor
  public Room(String welcomeMessageIn, boolean isLockedIn, int roomIDIn, boolean hasTreasureIn, Key[] keysIn){
    this.welcomeMessage = welcomeMessageIn;
    this.isLocked = isLockedIn;
    this.roomID = roomIDIn;
    this.hasTreasure = hasTreasureIn;
    this.keys = keysIn;
  }


  //Methods
  public boolean unlock(int key){
    if(key == this.roomID){
      this.isLocked = false;
      return true;
    }
    return false;
  }

  public boolean getIsLocked(){
    return this.isLocked;
  }

  public int getRoomID(){
    return this.roomID;
  }

  public String getWelcomeMsg(){
    return this.welcomeMessage;
  }

  public boolean getHasTreasure(){
    return this.hasTreasure;
  }

  public Key[] getKeys(){
    return this.keys;
  }

  public void setHasTreasure(boolean treasure){
    this.hasTreasure = treasure;
  }

}
