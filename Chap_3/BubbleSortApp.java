package Chap_3;

/**
 * Created by Manish on 8/6/2015.
 * demonstrates bubble sort code
 */

class ArrayBub {

    //ref to array a
    private int[] a;
    //number of items
    private int nElems;

    //----------------------------------------------
    //constructor
    public ArrayBub(int max) {
        a = new int[max]; //create array
        nElems = 0; //no items yet
    }

    //----------------------------------------------
    //insert() to insert an item in array
    public void insert(int value) {
        a[nElems] = value;  //insert item
        nElems++;   //increment value
    }

    //----------------------------------------------
    //display()
    public void display() {
        System.out.println("Displaying items of array.");
        for(int i = 0; i < nElems; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    //----------------------------------------------
    //sort() using bubble sort
    public void bubbleSort() {
        int out, in;
        //outer loop (backward)
        for(out = nElems - 1; out > 1; out--) {

            //inner loop(forward)
            for(in = 0; in < out; in++) {
                //out of order?
                if(a[in] > a[in+1]) {
                    //swap
                    swap(in, in+1);
                }
            }
        }
        System.out.println("Sort completed.");
    }   //end bubblesort()

    //----------------------------------------------
    //swap()
    public void swap(int one, int two) {
        int temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
}   //end class ArrayBub

//----------------------------------------------
public class BubbleSortApp {
    public static void main(String[] args) {
        int maxSize = 100;  //array size
        ArrayBub arr;   //reference to array
        arr = new ArrayBub(maxSize);    //create array

        //insert 10 items
        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(0);
        arr.insert(66);
        arr.insert(33);

        //display items
        arr.display();

        //sort items
        arr.bubbleSort();

        //display again
        arr.display();

    }


}
