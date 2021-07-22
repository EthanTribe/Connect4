public abstract class Player {

  private char counter;

  // Each player has a counter.
  public Player(char counter) {
    this.counter = counter;
  }

  public char getCounter() {
    return counter;
  }

  // Returns the move the player wants to make.
  abstract int getMove();

  // Returns whether the player is automated or not.
  abstract boolean isAI();
  
}