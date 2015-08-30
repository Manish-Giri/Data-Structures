package Chap_4;

/**
 * Created by Manish on 8/30/2015.
 * code to demonstrate reversal of a word using a stack
 * user is asked to enter a string, letters of the string are extracted one by one and pushed on the stack
 * the letters are then popped off the stack, again one by one
 * due to the last-in-first-out nature of a stack, it is a good data structure to use for a word reversal
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The stack class, with generic stack methods like - push(), pop(), peek(), isEmpty(), isFull()
 */

class StackX1 {
    private int maxSize;
    private int top;
    private char[] stackArray;

    //---------------------------------------------------------------------
    //constructor
    public StackX1(int max) {
        maxSize = max;
        top = -1;   //no letters yet
        stackArray = new char[maxSize];     //init array
    }

    //---------------------------------------------------------------------
    //put item on top of stack
    public void push(char letter) {
        stackArray[++top] = letter;
    }

    //---------------------------------------------------------------------
    //remove item from top of stack
    public char pop(){
        return stackArray[top--];
    }

    //---------------------------------------------------------------------
    //peek at item on top of stack
    public char peek() {
        return stackArray[top];
    }

    //---------------------------------------------------------------------
    //check if stack is empty
    public boolean isEmpty() {
        return (top == -1);
    }

    //---------------------------------------------------------------------
    //check if stack is full
    public boolean isFull() {
        return (top == maxSize-1);
    }

    //end class StackX1
}

/**
 * The Reverser class, which is the meat of this application, will perform the main reversal
 * it will use the stack class, accept an input string, and return the output string which would be reverse of the input
  */
class Reverser {
    private String input, output;
    //---------------------------------------------------------------------
    //constructor
    public Reverser(String in) {
        input = in;
    }
    //---------------------------------------------------------------------
    //the method to reverse the given string
    public String doRev() {

        //get length of input string
        int len = input.length();

        //create stack object with this length
        StackX1 sx = new StackX1(len);

        //while letters remain in string
        for (int i = 0; i < len; i++) {
            //extract current letter and push on stack
            char c = input.charAt(i);
            sx.push(c);

        }

        //set output to be presently empty string
        output = "";

        //remove letters in reversed order and append to output string
        while(!sx.isEmpty()) {
            output += sx.pop();
        }

        return output;
    }
}

/**
 * The handler class, which will finally get the user input, and make use of the Reverser class to revere the given word
 */
public class ReverseApp {

    public static void main(String[] args) throws IOException{

        String input, output;
        //get input continuously
        while(true) {
            System.out.println("Enter a string: ");
            System.out.flush();
            //read a string from keyboard
            input = getString();

            //display original word
            System.out.println("The word you entered was: " + input);
            //if enter was pressed, quit
            if(input.equals("")) {
                break;
            }

            //create Reverser object
            Reverser reverser = new Reverser(input);
            //use object to reverse string
            output = reverser.doRev();

            //display string
            System.out.println("The reversed word is: " + output);
        }

    }

    //define the getString() method as static - w/o object creation
    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

}
