package Chap_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Manish on 11/4/2015.
 * using recursion to calculate triangular numbers
 */
public class TriangleApp {

    private static int theNumber;
    public static String getString() throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        System.out.println("Enter the number");
        String s = br.readLine();
        return s;
    }

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }

    private static int triangle(int n) {
        if(n == 1) {
            return 1;
        }
        else {
            return n + triangle(n-1);
        }
    }

    public static void main(String[] args) {
        try{
            theNumber = getInt();
        }

        catch (IOException e) {
            System.out.println("Invalid Input");
            e.printStackTrace();
        }
        System.out.println("The " + theNumber + "th triangular number is " + triangle(theNumber));
    }
}
