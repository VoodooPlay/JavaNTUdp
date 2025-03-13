package org.green.lab2;

import java.util.Random;
import java.util.Scanner;

public class lab2 {
    final static int MIN_RANDOM = -50;
    final static int MAX_RANDOM = 51;
    static Scanner cin = new Scanner(System.in);
    static Random random = new Random();

    public static void start() {
        int[][] matr;
        int rows = 0, cols = 0;

        System.out.print("Кількість рядків матриці: ");
        rows = cin.nextInt();
        System.out.print("Кількість стовпців матриці: ");
        cols = cin.nextInt();

        rows = rows > 20 ? 20 : rows;
        cols = cols > 20 ? 20 : cols;

        System.out.print("Хочете ввести матрицю вручну? [y/n]: ");
        if (cin.next().equals("y"))
            matr = manualInit(rows, cols);
        else
            matr = randomInit(rows, cols);

        print(matr);

        System.out.println("Мінімальне значення матриці = " + min(matr));
        System.out.println("Максимальне значення матриці = " + max(matr));
        System.out.println("Середнє значення матриці = " + avg(matr));
    }

    private static int[][] randomInit(int rows, int cols) {
        int[][] matr = new int[rows][cols];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matr[i][j] = random.nextInt(MIN_RANDOM, MAX_RANDOM);

        return matr;
    }

    private static int[][] manualInit(int rows, int cols) {
        int[][] matr = new int[rows][cols];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matr[i][j] = cin.nextInt();

        return matr;
    }

    private static void print(int[][] matr) {
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[i].length; j++)
                System.out.print(" ".repeat(5 - Integer.toString(matr[i][j]).length()) + matr[i][j]);
            System.out.println();
        }
    }

    private static int min(int[][] matr) {
        int min = matr[0][0];

        for (int i = 0; i < matr.length; i++)
            for (int j = 0; j < matr[i].length; j++)
                if(min > matr[i][j])
                    min = matr[i][j];

        return min;
    }

    private static int max(int[][] matr) {
        int max = matr[0][0];

        for (int i = 0; i < matr.length; i++)
            for (int j = 0; j < matr[i].length; j++)
                if(max < matr[i][j])
                    max = matr[i][j];

        return max;
    }

    private static double avg(int[][] matr) {
        int sum = 0;

        for (int i = 0; i < matr.length; i++)
            for (int j = 0; j < matr[i].length; j++)
                sum += matr[i][j];

        double avg = (double)sum / (matr.length * matr[0].length);
        return avg;
    }

}
