import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static boolean x = false;
    static boolean o = false;
    public static void main(String[] args) throws Exception {
        System.out.println("X O X");
        System.out.println("X O X");
        System.out.println("X O X");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter cells : ");

        String input = scanner.next();

        char[] characters = input.toCharArray();

        gameGrid(characters);

    }

    private static void gameGrid(char[] characters) {
        char grid[][] = new char[3][3];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = characters[j % 3 + i * 3];
            }
        } //storing 1D's element on 2D.
        showGrid(grid);
    }

    private static void showGrid(char[][] grid) {
        System.out.println("----------");
        for (int i = 0; i < grid.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("----------");

        checkConditions(grid);
    }

    private static void checkConditions(char[][] grid) {
        readHorizontal(grid);
        readVertical(grid);
        readCrossX(grid);
        readCrossY(grid);

        if (x == true) {
            System.out.println("X wins");
        } else  if (o == true) {
            System.out.println("O wins");
        } 
    }

    private static void readCrossY(char[][] grid) {
        ArrayList<Character> sample = new ArrayList<Character>();
        int k = 2;

        for (int i = 0; i < grid.length; i++) {
            sample.add(grid[i][k]);
            k--;
        }
        checkArrayList(sample);
        sample.clear();
    }

    private static void readCrossX(char[][] grid) {
        ArrayList<Character> sample = new ArrayList<Character>();

        for (int i = 0; i < grid.length; i++) {
            sample.add(grid[i][i]);
        }
        checkArrayList(sample);
        sample.clear();
    }

    private static void readVertical(char[][] grid) {
        ArrayList<Character> sample = new ArrayList<Character>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                sample.add(grid[j][i]);
            }
            checkArrayList(sample);
            sample.clear();
        }
    }

    private static void readHorizontal(char[][] grid) {
        ArrayList<Character> sample = new ArrayList<Character>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                sample.add(grid[i][j]);

            }
            checkArrayList(sample);
            sample.clear();
        }
    }

    private static void checkArrayList(ArrayList<Character> sample) {
        if (sample.get(0) == sample.get(1) && sample.get(1) == sample.get(2) && sample.get(0) == sample.get(2)) {
            if (sample.contains('X')) {
                x = true;
            } else if (sample.contains('O')) {
                o = true;
            }
        } else {

        }
    }
}
