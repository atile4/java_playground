import java.util.*;

/*
Generates a 3x3 grid of numbers from 1-9, and a random number from 30-100. 
The goal of the game is to mathematically combine a sequence of 3 of the numbers (in columns, 
rows, or diagonal) to reach the generated random number.
Ex. 1 2 3
    4 5 6
    7 8 9
    Random Number: 51
    
    9 * 6 - 3 = 51

DISCLAIMER
Code does NOT contain an answer key. 3x3 grid must contain 1 digit numbers. Program does not accommodate for
changing the range of the Random Number.
*/

public class SmallMathGame {

    static void printGrid(ArrayList<Integer> intArray) {
        int n = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(intArray.get(j+n) + " ");
            }
            System.out.print("\n");
            n = n + 3;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Collections.shuffle(nums);

        printGrid(nums);
        System.out.println("\nRandom Number: " + (int)(Math.random()*71 + 31));


    }
}



