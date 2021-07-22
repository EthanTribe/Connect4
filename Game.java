import java.util.ArrayList;

public class Game {

	private Board board;
	private ArrayList<Player> players;
  private Display display;
	
  // To run the game we need a board, a list of players, and a display to show the board on.
	public Game(Board board, ArrayList<Player> players, Display display){
    this.board = board;
    this.players = players;
    this.display = display;
	}
	
  // This method is used to actually play the game.
  // 1. It first displays the welcome message. Then shows the empty board.
  // 2. Next it asks for the first player's move, then applies the move the board, repeating these if a move is invalid.
  // 3. The board is then shown again and checked for 4-in-a-row (if there is display a win message). The board is finally check to see if it is full, if it is then display a draw message.
  // 4. Steps 2 and 3 are repeated until the game is over (win or draw).
	public void playGame(){
    String welcome = "";
		welcome += "Welcome to Connect 4\n";
		welcome += "There are 2 players red and yellow\n";
		welcome += "Player 1 is Red, Player 2 is Yellow\n";
		welcome += "To play the game type in the number of the column you want to drop your counter in\n";
		welcome += "A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally";
    display.show(welcome);
    display.show(board.toString());

    boolean over = false;
    boolean placeWorked = true;
    int move;
    char counter;

    while (!over) {
      for (Player p : players) {    
        do{
          if (!p.isAI()) {
            display.show("Player " + (players.indexOf(p) + 1) + ": ");
          }
          move = p.getMove();
          counter = p.getCounter();        
          placeWorked = board.place(move, counter);
          if (!placeWorked && !p.isAI()) {
            display.show("Invalid move, try again.");
          }
        }
        while (!placeWorked);

        display.show(board.toString());
        if (board.check4InARow(move, counter)) {
          display.show("Player " + (players.indexOf(p) + 1) + " has won!!!");
          over = true;
          break;
        }

        if (board.checkFull()) {
          display.show("It is a draw!!!");
          over = true;
          break;
        }
      }      
    }    
	}

}