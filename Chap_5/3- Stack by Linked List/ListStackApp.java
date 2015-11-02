package Chap_5;

/**
 * Created by manish on 11/1/15.
 * implements a stack based on a linked list instead of an array
 * to the user, there's no difference in the underlying implementation as the class encapsulates the data structures used
 * this is an example of ADT(abstract data type) - which is concerned with the what of an app, not the how
 * array based implementation is better for shorter-sized stack because not many elements need to be shifted for
 * insertion/deletion and retrieval is very fast
 * Linked List based implementation is better for larger-sized stack accordingly
 */

//---------CLASS LINK: implements the link---------

class Link4 {
    /**
     * this is the class that represents the basic link in the list
     * contains a reference to the next link(self-referential) class
     */
    public int iData;
    public Link4 next;

    //constructor
    public Link4(int data) {
        iData = data;
    }

    //------------------------method to display link contents------------------------
    public void displayLink() {
        System.out.println(iData + "");
    }

}

//---------CLASS LINKLIST: implements linked list as underlying DS for the stack---------

class LinkListStack {

    private Link4 first;	//linklist maintains reference to first item in list

    //constructor
    public LinkListStack() {
        //initialize empty list
        first = null;
    }

    //------------------------------------------------
    public boolean isEmpty() {
        /**
         * checks if list is currently empty
         */
        return (first == null);
    }

    //------------------------------------------------
    public void insertFirst(int data) {
        /**
         * adds a link to the front of the list - simulates push() on stack
         */
        //link to be added
        Link4 newLink = new Link4(data);
        //setup newlink to point to current first link through next
        newLink.next = first;
        //setup newlink as new first
        first = newLink;
    }

    //-----------------------------------------------------
    public int deleteFirst() {
        /**
         * deletes first link from front of the list - simulates pop() on stack
         * returns data field of link deleted - like pop()
         */
        //setup link to be removed
        Link4 temp = first;
        //change first to be next link
        first = first.next;
        //return data of deleted link
        return temp.iData;
    }

    //-----------------------------------------------------
    public void displayList() {
        /**
         * traverses the linked list and displays it's links
         */
        //setup link to traverse from beginning
        Link4 current = first;
        while(current != null) {
            //display current link's contents
            current.displayLink();
            //move current to next
            current = current.next;

        }
        System.out.println("");
    }

}

//---------CLASS LISTSTACK: interface for the main app to communicate with---------
class ListStack {
    private LinkListStack theList;

    //constructor
    public ListStack() {
        //initialize linked list
        theList = new LinkListStack();
    }

    //methods to simulate stack operations
    public void push(int item) {
        /**
         * pushes item to top of stack - by calling linklist's insertFirst() method
         */

        theList.insertFirst(item);
    }

    public int pop() {
        /**
         * pops (deletes and returns) item from top of the stack - by calling linklist's deleteFirst() method
         */
        return theList.deleteFirst();
    }

    public boolean isEmpty() {
        /**
         * check if stack is empty - calls linklist's isEmpty() method
         */

        return (theList.isEmpty());
    }

    public void displayStack() {
        /**
         * displays the stack - calls linklist's displayList()
         */
        System.out.println("Stack (TOP -> BOTTOM):");
        theList.displayList();
    }

}

public class ListStackApp {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        ListStack theStack = new ListStack();

        //push 2 items and display stack
        theStack.push(20);
        theStack.push(40);

        theStack.displayStack();

        //push 2 more items and display
        theStack.push(60);
        theStack.push(80);

        theStack.displayStack();

        //pop 2 items and display
        theStack.pop();
        theStack.pop();

        theStack.displayStack();


    }


}
