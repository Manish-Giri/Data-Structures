package Chap_2;

/**
 * Created by Hp on 8/5/2015.
 */

class OrderedArray {

    private int[] arr; //reference to array
    private int nElems; //size of array

    //------------------------------------------------
    //constructor
    public OrderedArray(int max) {
        arr = new int[max];
        nElems = 0; //no items yet in array
    }


    //------------------------------------------------
    //method to return size of array
    public int size() {
        return nElems;
    }

    //------------------------------------------------
    //find method using binary search
    public int find(int key) {

        //set upper and lower bounds
        int lowerBound = 0;
        int upperBound = nElems - 1;

        //current index for middle of range
        int curIn;

        while (true) {

            //continually divide range in half
            curIn = (lowerBound + upperBound) / 2;

            //if current index is already equal to key, return index of key
            if(arr[curIn]  == key) {
                return curIn;
            }

            //if range is too small, item is not present in array
            else if(lowerBound > upperBound) {
                return nElems;  //simply return number of items in array
            }

            //else adjust new range based on key
            else {
                //if key at current index is smaller than search key = key will be in upper half
                if(arr[curIn] < key) {
                    //adjust range so that lowerBound starts from 1 above current index
                    lowerBound = curIn + 1;
                }

                else {
                    // adjust range so that upper bound is one less than current index
                    upperBound = curIn - 1;
                }


            }
        }
    } // end of find()

    //------------------------------------------------
    //insert() to insert new item in array - using linear search
    public void insert(int key) {
        int j;

        //find position in array to insert item
        for(j = 0; j < nElems; j++) {

            //found position - current item in array is larger than key
            if (arr[j] > key) {
                break;
            }
        }


            //move bigger elements up by one spot
            for (int k = nElems; k > j; k--) {
                arr[k] = arr[k - 1];
            }

        //insert item in array
        arr[j] = key;

        //adjust size of array
        nElems++;
    } //end of insert()


    //------------------------------------------------
    //delete() to remove an item from array using binary search
    public boolean delete(int key) {

        //find position of key
        int j = find(key);

        //check what's returned
        if(j == nElems) {
            System.out.println("Key not found.");
            return false;   //item not found in array - return false
        }

        else {
            for(int k = j; k < nElems; k++) {
                arr[k] = arr[k+1];
            }

            //adjust size of array
            nElems--;
            System.out.println("Key deleted.");
            return true;
        }
    } //end of delete()

    //------------------------------------------------
    //display() to print array content
    public void display() {
        System.out.println("Items in the array are: ");
        for(int i = 0; i < nElems; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }


}
public class OrderedArrayApp {

    public static void main(String[] args) {

        //size of array
        int maxSize = 100;

        //create array
        OrderedArray a = new OrderedArray(maxSize);

        //insert 10 items
        System.out.println("Inserting items...");
        a.insert(77);
        a.insert(99);
        a.insert(44);
        a.insert(55);
        a.insert(22);
        a.insert(88);
        a.insert(11);
        a.insert(0);
        a.insert(66);
        a.insert(33);

        System.out.println("Insertion complete, items in array are: ");
        a.display();

        //search key
        int searchKey = 55;
        //search for item
        int pos = a.find(searchKey);
        if(pos != a.size()) {
            System.out.println("Search key " + searchKey + " found at position " + pos);
        }
        else {
            System.out.println("Can't find search key " + searchKey);
        }

        a.display();

        //delete 3 items
        a.delete(27);
        a.delete(19);
        a.delete(55);

        a.display();

    }
}
