package Chap_5;

/**
 * Created by manish on 11/1/15.
 * this is an implementation of a queue based on a linked list
 * this differs from an array-based implementation of a queue
 * to the user, there's no difference in the underlying implementation as the class encapsulates the data structures used
 * this is an example of ADT(abstract data type) - which is concerned with the what of an app, not the how
 * in the queue, insert() is implemented by adding a link to the end of a list by insertLast()
 * similarly, remove() is implemented by deleting a link from the front of the list by deleteFirst()
 * A doubly ended list(references to first and last links in list) is used to implement the underlying linked li
 */

//class link - contains data and reference to next link
class Link5 {
    public int iData;
    public Link5 next;

    //constructor
    public Link5(int data) {
        iData = data;
    }

    public void displayLink() {
        /**
         * displays contents of current link
         */
        System.out.println(iData + "");
    }
}
//class FirstLastList - a doubly ended list
class LinkListQueue {

    private Link5 first;
    private Link5 last;

    //constructor - initialize empty list
    public LinkListQueue() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        /**
         * check if list is empty
         */

        return (first == null);
    }

    public void insertLast(int data) {
        /**
         * inserts a link at the end(last) of the list - simulating inserting an item in the queue
         */

        //setup link to be inserted
        Link5 newLink = new Link5(data);

        //if link is empty
        if(isEmpty()) {

            //set first to this newlink too
            first = newLink;
        }

        else {
            //list is not empty so set this newlink as the last one
            last.next = newLink;
        }

        last = newLink;

    }

    public int deleteFirst() {
        /**
         * deletes the first link from the list - similar to removing() from the front of a queue
         */

        //setup link to be removed
        Link5 temp = first;

        //if this is the only link in the list
        if(first.next == null) {
            //setup last as null
            last = null;
        }

        //else if not the only link
        else {
            //setup first as next first
            first = first.next;
        }

        return temp.iData;
    }

    public void displayList() {
        /**
         * displays list by traversing through links
         */

        //start at beginning
        Link5 current = first;

        while(current != null) {
            //display link contents and move forward
            current.displayLink();
            current = current.next;
        }

        System.out.println("");
    }

}

//class that communicates with the doubly ended list and exposes queue operations
class ListQueue {
    private LinkListQueue theList;

    public ListQueue() {
        theList = new LinkListQueue();
    }

    public void insert(int data) {
        /**
         * insertion operation on queue - inserts at end of queue
         */
        theList.insertLast(data);
    }

    public int remove() {
        /**
         * removes from front of list
         */
        return theList.deleteFirst();
    }

    public void displayQueue() {
        /**
         * displays the queue contents
         */
        theList.displayList();
    }

    public boolean isEmpty() {
        /**
         * check if queue is empty
         */
        return theList.isEmpty();
    }
}


public class ListQueueApp {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        ListQueue theQueue = new ListQueue();

        //insert 2 items
        theQueue.insert(20);
        theQueue.insert(40);

        //display queue contents
        theQueue.displayQueue();

        //insert 2 more items and display
        theQueue.insert(60);
        theQueue.insert(80);

        theQueue.displayQueue();

        //remove 2 items and display
        theQueue.remove();
        theQueue.remove();

        theQueue.displayQueue();

    }

}
