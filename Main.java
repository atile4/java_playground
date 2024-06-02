import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    static int ppt = 5;

    public static void main(String[] args) {
        File file = new File("file.txt");
        int numPlayers = 0;
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<Integer> ages = new ArrayList<Integer>();
        ArrayList<Integer> ratings = new ArrayList<Integer>();

        try {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    numPlayers++;
                    int n = line.indexOf(" ");
                    int n1 = line.indexOf(" ", n+1);
                    names.add(line.substring(0, n));
                    ages.add(Integer.parseInt(line.substring(n+1, n1)));
                    ratings.add(Integer.parseInt(line.substring(n1+1)));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int numteams = numPlayers / ppt;

        System.out.println(names);
        System.out.println(ages);
        System.out.println(ratings);

        String[][] teams = new String[numteams][ppt];

    }
}