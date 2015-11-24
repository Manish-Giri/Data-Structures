package Chap_6;

import java.util.Scanner;

/**
 * Created by Manish on 11/3/2015.
 * shows the use of a program that uses a loop to calculate the nth triangular number
 */

public class TriangleLoop {
    public static Scanner scanner = new Scanner(System.in);
    private static int triangle(int n) {
        int total = 0;
        while(n > 0) {
            total += n--;   //add current value of n to total then decrement n
        }

        return total;
    }

        System.out.println("Enter the number: ");
        int number = scanner.nextInt();
        System.out.println("The " + number+"th triangular number is  " + triangle(number));

    }
}
