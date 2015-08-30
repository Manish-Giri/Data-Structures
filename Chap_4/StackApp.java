package Chap_4;

/**
 * Created by Hp on 8/11/2015.
 *
 * demonstrates stacks
 */

class StackX {
    private int maxSize; //size of stack array
    private int[] stackArray; //array
    private int top; //top of stack

    //------------------------------------------------------
    //constructor
    public StackX(int s) {
        maxSize = s;    //set array size
        stackArray = new int[maxSize];  //create array
        top = -1;   //no items in stack yet
    }

    //------------------------------------------------------
    //put item on top of stack
    public void push(int j) {
        //increment top and insert item
        stackArray[++top] = j;
    }

    //------------------------------------------------------
    //take item off from top of stack
    public int pop() {
        //access item and decrement top
        return stackArray[top--];
    }

    //------------------------------------------------------
    //peek at top of stack
    public long peek() {
        return stackArray[top];
    }

    //------------------------------------------------------
    //true if stack is empty
    public boolean isEmpty() {
        return (top == -1);
    }

    //------------------------------------------------------
    //true if stack is full
    public boolean isFull() {
        return (top == maxSize-1);
    }

}   //end class StackX

public class StackApp {

    public static void main(String[] args) {
        StackX stack = new StackX(10); //make a new stack

        stack.push(20);
        stack.push(40);
        stack.push(60);
        stack.push(80);

        //until stack is empty, remove items from top
        while (!stack.isEmpty()) {
            int value = stack.pop();
            System.out.print(value);
            System.out.println();
        }

        System.out.println();

    }
}
