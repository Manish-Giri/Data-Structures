package Chap_3;

/**
 * Created by manishgiri on 8/10/15.
 */
class ArrayIns {
    private int[] a; //ref to array a
    private int nElems; //number of data items

    //------------------------------
    //constructor
    public ArrayIns(int max) {
        a = new int[max];
        nElems = 0;
    }

    //-------------------------------
    public void insert(int value) {
        //insert item
        a[nElems] = value;
        //increment size
        nElems++;
    }

    //------------------------------
    //display array contents
    public void display() {
        for(int i = 0; i < nElems; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    //---------------------------------------
    public void insertionSort() {
        int in, out;
        //out is dividing line
        for(out = 1; out < nElems; out++) {

            //remove marked item
            int temp = a[out];

            //start shifts at out
            in = out;
            //until one is smaller
            while(in > 0 && a[in-1] >= temp) {
                a[in] = a[in-1]; //shift item to right
                --in; 	//go left one position
            }

            a[in] = temp;	//insert marked item
        }
    }

}
public class InsSortApp {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int maxSize = 100; //array size

        //create array
        ArrayIns arr = new ArrayIns(maxSize);

        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);

        arr.display();

        arr.insertionSort();

        arr.display();
    }

}
