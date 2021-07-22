import java.util.Random;

// This Player randomly places.
public class ComputerPlayer extends Player {

  private Random r;
  private int width;

  public ComputerPlayer(char counter, int width) {
    super(counter);
    r = new Random();
    this.width = width;
  }

  public int getMove() {
    return r.nextInt(width);
  }

  public boolean isAI() {
    return true;
  }

}