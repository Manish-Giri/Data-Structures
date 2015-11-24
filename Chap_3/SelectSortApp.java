package Chap_3;

/**
 * Created by Hp on 8/9/2015.
 * demonstrates selection sort
 */

class ArraySel {
    private int[] a;
    private int nElems;

    //----------------------------------------------
    public ArraySel(int max) {
        a = new int[max];
        nElems = 0;
    }

    //----------------------------------------------
    public void insert(int value){
        a[nElems] = value;
        nElems++;
    }

    //----------------------------------------------
    public void display() {
        for(int j = 0; j < nElems; j++) {
            System.out.print(a[j] + " ");
        }

        System.out.println();
    }

    //----------------------------------------------
    public void selectionSort() {
        int out, in, min;
        for(out = 0 ; out < nElems - 1; out++) {
            min = out;
            for(in = out+1; in < nElems; in++) {
                if(a[in] < a[min]){
                    min = in;
                }
            }
            swap(out, min);
        }
    }

    //----------------------------------------------
    private void swap(int one, int two) {
        int temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
}

public class SelectSortApp {

    public static void main(String[] args) {
        int maxSize = 100;
        ArraySel arr = new ArraySel(maxSize);

        //insert 10 items
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

        arr.selectionSort();

        arr.display();
    }
}
