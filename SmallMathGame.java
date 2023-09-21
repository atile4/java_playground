import java.util.*;

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



