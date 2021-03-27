import java.util.Scanner;
class Main {
  //function will take in a dimension of the board
  public static char[][] board (int numRow, int numCol) {
    char[][] arr = new char[numRow][numCol];
    for (int row = 0; row < arr.length; row++) {
      for (int col = 0; col < arr[row].length; col++) {
        arr[row][col] = '-';
      }
    }
    return(arr);
  }
  //this function takes 2d array and prints it
  public static void display(char[][] arr) {
    String num = "";
    for (int i = 0; i < arr[0].length; i++) {
      num = num + " " + i;
    }
    System.out.println(" " + num);
    for (int row = 0; row < arr.length; row++) {
      String str = Integer.toString(row);
      for (int col = 0; col < arr[row].length; col++) {
        str = str + " " + arr[row][col];
      }
      System.out.println(str);
    }
  } 
  //this function will change the board with Y or R according to the user's input
  public static char[][] updateBoard(char[][] board, int col, char charToAdd) {
    int i = 0;
    while (i < board.length) {
      if (board[i][col] != '-') {
        break;
      }
      i++;
    }
    board[i - 1][col] = charToAdd;
    return(board);
  } 
  //this function checks if the move is valid or not (homework)
  public static boolean isValidMove(board, col) {

  }
  //function will take in the board and determines winning scenarios
  /*public static boolean Winner(char[][] board) {
          int seenAR = 0;
          int seenAY = 0;
    // this will go through each columns
    for (int i = 0; i < board.length; i++) {
         for (int j = 0; j < board.length; j++) {
           if (board[i][j] = R) {
             seenAR++;
           } else if (board[i][j] = Y) {
             seenAY++;
           }
         }
         if (seenAR == board.length || seenAY == board.length) {
           return(true);
         }
    }
        //will go through the diagonals
    for(int i = 0; i < board.length; i++) {
      if (board[i][board])
    }
  }*/
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter Board Size");
      int numRow = sc.nextInt();
      int numCol = sc.nextInt();
      char[][] board = board(numRow, numCol);
      display(board);

      int turn = 0;
      char player = 'R';
      while(true) {
        if (turn % 2 == 0) {
            player = 'R';
        } else {
          player = 'Y';
        }
        System.out.println("It's " + player + "'s turn");

        int col = sc.nextInt();
        board = updateBoard(board, col, player);
        display(board);
        turn++;
      }

  }
}
    
 









 



































