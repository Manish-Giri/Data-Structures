package Chap_2;

/**
 * Created by user1 on 7/28/15.
 * demonstrates array class with low level interface
 */

class LowArray {
    private int[] a;

    public LowArray(int size) {
        a = new int[size];
    }

    //set value
    public void setElement(int index, int value) {
        a[index] = value;
    }

    //get value
    public int getElement(int index) {
        return a[index];
    }
}
public class LowArrayApp {

    public static void main(String[] args) {
        LowArray arr = new LowArray(100);

        //number of items in array
        int nElems = 0;

        //loop variable
        int j;

        //insert 10 items
        arr.setElement(0, 77);
        arr.setElement(1, 99);
        arr.setElement(2, 44);
        arr.setElement(3, 55);
        arr.setElement(4, 22);
        arr.setElement(5, 88);
        arr.setElement(6, 11);
        arr.setElement(7, 0);
        arr.setElement(8, 66);
        arr.setElement(9, 33);

        //now #items in array = 10
        nElems = 10;

        //display items
        System.out.println("Displaying items in array");
        for(j = 0; j < nElems; j++) {
            System.out.print(arr.getElement(j) + " ");
        }
        System.out.println();

        //search for an item

        int searchKey = 26;
        System.out.println("Searching item: " + searchKey);
        for(j = 0; j < nElems; j++) {
            if (arr.getElement(j) == searchKey) {
                System.out.println("Found " + searchKey);
                break;
            }
        }

            if(j == nElems) {
                System.out.println("Can't find " + searchKey);
            }


        //delete an item
        int toDelete = 55;
        System.out.println("To delete: " + toDelete);
        for(j = 0; j < nElems; j++) {
            if (arr.getElement(j) == toDelete) {
                System.out.println("Found " + toDelete + ", and deleted. ");
                break;
            }
        }

            for(int k = j; k < nElems; k++) {
                arr.setElement(k, arr.getElement(k+1));
            }

            //reduce number of elements by 1
            nElems--;


        //display items
        System.out.println("Displaying items in array");
        for(j = 0; j < nElems; j++) {
            System.out.print(arr.getElement(j) + " ");
        }
        System.out.println();
    }


}
