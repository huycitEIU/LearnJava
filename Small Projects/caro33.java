
/*
 * This program is a simple Tic-Tac-Toe game.
 * The game is played on a 3x3 grid.
 * The game is played by two players who take turns.
 * The first player is X and the second player is O.
 * The players take turns to place their mark on the grid.
 * The player who succeeds in placing three of their marks in a horizontal, vertical, or diagonal row wins the game.
 * The game ends in a draw if all the cells are filled and no player has won.
 * The players can play the game as many times as they want.
 * Java version: 22.0.1 
 */
import java.util.Scanner;

public class caro33 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            play();
            System.out.println("Do you want to play again? (Y/N)");
            if (scanner.nextLine().equals("N")) {
                break;
            }
        }
    }

    /**
     * Play the game.
     */
    static void play() {
        char[][] board = new char[3][3];
        int count = 0;
        while (true) {
            printBoard(board);
            makeMove(board, 'X');
            count++;
            if (isWin(board, 'X')) {
                printBoard(board);
                System.out.println("X wins!");
                break;
            } else if (isDraw(count)) {
                printBoard(board);
                System.out.println("It's a draw!");
                break;
            }
            printBoard(board);
            makeMove(board, 'O');
            count++;
            if (isWin(board, 'O')) {
                printBoard(board);
                System.out.println("O wins!");
                break;
            }
        }
    }

    /**
     * Print the game board.
     * The board is a 3x3 grid.
     * The cells are empty initially.
     * -------------
     * | | | |
     * -------------
     * | | | |
     * -------------
     * | | | |
     * -------------
     * 
     * @param board the game board
     */
    static void printBoard(char[][] board) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] == 0 ? "  | " : board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    /**
     * Make a move on the board.
     * 
     * @param board  the game board
     * @param player the player (X or O)
     * @return true if the move is valid, false otherwise
     */
    static void makeMove(char[][] board, char player) {
        while (true) {
            System.out.print("Enter your move (row[1-3] column[1-3]): ");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == 0) {
                board[row][col] = player;
                break;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    /**
     * Check if the player has won the game.
     * 
     * @param board  the game board
     * @param player the player (X or O)
     * @return true if the player has won the game, false otherwise
     */
    static boolean isWin(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player)
                    || (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player)
                || (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    /**
     * Check if the game is a draw.
     * 
     * @param count the number of moves
     * @return true if the game is a draw, false otherwise
     */
    static boolean isDraw(int count) {
        return count == 9;
    }
}