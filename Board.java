import java.util.Arrays;
import java.lang.Math;

public class Board {

  private char[][] board;
  private int[] capacities;
  private int widthHeightMax;

  // Set-up the board as char matrix with the input dimensions. Set-up a list of the capacities for how full each column of the board is.
  public Board(int width, int height) {
    board = new char[width][height];
    capacities = new int[width];
    Arrays.fill(capacities, 0);
    widthHeightMax = Math.max(width, height);
  }

  // Place the counter at the top of the column and return if the move was valid or not.
  public boolean place(int x, char counter) {
    try {
      board[x][capacities[x]] = counter;
      capacities[x] += 1;
      return true;
    }
    catch (Exception e) {
      return false;
    }
  }

  // A method to convert a char to a String where the null char goes to "_". This is used in the check4InARow method.
  public String boardSpaceToString(char c) {
    if (c == '\0') {
      return "_";
    }
    else {
      return Character.toString(c);
    }
  }
  
  // Check the horizontal, vertical, and both diagonal rows intersecting the last move for 4 counters in a row.
  public boolean check4InARow(int x, char counter) {

    String column = "";
    for (char c : board[x]) {
      column += boardSpaceToString(c);
    }

    String row = "";
    for (int i = 0; i < board.length; i++) {
      row += boardSpaceToString(board[i][capacities[x] - 1]);   
    }

    String leadingDiagonal = ""; // top-left to bottom-right
    int coordSum = x + capacities[x] - 1;
    for (int i = 0; i <= coordSum; i++) {
      if (i < board.length && coordSum - i < board[0].length) {
        leadingDiagonal += boardSpaceToString(board[i][coordSum - i]);
      }
    }

    String otherDiagonal = ""; // bottom-left to top-right
    int coordDiff = Math.abs(x - capacities[x] + 1);
    for (int i = 0; i < widthHeightMax; i++) {
      if (x < capacities[x] - 1) {
        if (i < board.length && i + coordDiff < board[0].length) {
          otherDiagonal += boardSpaceToString(board[i][i + coordDiff]);      
        }        
      }
      else {
        if (i + coordDiff < board.length && i < board[0].length) {
          otherDiagonal += boardSpaceToString(board[i + coordDiff][i]);          
        }
      }
    }

    String[] rowsToCheck = new String[4];
    rowsToCheck[0] = row;
    rowsToCheck[1] = column;
    rowsToCheck[2] = leadingDiagonal;
    rowsToCheck[3] = otherDiagonal;

    // Make a String for the counter 4 times in a row
    String fourInARow = "";
    for (int i = 0; i < 4; i++) {
      fourInARow += Character.toString(counter);
    }

    // Check if fourInARow is in any of the rows
    for (String r : rowsToCheck) {
      if (r.indexOf(fourInARow) != -1) {
        return true;
      }
    }
    return false;

  }

  // A method to check if the board is completly filled up.
  public boolean checkFull() {
    for (int i = 0; i < board.length; i++) {
      if (board[i][board[0].length - 1] == '\0') {
        return false;
      }
    }
    return true;
  }

  @Override
  // Converts board to a string ready for display.
  public String toString() {
    String toReturn = "\n";
    for (int i = board[0].length - 1; i >= 0; i--) {
      for (int j = 0; j < board.length; j++) {
        if (board[j][i] == '\0') {
          toReturn += "| ";
        }
        else {
          toReturn += "|" + board[j][i];
        }        
      }
      toReturn += "|\n";
    }
    for (int i = 0; i < board.length; i++) {
      toReturn += "--";
    }
    toReturn += "-\n";
    for (int i = 0; i < board.length; i++) {
      toReturn += " " + (i + 1);
    }
    return toReturn;
  }

}