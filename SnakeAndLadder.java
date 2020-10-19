import java.util.LinkedHashMap;
import java.util.Random;

class SnakeAndLadder {

 // Declaring Variables
  private static int player = 2;
  private static int initialPos = 0;
  private static int finalPos = 100;
  private static int currentPos = initialPos;
  private String winner;
  private int  rollCount = 0;

  public static Random r1 = new Random();
  private static LinkedHashMap<String, Integer> playerHashMap = new LinkedHashMap<>();


  public static void main(String[] args) {

    SnakeAndLadder newGame = new SnakeAndLadder();
    System.out.println("\n\nWelcome to Snake And Ladders!\nNumber of Players: "+newGame.player+"\n\nStarting Game ... \n\n");

    newGame.initializingPositions();
   newGame.gameBoard();
 }

 public static void gameBoard() {

 playing : while (true){

		option();

		for (int k=1; k<=player; k++) {
        	if (playerHashMap.get("Player "+k) == finalPos) {
          		winner = "Player "+k;
          		break playing;
       }
      }
}
    results();
      }


// Method to Initialize the Player Positions
  public void initializingPositions() {

    for (int i=1; i<=player; i++) {
      playerHashMap.put("Player "+i, initialPos);
      System.out.println("Current Position of Player "+i+": "+playerHashMap.get("Player "+i));
    }

  }

// Method for Options
  public static void option() {

	for ( int j = 1; j <= player; j++) {

      int rollValue = roll();
      int choice = r1.nextInt(3);
      int currentPos = playerHashMap.get("Player "+j);
      System.out.println("\nPlayer "+j+" Rolled: "+rollValue);

    switch (choice) {
      case 0:
        // Ladder
	if ((currentPos+rollValue) > finalPos) {
            System.out.println("Cannot move forward, staying at the same position.");
            break;
          } else {
            currentPos += rollValue;
            System.out.println("Ladder! Moving forward by "+ rollValue +".");

            int bonusRoll = roll();
            System.out.println("Ladder Bonus! You get another chance to roll.\nBonus Roll Value: "+ bonusRoll);

            // Resetting Position to previous position if it goes beyond final position
            if ((currentPos+bonusRoll) >finalPos) {
              System.out.println("Cannot move forward, staying at the same position.");
            } else {
              currentPos += bonusRoll;
              System.out.println("Moving forward by "+ bonusRoll +".");
            }
            playerHashMap.replace("Player "+j, currentPos);
            break;
          }

        case 1:
          // Snake
          currentPos -= rollValue;

          // Resetting Position to inital position if it goes below that
          if (currentPos < initialPos ) {
            currentPos = initialPos;
            System.out.println("Snake! Resetting position to initial value.");
          } else {
            System.out.println("Snake! Moving backward by " + rollValue +".");
          }
          playerHashMap.replace("Player "+j, currentPos);
          break;

        case 2:
          // No Play
          System.out.println("No Play!");
          break;
      }
      System.out.println("Current Position of Player "+j+": "+playerHashMap.get("Player "+j));
    }
  }

  // Method for Dice Roll
  public static int roll() {
    int diceRoll = r1.nextInt(6) + 1;
    return diceRoll;
  }





 // Method for Displaying the Results
  public void results() {
    System.out.println("\n\n___________________________________________________________");
    System.out.println("\n\nGame Over!\n\n"+winner+" Won!"+" Congratulations!\nTotal Number of Times the Dice was Rolled: " + rollCount);
    System.out.println("\n\nPlayer Positions Board: ");
    for (String key: playerHashMap.keySet()) {
      System.out.println(key+" = "+playerHashMap.get(key));
    }
    System.out.println("\n\n___________________________________________________________");
  }
}
