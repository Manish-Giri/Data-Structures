package Chap_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by manishgiri on 11/6/15.
 * anagrams a word through recursion
 */
public class AnagramApp {
    private static int size;
    private static char[] arrChar = new char[50];
    private static int count = 0;

    public static String getString() throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        //System.out.println("Enter the number");
        String s = br.readLine();
        return s;
    }

    private static void rotate(int newsize) {
        int j;
        int position = size - newsize;
        char temp = arrChar[position];
        for(j = position + 1; j < size; j++) {
            arrChar[j-1] = arrChar[j];
        }
        arrChar[j-1] = temp;
    }

    public static void main(String[] args) {
        System.out.printf("Enter a word");
        try {
            String input = getString();
            size = input.length();
        }
        catch (IOException e) {
            System.out.println("Invalid Input");
            e.printStackTrace();
        }
        System.out.print("Rotated word is - ");
        rotate(size-1);
        System.out.println(arrChar);


    }
}
