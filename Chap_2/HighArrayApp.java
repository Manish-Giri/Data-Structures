package Chap_2;

/**
 * Created by user1 on 7/28/15.
 * demonstrates array class with high level interface
 */

class HighArray {

    //reference to array a
    private int[] a;

    //number of items
    private int nElems;

    //-----------------------------------------
    //constructor
    public HighArray(int max) {
        a = new int[max]; //create the array
        nElems = 0; //no items in the array yet
    }

    //-----------------------------------------
    //find method
    public boolean find(int searchKey) {

        //loop counter
        int j;

        for(j = 0; j < nElems; j++) {
            if(a[j] == searchKey) {
                //System.out.println("Found item " + searchKey);
                break;
            }
        }

        if(j == nElems) {
            //System.out.println("Could not find item " + searchKey);
            return false;
        }

        else
            return true;

    }

    //---------------------------------------------
    //insert method to insert an item in the array
    public void insert(int value) {
        a[nElems] = value;
        nElems++;
        System.out.println("Item " + value + " was successfully inserted.");
    }

    //--------------------------------------------
    //delete() - to delete an item from array
    public boolean delete(int value) {

        //loop counter
        int j;

        //search item to be deleted
        for(j = 0; j < nElems; j++) {
            if(a[j] == value) {
                System.out.println("Found item " + value +", and deleted. ");
                break;
            }
        }

        //could not find item
        if(j == nElems) {
            System.out.println("Could not find item " + value);
            return false;
        }

        //found item
        else {
            for(int k = j; k < nElems; k++) {
                a[k] = a[k+1];
            }
            nElems--;
            return true;
        }
    }

    //------------------------------------------
    //display() - print all items in array
    public void display() {
        System.out.println("Items in the array are: ");
        for(int j = 0; j < nElems; j++) {
            System.out.print(a[j] + " ");
        }

        System.out.println();
    }

}
public class HighArrayApp {

    public static void main(String[] args) {
        //array size
        int maxSize = 100;

        //create array
        HighArray arr = new HighArray(maxSize);

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

        System.out.println();

        //search for an item
        int searchKey = 35;
        System.out.println("Searching for item " + searchKey);
        if(arr.find(searchKey))
            System.out.println("Found " + searchKey);
        else
            System.out.println("Could not find " + searchKey);

        System.out.println();

        //delete 3 items
        arr.delete(47);
        arr.delete(0);
        arr.delete(99);

        //display items post deletion
        arr.display();

    }
}
