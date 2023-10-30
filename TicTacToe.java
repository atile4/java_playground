import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {

    static void printBoard(ArrayList<String> k) {
        int n = 0;
        System.out.println("\n");
        for (int i = 0; i < 5; i++) {
            if (i%2 == 0) {
                n = i / 2;
                System.out.println("  " + k.get(i+n) + "  |  " + k.get(i+1+n) + "  |  " + k.get(i+2+n));
            }
            else {
                System.out.println("-----|-----|-----");
            }

        }
//        System.out.println("  %s  |  %s  |  %s\n" +
//                           "-----|-----|-----\n" +
//                           "  %s  |  %s  |  %s\n", k);
    }

    static int convertPos(String s) {
        return s.charAt(0);
    }


    static int getMove(String player) {
        Scanner scan = new Scanner(System.in);
        System.out.print(player + " - Enter a move on the grid: ");
        while (true) {
            String move_pos = scan.nextLine();
            int index = convertPos(move_pos) - 65;

            if (checkMove(move_pos)) {
                return index;
            }
            else {
                System.out.print("Invalid move. Please enter a valid move: ");
                continue;
            }
        }
    }



    static boolean checkMove(String pos) {
        if (pos.length() != 1) { return false;}

        int index = convertPos(pos) - 65;
        return (index >= 0) && (index <= 9);
    }

    static ArrayList placeMove(ArrayList<String> board, int pos, String player) {
        board.set(pos, player);
        return board;
    }

    static String checkWin(ArrayList<String> board) {
        char A = board.get(0).charAt(0);
        char B = board.get(1).charAt(0);
        char C = board.get(2).charAt(0);
        char D = board.get(3).charAt(0);
        char E = board.get(4).charAt(0);
        char F = board.get(5).charAt(0);
        char G = board.get(6).charAt(0);
        char H = board.get(7).charAt(0);
        char I = board.get(8).charAt(0);

        if ((A == 'X' && A == B && A == C) ||
            (D == 'X' && E == D && F == D) ||
            (G == 'X' && H == G && I == G) ||

            (A == 'X' && D == A && G == A) ||
            (B == 'X' && E == B && H == B) ||
            (C == 'X' && F == C && I == C) ||

            (A == 'X' && E == A && I == A) ||
            (C == 'X' && E == C && G == C)) {
            return "X";
        }
        else if ((A == 'O' && A == B && A == C) ||
                 (D == 'O' && E == D && F == D) ||
                 (G == 'O' && H == G && I == G) ||

                 (A == 'O' && D == A && G == A) ||
                 (B == 'O' && E == B && H == B) ||
                 (C == 'O' && F == C && I == C) ||

                 (A == 'O' && E == A && I == A) ||
                 (C == 'O' && E == C && G == C)) {
            return "O";
        }
        else {
            return "No winner yet";
        }


    }


    public static void main(String[] args) {
        ArrayList<String> grid = new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I"));
        // setup
        String playerX = "X";
        String playerO = "O";
        String currPlayer = playerX;
        String wincheck;
        boolean flag = true;
        printBoard(grid);

        while (flag) {
            placeMove(grid, getMove(currPlayer), currPlayer);

            if (currPlayer == playerX) { currPlayer = playerO; }
            else { currPlayer = playerX; }


            printBoard(grid);

            wincheck = checkWin(grid);

            if (wincheck.equals("X")) {
                System.out.println("Player X wins!");
                flag = false;
            }
            else if (wincheck.equals("O")) {
                System.out.println("Player O wins!");
                flag = false;
            }


        }



    }

}

//   A  |  B  |  C
// -----|-----|-----
//   D  |  E  |  F
// -----|-----|-----
//   G  |  H  |  I
