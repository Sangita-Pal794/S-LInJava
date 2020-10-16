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
      } else if (currentPos == 100) {
        // Player reached 100!
        break;
      }

    }
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
