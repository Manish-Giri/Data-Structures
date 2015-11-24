package Chap_3;

/**
 * Created by manishgiri on 8/10/15.
 * demonstrates sorting objects using insertion sort
 */
class Person {
    private String lastName;
    private String firstName;
    private int age;

    //-------------------------------------------------------
    //constructor
    public Person(String last, String first, int a) {
        lastName = last;
        firstName = first;
        age = a;
    }

    //-------------------------------------------------------
    public void displayPerson() {
        System.out.print(" Last Name: " + lastName);
        System.out.print(", First Name: " + firstName);
        System.out.println(", Age: " + age);
    }

    //-------------------------------------------------------
    public String getLastName() {
        return lastName;
    }

} //end class Person

class ArrayInOb {

    //ref to array a
    private Person[] a;
    //number of items
    private int nElems;

    //-------------------------------------------------------
    //constructor
    public ArrayInOb(int max) {
        a = new Person[max];
        nElems = 0;
    }

    //-------------------------------------------------------
    //insert a person into array
    public void insert(String last, String first, int age) {
        a[nElems] = new Person(last, first, age);
        nElems++;
    }

    //-------------------------------------------------------
    public void display() {
        for(int i = 0 ; i < nElems; i++) {
            a[i].displayPerson();
        }
    }

    //-------------------------------------------------------
    public void insertionSort() {
        int in,out;
        //out is dividing line
        for(out = 1; out < nElems; out++) {
            //remove marked person
            Person temp = a[out];
            //start shifting at out
            in = out;

            //until smaller one found
            while(in > 0 && a[in-1].getLastName().compareTo(temp.getLastName()) > 0) {
                //shift item to right
                a[in] = a[in-1];
                //go left one position
                --in;
            }

            //insert marked item
            a[in] = temp;
        }
    }

}
public class ObjectSortApp {
    public static void main(String[] args) {
        int maxSize = 100; //array size

        //create array
        ArrayInOb arr = new ArrayInOb(maxSize);

        //insert 10 people
        arr.insert("Evans","Patty", 24);
        arr.insert("Smith", "Lorraine", 37);
        arr.insert("Yee", "Tom", 43);
        arr.insert("Adams", "Henry", 63);
        arr.insert("Hashimoto", "Sato", 21);
        arr.insert("Stimson", "Henry", 29);
        arr.insert("Velasquez", "Jose", 72);
        arr.insert("Lamarque", "Henry", 54);
        arr.insert("Vang", "Ming", 22);
        arr.insert("Creswell", "Lucinda", 18);

        System.out.println("Before sorting.");
        arr.display();

        //insertion-sort them
        arr.insertionSort();

        System.out.println("After sorting..");
        arr.display();


    }
}
