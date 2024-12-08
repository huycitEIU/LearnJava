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

    static boolean isDraw(int count) {
        return count == 9;
    }
}