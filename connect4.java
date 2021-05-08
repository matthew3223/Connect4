import java.util.Scanner;
import java.util.InputMismatchException;
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
  public static boolean isValidMove(char[][] board, int col) {
    if (col >= board[0].length || col <= -1) {
        return(false);
    } 
    if (board[0][col] != '-') {
      return(false);
    } else {
      return(true);
    }
  }
  //function will take in the board and determines winning scenarios
  public static boolean Winner(char[][] board, char player, int game) {
    //checks the row
    for (int i = 0; i < board.length; i++) {
         int seenColour = 0;
         char lastChar = ' ';
         for (int j = 0; j < board[i].length; j++) {
           if (board[i][j] == '-') {
             seenColour = 1;
             lastChar = board[i][j];  
           } else {
             if (board[i][j] == lastChar) {
                  seenColour++;
                  if (seenColour == game) {
                    return(true);
                  }
                  lastChar = board[i][j];
             } else {
                  seenColour = 1;
                  lastChar = board[i][j];
             }
           }
         }
    }
    //checks the column
    for (int j = 0; j < board[0].length; j++) {
      int seenColour = 0;
      char lastChar = ' ';
      for (int i = 0; i < board.length; i++) {
        if (board[i][j] == '-') {
          seenColour = 1;
          lastChar = board[i][j];
        } else {
          if (board[i][j] == lastChar) {
            seenColour++;
            if (seenColour == game) {
              return(true);
            }
            lastChar = board[i][j];
          } else {
            seenColour = 1;
            lastChar = board[i][j];
          }
        }
      }
    }
        //will go through the diagonals (positive slope)
    int i = board.length - 1;
    int k = board[0].length - 1;
    while (i >= 0) {
      int j = i;  //j is handling the 1st coordinate
      int l = k;  //i is handling the 2nd coordinate
      int seenColour = 0;
      char lastChar = ' ';
      while (l < board[0].length && j >= 0) {
          if (board[j][l] == '-') {
             seenColour = 1;
             lastChar = board[j][l];  
           } else {
             if (board[j][l] == lastChar) {
                  seenColour++;
                  if (seenColour == game) {
                    return(true);
                  }
                  lastChar = board[j][l];
             } else {
                  seenColour = 1;
                  lastChar = board[j][l];
             }
           }
           j--;
           l++;
      }
      k--;
      if (k < 0) {
        i--;
        k = 0;
      }
    }
   //will go through the diagonals (negative slope)
    int m = board.length - 1;
    int n  = 0;
    while (m >= 0) {
      int j = m;  //j is handling the 1st coordinate
      int l = n;  //m is handling the 2nd coordinate
      int seenColour = 0;
      char lastChar = ' ';
      while (j >= 0 && l >= 0) {
          if (board[j][l] == '-') {
             seenColour = 1;
             lastChar = board[j][l];  
           } else {
             if (board[j][l] == lastChar) {
                  seenColour++;
                  if (seenColour == game) {
                    return(true);
                  }
                  lastChar = board[j][l];
             } else {
                  seenColour = 1;
                  lastChar = board[j][l];
             }
           }
           j--;
           l--;
      }
      n++;
      if (n >= board[0].length - 1) {
        n = board[0].length - 1;
        m--;
      }
    }
    return(false);
  }
  //this function checks if the board is full or not by knowing if anyplayer has valid moves
  public static boolean moreValidMove(char[][] board, char player) {
    int seenChar = 0;
    for (int i = 0; i < board[0].length; i++) {
      if (board[0][i] != '-') {
        seenChar++;
      } 
    } 
    if (seenChar == board[0].length) {
        return(false);  
    } else {
        return(true);
    }
  }
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter Your Preference: Connect_");
      int game = 0;
      boolean err = false;
      do {
        err = false;
        try {
          game = sc.nextInt();
        } catch (InputMismatchException e) {
          System.out.println("Please Enter a Number");
          err = true;
          sc.nextLine();
        }
      } while(err);
      System.out.println("Enter Board Size");
      int numRow = 0;
      int numCol = 0;
      boolean er = false;
      do {
        er = false;
        try {
          numRow = sc.nextInt();
          numCol = sc.nextInt();
        } catch (InputMismatchException e) {
          System.out.println("Please Enter a Number");
          er = true;
          sc.nextLine();
        }
      } while(er);
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
        int col = 0;
        boolean error = false;
        do {
           error = false;
           try {
             col = sc.nextInt();
           } catch (InputMismatchException e) {
              System.out.println("Please Enter a Number");
              error = true;
              sc.nextLine(); 
           }
        } while (error);
        while(!isValidMove(board, col)) {
          System.out.println("Invalid Move");
          col = sc.nextInt();
        }
        board = updateBoard(board, col, player);
        display(board);
        if (Winner(board, player, game)) {
            System.out.println(player + " wins!");
            break;   
        }
        if (moreValidMove(board, player) == false) {
            System.out.println("It's a tie");
            break;
        }
        turn++;  
        }
      }
  }

    
 





















 
