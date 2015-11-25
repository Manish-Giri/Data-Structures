package Chap_6;

/**
 * Created by manishgiri on 11/24/15.
 * implementation of recursive merge sort algorithm
 *
 */

class DArray {
    private int[] theArray;
    private int nElems;

    public DArray(int max) {
        theArray = new int[max];
        nElems = 0;
    }

    //-----------------------------------------------
    public void insert(int value) {
        theArray[nElems++] = value;
    }

    //-----------------------------------------------
    public void display() {
        for(int i = 0; i < nElems; i++) {
            System.out.print(theArray[i] + " ");
        }
        System.out.println();
    }

    //-----------------------------------------------
    //the main mergersort method which is called by user in main()
    public void mergesort() {
        //create temp array of same size to which sorted elements will be copied
        int[] temp = new int[nElems];

        //call the recursive mergesort which will recursively split an array into half
        recMergeSort(temp, 0, nElems - 1);

    }

    //-----------------------------------------------
    private void recMergeSort(int[] temp, int lowerBound, int upperBound) {
        //base condition for recursion
        if(lowerBound == upperBound) {
            return;
        }

        //else recursively split the array until an array of one element is reached
        else {
            //compute mid point for splitting
            int mid = (lowerBound + upperBound) / 2;

            //sort lower half (integer division rounds down to nearest integer)
            recMergeSort(temp, lowerBound, mid);

            //sort upper half
            recMergeSort(temp, mid+1, upperBound);

            //merge method that combines halves into temp array & returns to orig arr
            merge(temp, lowerBound, mid+1, upperBound);

        }
    }

    //-----------------------------------------------
    //merge method - combines split halves in sorting order, copies into temp arr
    //and copies sorted array into original array
    private void merge(int[] temp, int lowPtr, int highPtr, int upperBound) {

        //index for temp array
        int j = 0;

        //lowerBound will be used to copy items back in original array at the correct spot
        int lowerBound = lowPtr;

        int mid = highPtr - 1;

        //compute total number of items in the array
        int n = (upperBound - lowerBound + 1);

        //first case - when items exist in both halves (to be sorted and merged)
        while(lowPtr <= mid && highPtr <= upperBound) {
            //if item in first half is less than item in second half, copy it into temp array
            if(theArray[lowPtr] < theArray[highPtr]) {
                temp[j++] = theArray[lowPtr++];
            }

            else {
                //when item in second half is lesser
                temp[j++] = theArray[highPtr++];
            }
        }

        //second case - when items exist in first half, not in second half
        while(lowPtr <= mid) {
            //simply copy items from first half to temp
            temp[j++] = theArray[lowPtr++];
        }

        //third case - when items exist in second half, not in first half
        while(highPtr <= upperBound) {
            //simply copy items from second half to temp
            temp[j++] = theArray[highPtr++];
        }

        //copy items from temp to original array in sorted and corresponding order
        for(j = 0; j < n; j++) {
            //begin insertion from the item at lowerbound spot
            theArray[lowerBound + j] = temp[j];
        }
    }


}
public class MergeSortApp {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int maxSize = 50;
        //create array
        DArray arr = new DArray(maxSize);

        //insert random items
        arr.insert(64);
        arr.insert(21);
        arr.insert(33);
        arr.insert(70);
        arr.insert(12);
        arr.insert(85);
        arr.insert(44);
        arr.insert(3);
        arr.insert(99);
        arr.insert(1);
        arr.insert(108);
        arr.insert(36);

        //display array
        arr.display();

        //sort array
        arr.mergesort();
        //display array
        arr.display();

    }
}
