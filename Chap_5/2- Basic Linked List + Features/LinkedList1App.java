package Chap_5;

/**
 * Created by manish on 10/24/15.
 * this is similar to the earlier linkedlist application, only this has two additional methods for better support
 * find(int key) finds a link in the list with the specified key and
 * delete(int key) deletes a link in the list with the specified key
 * in both cases, the concerned link is returned
 */

class Link1 {

    //fields
    public int iData;
    public double dData;
    public Link1 next;

    //constructor - sets the data fields, next is set to null automatically

    public Link1(int i, double d) {
        iData = i;
        dData = d;
    }

    //display links in list
    public void displayLink() {
        System.out.print("{" + iData + " " + dData + "} ");
    }
}

class LinkList1 {

    //field - reference to first Link object
    private Link1 first;

    //constructor - initialize first to NULL - no items in list
    public LinkList1() {
        first = null;   //same as not setting it explicitly to null
    }

    //isEmpty() - to check if list is empty
    public boolean isEmpty() {
        return first == null;
    }

    //insertFirst() to add a link(node) at the beginning of List
    public void insertFirst(int id, double dd) {

        //create new Link object with necessary field data
        Link1 newLink = new Link1(id, dd);

        //set next field of this newlink to current first node referenced by first
        newLink.next = first;

        //make this the new node referenced by first
        first = newLink;
    }

    //deleteFirst() to delete first link node (and return it) from list
    public Link1 deleteFirst() {
        //link to be returned, assuming list is not empty
        //current first is the item to be deleted, save reference to it
        Link1 temp = first;

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
            Link1 current = first;

            //start at beginning of list and display each link and move forward until current link is not null
            while (current != null) {
                current.displayLink();

                //set current to next link(node) in the list
                current = current.next;
            }

            System.out.println();

        }
    }

    //new method - find a link with given key
    public Link1 find(int key) {

        //start at very beginning of list and set first to current link
        Link1 current = first;

        //while required key is not found, move forward
        while (current.iData != key) {

            //if next link is null, then end is reached and item is not found
            if(current.next == null) {
                return null;
            }

            //else
            else {

                //set current to next link
                current = current.next;
            }
        }

        return current;

    }

    //new method - delete a link with given key

    public Link1 delete(int key) {

        /**
         * to delete a link, need to maintain two references at all times :
         * to the current node, and to the preceeding node which will point to the following node if current is deleted
         *
         * */

        //start at beginning and set both current & previous to first
        Link1 current = first;
        Link1 previous = first;

        while(current.iData != key) {

            //if next link is null, end of list is reached & link not found
            if (current.next == null) {
                return null;
            } else {
                //change preceeding link to current link &
                //change current to next link
                previous = current;
                current = current.next;

            }

        }

        //now that current link is found - delete it:
        // special case: if first link happens to be the current one, set 'first' to the following link
        if(first == current) {
            first = current.next;
        }

        else {
            //otherwise set preceeding link's next to current's next link
            previous.next = current.next;
        }
        return current;
    }

}
public class LinkedList1App {

    //main application
    public static void main(String[] args) {

        //create list
        LinkList1 theList = new LinkList1();

        //insert 4 items

        theList.insertFirst(22, 2.99);
        theList.insertFirst(44, 4.99);
        theList.insertFirst(66, 6.99);
        theList.insertFirst(88, 8.99);

        //display list now
        theList.displayList();

        //find link with key 44
        Link1 f = theList.find(44);
        if(f != null) {
            System.out.println("Found link with key " + f.iData);
        }

        else {
            System.out.println("Could not find link.");
        }

        //delete link with key 66
        Link1 d = theList.delete(66);
        if(d != null) {
            System.out.println("Deleted link with key " + d.iData);
        }

        else {
            System.out.println("Could not delete the link.");
        }

        //display list again
        theList.displayList();
    }

}

