package Chap_5;

/**
 * Created by Manish on 10/25/2015.
 * this is an implementation of a doubly linked list, it differs from a singly linked list in that you can traverse
 * backwards along the list. For this, every Link(node) in the list has a reference to the previous link called previous
 * Insertion routine has 3 methods - insertFirst(), insertLast() and insertAfter() which allows you to insert a node
 * at the beginning, at the end or after a specific item in the list
 * Deletion routine has 3 methods - deleteFirst(), deleteLast() and deleteKey(). the deleteKey() method allows to look
 * up a specific node and then delete it.
 * this doubly linked list is also a double ended list in that it always keeps a reference to the last node in the list
 * (along with the firs)
 */

class Link3 {

    //fields - int and 2 references to next and previous
    public int iData;
    public Link3 next;
    public Link3 previous;

    //constructor - initialize data and references are set to null auto.
    public Link3(int data) {
        iData = data;
    }

    //display the current link's data
    public void displayLink() {
        System.out.print("{" + iData + "} ");
    }
}

class DoublyLinkedList {

    //store 2 refernces to first and last link in list;
    private Link3 first;
    private Link3 last;

    //constructor to set references to null
    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    //------------------------------------------------------------------
    //isEmpty() to check if list is empty
    public boolean isEmpty() {
        return (first == null);
    }

    //------------------------------------------------------------------
        //----------------INSERTION ROUTINES--------------
    //------------------------------------------------------------------
    //insertFirst() - to insert a node at the beginning of the list
    public void insertFirst(int data) {
        /**
         * inserts a link with given data at the front of the list
         */

        //create new link with data
        Link3 newLink = new Link3(data);

        //special case - if list is empty, set last accordingly
        if(isEmpty()) {
            last = newLink;
        }

        else {
            //else if list !empty, connect current first link's previous field to newlink
            first.previous = newLink;
        }

        //set next field of newlink to refer to old first
        newLink.next = first;
        //and set newlink as current first
        first = newLink;

    }

    //------------------------------------------------------------------
    //method to insert at last of list
    public void insertLast(int data) {
        /**
         * inserts a link with given data at the end of linked list
         */

        //create new link with data
        Link3 newLink = new Link3(data);

        //special case - if list is empty
        if(isEmpty()) {
            first = newLink;
        }

        else {
            //if list not empty, make the current last's next refer to newlink
            last.next = newLink;
            //and set newlink's previous to current last
            newLink.previous = last;
        }

        //finally set last as newlink
        last = newLink;

    }

    //------------------------------------------------------------------
    //method to insert at end of a specific link
    public boolean insertAfter(int key, int data) {
        /**
         * inserts a link with given data after the link whose data matches given key
         */

        //first search for link with given key, starting at beginning
        Link3 current = first;

        //until key with data is found
        while(current.iData != key) {
            current = current.next;

            //if end of list is reached without given key, exit
            if(current == null) {
                return false;
            }
        }

        //when link with key is found, create new link with data to be inserted after it
        Link3 newLink = new Link3(data);

        //if current link is the last one in the list
        if(current == last) {
            newLink.next = null;
            last = newLink;
        }

        //else if current link is not last one in the list
        else {

            //first modify the links towards the right

            //make the newlink's next field refer to current link's next field ie: following node
            newLink.next = current.next;
            //make the following node's previous field refer to newlink
            //NOTE: current.next.previous refers to the previous field of the link referred to by next field of the current link
            current.next.previous = newLink;
        }

        //then modify the links on the left
        //make newlink's previous field refer to current
        newLink.previous = current;
        //make current's next refer to newlink
        current.next = newLink;

        //return status of insertion
        return true;

    }

    //------------------------------------------------------------------
        //----------------DELETION ROUTINES--------------
    //------------------------------------------------------------------

    public Link3 deleteFirst() {
        /**
         * deletes first node from the linked list
         */
        //create link to be returned
        Link3 temp = first;

        //special case: if only 1 link in list
        if(first.next == null) {
            //set last as null as there will be no more links in list
            last = null;
        }
        //else if not just 1 link in next
        else {

            //set following node(after first)'s previous field to null as this will be the new first
            first.next.previous = null;
        }

        first = first.next;
        //and return deleted link
        return temp;

    }

    //------------------------------------------------------------------
    public Link3 deleteLast() {
        /**
         * deletes last link from the linked list
         */

        //create link to be deleted
        Link3 temp = last;
        //special case - if only 1 link in list
        if(first.next == null) {
            //set first to null as no links in list anymore
            first = null;
        }

        else {
            //set current second last's next field to null as this is now the new last
            last.previous.next = null;
        }

        //and make the second last link as the new last
        last = last.previous;

        //and return deleted link
        return temp;

    }

    //------------------------------------------------------------------
    public Link3 deleteKey(int key){
        /**
         * deletes link with given data, if found
         */

        //start searching for link from the first
        Link3 current = first;

        while (current.iData != key) {

            //move forward until link found
            current = current.next;

            if (current == null) {
                //if not found, return null
                return null;
            }
        }

        //when link found, adjust connections accordingly
        //special case 1 - if this is the first link
        if(current == first) {
            //set new first as the first's next link
            first = current.next;

        }
        else {
            //if this is not the first link
            // set preceeding link's next to refer to following link by current's next
            current.previous.next = current.next;
        }

        //special case 2 - if this is the last link
        if(current == last) {
            //set new last as the current last's previous link
            last = current.previous;
        }

        else {
            //set current link's next link's previous field to refer to current link's preceeding link
            current.next.previous = current.previous;
        }

        return current;
        }

    //------------------------------------------------------------------
        //----------TRAVERSAL ROUTINES----------
    //------------------------------------------------------------------
    public void displayForward() {
        /**
         * display links forward ie: left -> right
         */
        System.out.println("List (first -> last)");

        //start at first and move forward
        Link3 current = first;

        while (current != null) {
            current.displayLink();
            //change current to refer to following node
            current = current.next;
        }
        System.out.println(" ");
    }

    //------------------------------------------------------------------
    public void displayBackward() {
        /**
         * display links backward ie: right -> left
         */

        System.out.println("List (last -> first)");

        //start at last and move backward
        Link3 current = last;
        while (current != null) {
            current.displayLink();
            //change current to refer to previous node
            current = current.previous;
        }

        System.out.println(" ");
    }
}

public class DoublyLinkedApp {

    public static void main(String[] args) {

        //create new list
        DoublyLinkedList theList = new DoublyLinkedList();

        //insert 3 at front
        theList.insertFirst(22);
        theList.insertFirst(44);
        theList.insertFirst(66);

        //insert 3 items at end
        theList.insertLast(11);
        theList.insertLast(33);
        theList.insertLast(55);

        //display list forward
        theList.displayForward();

        //display list backward
        theList.displayBackward();

        //delete first item
        System.out.println("Deleted: " + theList.deleteFirst().iData);

        //delete last item
        System.out.println("Deleted: " + theList.deleteLast().iData);

        //delete a specific link - with key 11
        System.out.println("Deleted: " + theList.deleteKey(11).iData);

        //display list forward again
        theList.displayForward();

        //insert 2 items after a specific link
        //insert after link with data 22
        theList.insertAfter(22, 77);

        theList.displayForward();

        //insert after link with 33
        theList.insertAfter(33, 89);

        theList.displayForward();
    }
}
