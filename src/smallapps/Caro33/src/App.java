public class App {
    
    static java.util.Scanner scanner = new java.util.Scanner(System.in);

    private static final char[][] board = new char[3][3];
    private static char currentPlayer = 'X';
    private static int scoreX = 0;
    private static int scoreO = 0;
    private static final StringBuilder screen = new StringBuilder();
    private static final String LINE = "-------------\n";
    private static int positionLeft = 9;
    private static boolean continueGame = true;

    public static class position {
        int row;
        int col;
    }

    public static void main(String[] args) throws Exception {
        while (continueGame) {
            playGame();
            System.out.print("Do you want to play again? (Y/N): ");
            continueGame = scanner.next().equalsIgnoreCase("Y");
        }
    }

    public static void playGame() {
        initializeBoard();
        printBoard();
        while (true) {
            System.err.println("Your turn!");
            System.out.print("Enter row and column: ");
            playerMove();
            printBoard();
            if (check()) {
                break;
            }
            changePlayer();
            botMove();
            printBoard();
            if (check()) {
                break;
            }
            changePlayer();
        }
    }
    
    public static void playerMove() {
        position pos = new position();
        pos.row = scanner.nextInt();
        pos.col = scanner.nextInt();
        if (pos.row < 0 || pos.row > 2 || pos.col < 0 || pos.col > 2 || board[pos.row][pos.col] != '-') {
            System.err.println("Invalid move! Try again.");
            playerMove();
        } else {
            board[pos.row][pos.col] = currentPlayer;
            positionLeft--;
        }
    }

    public static void botMove() {
        // Simple bot move: find the first empty spot
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    board[i][j] = currentPlayer;
                    positionLeft--;
                    return;
                }
            }
        }
    }

    public static boolean check() {
        if (checkWin()) {
            System.out.println("Player " + currentPlayer + " wins!");
            if (currentPlayer == 'X') {
                scoreX++;
            } else {
                scoreO++;
            }
            System.out.println("Score: X = " + scoreX + " - O = " + scoreO);
            positionLeft = 0;
            return true;
        } else if (checkDraw()) {
            System.out.println("Draw!");
            positionLeft = 0;
            return true;
        }
        return false;
    }

    public static boolean checkWin() {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }
        return false;
    }
    
    public static boolean checkDraw() {
        return positionLeft == 0;
    }
    
    public static void changePlayer() {
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
    }
    
    public static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';  
            }
        }
    }

    public static void printBoard() {
        screen.setLength(0);
        screen.append(LINE);
        for (int i = 0; i < 3; i++) {
            screen.append("| ");
            for (int j = 0; j < 3; j++) {
                screen.append(board[i][j]).append(" | ");
            }
            screen.append("\n").append(LINE);
        }
        System.out.println(screen.toString());
    }

}