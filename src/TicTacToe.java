import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TicTacToe {
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';
    private static final char EMPTY_CELL = '_';
    private static final Set<String> finalStates = new HashSet<>();

    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (char[] row : board) Arrays.fill(row, EMPTY_CELL);

        // Play all possible games
        playGames(board, PLAYER_X);

        // Print number of unique completed states
        System.out.println("Number of unique completed states: " + finalStates.size());
    }

    private static void playGames(char[][] board, char player) {
        // If current board is already a win or tie, store and stop
        if (isGameOver(board)) {
            finalStates.add(boardToString(board));
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == EMPTY_CELL) {
                    board[i][j] = player;
                    playGames(board, (player == PLAYER_X) ? PLAYER_O : PLAYER_X);
                    board[i][j] = EMPTY_CELL; // backtrack
                }
            }
        }
    }

    private static boolean isGameOver(char[][] board) {
        return hasWinner(board, PLAYER_X) || hasWinner(board, PLAYER_O) || isFull(board);
    }

    // Check winner
    private static boolean hasWinner(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                    (board[0][i] == player && board[1][i] == player && board[2][i] == player)
            ) {
                return true;
            }
        }
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    private static boolean isFull(char[][] board) {
        for (char[] row : board)
            for (char c : row)
                if (c == EMPTY_CELL) {
                    return false;
                }
        return true;
    }

    // Convert board to string for storing in Set
    private static String boardToString(char[][] board) {
        StringBuilder sb = new StringBuilder();
        for (char[] row : board) {
            for (char c : row) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // Convert string back to board
    private static char[][] stringToBoard(String s) {
        char[][] board = new char[3][3];
        for (int i = 0; i < 9; i++) {
            board[i / 3][i % 3] = s.charAt(i);
        }
        return board;
    }

    private static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char c : row) System.out.print(c + " ");
            System.out.println();
        }
        System.out.println();
    }
}
