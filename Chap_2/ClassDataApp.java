package Chap_2;

/**
 * Created by Hp on 8/5/2015
 * Class dataarray.java - data items as class objects to run this program
 */

class Person{

    //fields
    private String lastName;
    private String firstName;
    private int age;

    //------------------------------------------
    //constructor
    public Person(String last, String first, int a) {
        lastName = last;
        firstName = first;
        age = a;
    }

    //------------------------------------------
    //display method
    public void displayPerson() {
        System.out.print(" Last Name: " + lastName);
        System.out.print(", First Name: " + firstName);
        System.out.println(", Age: " + age);
    }

    //------------------------------------------
    //get last name
    public String getLastName() {
        return lastName;
    }
} //end class Person


class ClassDataArray {
    private Person[] p; //reference to a person array
    private int nElems; //number of data items in Person array

    //constructor - create array and set no. of items in it to 0
    public ClassDataArray(int max) {
        p = new Person[max];
        nElems = 0;
    }

    //------------------------------------------------
    //find() - find a person in array
    public Person find(String searchName) {
        int j;
        //loop over array
        for(j = 0; j < nElems; j++) {
            if(p[j].getLastName().equals(searchName)) { //if person's last name is found {
                break;  //stop search
            }
        }

        //if j equals num of items, person not found
        if(j == nElems) {
            return null;
        }

        else {
            return p[j];    //return person object in position j
        }


    }

    //------------------------------------------
    //insert() - put person in array
    public void insert(String last, String first, int age) {

        //CREATE new person object and insert into position in array
        //position in array equals current number of items in array (nElems)
        p[nElems] = new Person(last, first, age);
        //increase number of items
        nElems++;
    }

    //------------------------------------------
    //delete() - remove a person from array
    public boolean delete(String searchName) {
        int j;
        for(j = 0; j < nElems; j++) {
            //if last name is equal to search name, stop search
            if(p[j].getLastName().equals(searchName)) {
                break;
            }
        }

        if(j == nElems) {
            //person not found
            System.out.println("Person with last name " + searchName + " was not found.");
            return false;
        }

        else {
            for (int k = j; k < nElems; k++) {
                p[k] = p[k+1];

            }

            //reduce size of array by 1
            nElems--;
            System.out.println("Person with last name " + searchName +"  was removed.");
            return true;
        }

    } //end delete()


    //------------------------------------------
    //display() - print all person details
    public void display() {
        System.out.println("Printing all persons' details");
        for (int i = 0; i < nElems; i++) {
            p[i].displayPerson();

        }
    }

    //------------------------------------------
} //end of class


public class ClassDataApp {

    public static void main(String[] args) {
        //array size
        int maxSize = 100;

        //create array - object of classdataarray
        ClassDataArray arr = new ClassDataArray(maxSize);

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

        //display people
        arr.display();

        //search for a person
        String searchKey = "Stimson";
        Person found = arr.find(searchKey); //found is a person object
        if(found != null) {

            System.out.println("Person was found!");
            //print details of person using person's display method
            found.displayPerson();
        }

        else {
            System.out.println("Person " + searchKey + " was not found.");
        }

        //delete 3 people
        System.out.println("Deleting James, Yee and Creswell");
        arr.delete("James");
        arr.delete("Yee");
        arr.delete("Creswell");

        //display persons after deletion
        arr.display();
    }
}
