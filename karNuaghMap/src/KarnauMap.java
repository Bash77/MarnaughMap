

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.util.Scanner;

public class KarnauMap {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("KARNAUGH.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }
        scanner.close();

        ArrayList<String> mintermler = new ArrayList<>();
        ArrayList<String> maxtermler = new ArrayList<>();
        Karnaugh(mintermler, maxtermler);
        System.out.println("Minterms: " + " ∑ " + mintermler);
        System.out.println("Maxterms: " + " ∏ " + maxtermler);
    }
    public static void Karnaugh(ArrayList<String> mintermler , ArrayList<String> maxtermler){

        int[][] table = {
                //A B  C  D
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {0, 1, 0, 1, 0},
                {0, 1, 1, 0, 0},
                {0, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 0, 0, 1},
                {1, 1, 0, 1, 1},
                {1, 1, 1, 0, 1},
                {1, 1, 1, 1, 1}

        };


        for (int[] row : table) {
            String minterms = "";
            String Maxterms = "";
            for (int j = 0; j < row.length - 4; j++) {
                if (row[j] == 0) {
                    minterms += "(A'";
                    Maxterms += "(A";
                } else {
                    minterms += "A";
                    Maxterms += "(A'";
                }

                if (row[j + 1] == 0) {
                    minterms += "B'";
                    Maxterms += "+B";
                } else {
                    minterms += "B";
                    Maxterms += "+B'";
                }

                if (row[j + 2] == 0) {
                    minterms += "C'";
                    Maxterms += "+C ";
                } else {
                    minterms += "C ";
                    Maxterms += "+C' * ";
                }
                if(row[j + 3] == 0){
                    minterms += "D')+";
                    Maxterms += "+D ) * ";
                }
                else {
                    minterms += "D )";
                    Maxterms += "+D') * ";
                }
            }

            mintermler.add(minterms);
            maxtermler.add(Maxterms);


        }


    }


}
