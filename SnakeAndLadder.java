import java.util.Random;

class SnakeAndLadder {

 // Declaring Variables
  private static int player = 1;
  private static int initialPosition = 0;
  private static int finalPosition = 100;
  private static int currentPos = initialPosition;
  public static Random r1 = new Random();
  public static void main(String[] args) {

   gameBoard();
 }

 public static void gameBoard() {

int  rollCount = 0;
  while (true) {

      option();
      rollCount++;

      if (currentPos < 0 ) {
        currentPos = 0;
      } else if (currentPos == finalPosition) {
        // Player reached 100!
        break;
      }

    }
    	System.out.println("\nFinal Position 100 Reached!\nTotal Number of Times the Dice was Rolled: " + rollCount);

 }


// Method for Options
  public static void option() {
    int choice = r1.nextInt(3);

    switch (choice) {
      case 0:
        // Ladder
        int rollLadder = roll();
        currentPos += rollLadder;
        System.out.println("\nLadder!, moving forward by "+ rollLadder +"\nCurrent Psotion: "+ currentPos);
	// Resetting Position to previous position of goes beyond final position
        if (currentPos > finalPosition) {
          currentPos -= rollLadder;
          System.out.println("\nLadder! Cannot move forward, staying at the same position.\nCurrent Position: "+ currentPos);
        } else {
          System.out.println("\nLadder! Moving forward by "+ rollLadder +"\nCurrent Position: "+ currentPos);
        }
	break;

      case 1:
        // Snake
        int rollSnake = roll();
        currentPos -= rollSnake;
	System.out.println("\nSnake!, moving backward by "+ rollSnake +"\nCurrent Psotion: "+ currentPos);
      default:
        // No Play
	System.out.println("\nNo Play!\nCurrent Position: "+ currentPos);
    }
  }

  // Method for Dice Roll
  public static int roll() {
    int diceRoll = r1.nextInt(6) + 1;
    return diceRoll;
  }

}
