import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// This Player uses command line input to make moves.
public class HumanPlayer extends Player {

  private BufferedReader br;

  public HumanPlayer(char counter) {
    super(counter);
    br = new BufferedReader(new InputStreamReader(System.in));
  }

  public int getMove() {
    try {
      return Integer.parseInt(br.readLine()) - 1;
    }
    catch(Exception e) {
      return -1;
    }
  }

  public boolean isAI() {
    return false;
  }

}