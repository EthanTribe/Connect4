import java.util.ArrayList;

class Main {
  // Set-up a 7x6 board, add player 1 as human and player 2 as the computer, create the display, and finally run the game.
  public static void main(String[] args) {

    int width = 7;
    Board b = new Board(width, 6);
    
    Player p1 = new HumanPlayer('r');
    Player p2 = new ComputerPlayer('y', width);
    ArrayList<Player> players = new ArrayList<Player>();
    players.add(p1);
    players.add(p2);

    Display d = new CLDisplay();


    Game g = new Game(b, players, d);
    g.playGame();

  }
}