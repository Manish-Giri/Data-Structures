package Chap_4;

/**
 * Created by Manish on 10/5/2015.
 * demonstrates working of a priority queue
 */

class PriorityQueue {

    private int maxSize;
    private int[] queueArray;
    private int nItems;

    //constructor
    public PriorityQueue(int s) {
        maxSize = s;
        queueArray = new int[maxSize];
        nItems = 0;
    }

    //insert item according to the key
    public void insert(int item) {

        int j;

        //if no items in queue, then add at the current position
        if (nItems == 0) {
            queueArray[nItems++] = item;
        }

        //if items are present in queue, search for position which is larger than item to be inserted
        else {
            for (j = nItems - 1; j >= 0; j--) {

                //if item to be inserted is larger than current item, shift upwards
                if (item > queueArray[j]) {
                    queueArray[j + 1] = queueArray[j];
                } else {
                    //if item to be inserted is smaller than next item, position found - break
                    break;
                }
            }

            //insert new item
            queueArray[j + 1] = item;

            nItems++;
        }
    }

    //remove() - remove item at front of queue
    public int remove() {
        return queueArray[--nItems];
    }

    //peekmin() - return item at front of queue without removing it
    public int peekMin() {
        return queueArray[nItems-1];
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }


}


public class PriorityQueueApp {

    public static void main(String[] args) {

        PriorityQueue pqueue = new PriorityQueue(5);

        pqueue.insert(30);
        pqueue.insert(50);
        pqueue.insert(10);
        pqueue.insert(40);
        pqueue.insert(20);

        //remove items and display

        while( ! pqueue.isEmpty()) {
            int item = pqueue.remove();
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
