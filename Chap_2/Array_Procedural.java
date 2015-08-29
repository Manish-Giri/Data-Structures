package Chap_2;

/**
 * Created by Hp on 7/19/2015.
 * demonstrates Java code to run this program
 */
public class Array_Procedural {

    public static void main(String[] args) {

        //create array
        int[] arr = new int[100];
        //number of items in array
        int nElems = 0;
        //loop counter
        int j;
        //search key
        int searchKey;

        //--------------------------------------------------
        //insert 10 items
        arr[0] = 77;
        arr[1] = 99;
        arr[2] = 44;
        arr[3] = 55;
        arr[4] = 22;
        arr[5] = 88;
        arr[6] = 11;
        arr[7] = 00;
        arr[8] = 66;
        arr[9] = 33;

        //now 10 items in array
        nElems = 10;

        //---------------------------------------------------
        //display items
        for (j = 0; j < nElems; j++ ) {
            System.out.print(arr[j] + " ");
        }
        System.out.println();
        System.out.println("Number of elements in array: " + arr.length );


        //--------------------------------------------------
        //find item with key 66
        searchKey = 66;
        for(j = 0; j < nElems; j++) {
            if(arr[j] == searchKey) {
                break;
            }
        }

        if(j == nElems) {
            System.out.println("Can't find " + searchKey);
        }

        else {
            System.out.println("Found " + searchKey);
        }

        //---------------------------------------------------
        //display items
        for (j = 0; j < nElems; j++ ) {
            System.out.print(arr[j] + " ");
        }
        System.out.println();
        System.out.println("Number of elements in array: " + arr.length );


        //-------------------------------------------------
        //delete item with key 55
        searchKey = 55;
        for(j = 0; j < nElems; j++) {
            if(arr[j] == searchKey) {
                System.out.println("Found " + searchKey + " at index " + j);
                System.out.println("Preparing to delete");
                break;
            }
        }

            for(int k = j; k < nElems - 1; k++) {
                arr[k] = arr[k+1];

            }
        nElems--;
        //System.out.println("Number of elements in array: " + arr.length );


        //--------------------------------------------------
        //display items
        for(j = 0; j < nElems; j++) {
            System.out.print(arr[j] + " ");
        }

        System.out.println();
        System.out.println("Number of elements in array: " + arr.length );

    }
}
