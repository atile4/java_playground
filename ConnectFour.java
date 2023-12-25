import java.util.Scanner;

public class ConnectFour {
    static int LENGTH = 7;
    static int HEIGHT = 5;
    static Scanner SCAN = new Scanner(System.in);

    public static void main(String[] args) {
        char[][] board = new char[LENGTH][HEIGHT];

        resetBoard(board);
        printBoard(board);

        char playerX = 'X';
        char playerO = 'O';
        char currPlayer = playerX;


        int column;


        while (true) {
            column = getMove(board, currPlayer);
            setMove(board, currPlayer, column);

            printBoard(board);

            if (checkWin(board, currPlayer)) {
                System.out.println(currPlayer + " wins!");
                break;
            }

            if (currPlayer == playerX) { currPlayer = playerO; }
            else { currPlayer = playerX; }
        }
    }

    public static void resetBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = ' ';
            }
        }
    }
    public static void printBoard(char[][] a) {
//        outer: 7 arrays (ABCDEFG)
//        inner: 5 slots
        System.out.println("  A   B   C   D   E   F   G");
        for (int i = a[0].length-1; i >= 0; i--) {
            System.out.println("|---|---|---|---|---|---|---|");
            System.out.print("| " + a[0][i] + " | " + a[1][i] + " | " + a[2][i] +
                    " | " + a[3][i] + " | " + a[4][i] + " | " + a[5][i] +
                    " | " + a[6][i] + " |\n");
        }
        System.out.println("|---|---|---|---|---|---|---|");
    }

    public static int getMove(char[][] board, char player) {
        boolean flag = true;
        char column;
        String move;
        int pos = 0;

        System.out.print("Player " + player + ": Please enter the column letter to place your piece (A, B, C, D, E, F, G): ");
        while (flag) {
            move = SCAN.nextLine();
            if (move.length() == 1) {
                column = move.charAt(0);
                pos = (int) column - 65;

                if (pos >= 0 && pos <= 6) {
                    flag = false;
                    continue;
                }
            }
            System.out.print("Please enter a valid input (A, B, C, D, E, F, G): ");
        }

        return pos; //return statement to get intellij to shut up
    }

    public static void setMove(char[][] board, char player, int column) {
        for (int i = 0; i < board[column].length; i++) {
            if (board[column][i] == ' ') {
                board[column][i] = player;
                break;
            }
        }
    }

    public static boolean checkWin(char[][] board, char player) {
        for (int row = 0; row < board[0].length/2; row++) {
            for(int col = 0; col < board.length/2+1; col++) {
                if (board[col][row] == player) {
                    if (player == board[col+1][row] && player == board[col+2][row] &&
                            player == board[col+3][row]) {
                        return true;
                    }
                    else if (player == board[col][row+1] && player == board[col][row+2] &&
                            player == board[col][row+3]) {
                        return true;
                    }
                    else if (player == board[col+1][row+1] && player == board[col+2][row+2] &&
                            player == board[col+3][row+3]) {
                        return true;
                    }
                }
            }

            for (int col = board.length/2; col < board.length; col++) {
                if (player == board[col][row+1] && player == board[col][row+2] &&
                        player == board[col][row+3]) {
                    return true;
                }
                else if (player == board[col-1][row+1] && player == board[col-2][row+2] &&
                        player == board[col-3][row+3]) {
                    return true;
                }

            }


        }

        return false;
    }
}



