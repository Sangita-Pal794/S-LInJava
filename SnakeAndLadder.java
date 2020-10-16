import java.util.Random;

class SnakeAndLadder {

 // Declaring Variables
  private static int player = 0;
  private static int position = 0;
  public static Random r1 = new Random();
  public static void main(String[] args) {

    roll();
    option();
    System.out.println(position);

 }
// Method for Options
  public static void option() {
    int choice = r1.nextInt(2);

    switch (choice) {
      case 0:
        // Ladder
        System.out.println("Ladder");
        int rollLadder = roll();
        position += rollLadder;

      case 1:
        // Snake
        System.out.println("Snake");
        int rollSnake = roll();
        position -= rollSnake;

      default:
        // No Play
        System.out.println("No Play");
    }
  }

  // Method for Dice Roll
  public static int roll() {
    int diceRoll = r1.nextInt(6) + 1;
    return diceRoll;
  }

}
