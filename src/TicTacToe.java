import java.util.*;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        // since at first the board is gonna be empty.
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }
        char player = 'X';
        boolean gameOver = false;
        Scanner sc = new Scanner(System.in);

        while (!gameOver) {
            printBoard(board);
            System.out.println("Player " + player + " enter: ");
            int row = sc.nextInt();
            int col = sc.nextInt();
            // this is for the coordinates of the board
            if (board[row][col] == ' ') {
                // if that spot is empty then it will be filled with the player's symbol
                board[row][col] = player;
                gameOver = haveWon(board, player);
                if (gameOver) {
                    System.out.println("Player " + player + " has won!");
                } else {
                    // if(player == 'X'){
                    // player = 'O';
                    // }else{
                    // player = 'X';
                    // }
                    player = (player == 'X') ? 'O' : 'X';
                }

            } else {
                System.out.println("Invalid move");
            }
        }
        printBoard(board);
    }

    public static boolean haveWon(char[][] board, char player) {
        // we have to check the rows, columns and diagonals
        // for row
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }
        // for columns
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }
        // for diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    public static void printBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }
}