package Chap_5;

/**
 * Created by manishgiri on 10/24/15.
 * the most basic linked list application has three functions - insert at front, delete at front and display linked list
 * to do this - the application has 3 classes
 * class Link describes the basic links in a linked list - it has fields for data and reference to the next link (self-referential)
 * class LinkedList has just one field - a Link1 reference to the very first link in the list
 * class LinkedListApp is the main point - driving the whole thing
 */

class Link {

    //fields
    public int iData;
    public double dData;
    public Link next;

    //constructor - sets the data fields, next is set to null automatically

    public Link(int i, double d) {
        iData = i;
        dData = d;
    }

    //display links in list
    public void displayLink() {
        System.out.print("{" + iData + " " + dData + "} ");
    }
}

class LinkList {

    //field - reference to first Link object
    private Link first;

    //constructor - initialize first to NULL - no items in list
    public LinkList() {
        first = null;   //same as not setting it explicitly to null
    }

    //isEmpty() - to check if list is empty
    public boolean isEmpty() {
        return first == null;
    }

    //insertFirst() to add a link(node) at the beginning of List
    public void insertFirst(int id, double dd) {

        //create new Link object with necessary field data
        Link newLink = new Link(id, dd);

        //set next field of this newlink to current first node referenced by first
        newLink.next = first;

        //make this the new node referenced by first
        first = newLink;
    }

    //deleteFirst() to delete first link node (and return it) from list
    public Link deleteFirst() {
        //link to be returned, assuming list is not empty
        //current first is the item to be deleted, save reference to it
        Link temp = first;

        //make the link(node) first points to as the new first
        first = first.next;

        //return deleted link
        return temp;
    }

    //displayList() to display the list: start at first and follow the chain of next references to display each link
    public void displayList() {

        //if List is empty, display message, else display elements

        if(isEmpty()) {
            System.out.println("There are no elements in the list.");
        }

        else {

        System.out.println("List (first --> last)");

        //set a variable 'current' to first and use it to follow the chain of references
        Link current = first;

        //start at beginning of list and display each link and move forward until current link is not null
        while (current != null) {
            current.displayLink();

            //set current to next link(node) in the list
            current = current.next;
        }

        System.out.println();

        }
    }
}

public class LinkedListApp {

    public static void main(String[] args) {

        //create new list
        LinkList theList = new LinkList();

        theList.insertFirst(22, 2.99);
        theList.insertFirst(44, 4.99);
        theList.insertFirst(66, 6.99);
        theList.insertFirst(88, 8.99);

        theList.displayList();

        while (!theList.isEmpty()) {
            Link deleted = theList.deleteFirst();
            System.out.print("Deleted: ");
            deleted.displayLink();
            System.out.println(" ");
        }

        theList.displayList();
    }
}


