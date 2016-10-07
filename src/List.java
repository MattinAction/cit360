import java.util.*;

/**
 * Sandbox code for the List segment of collections
 * Created by MattinAction on 9/30/16.
 */


public class List {
    public static void runList(){
        // Happy Path: Basic ArrayList
        // Result: Team member names are added into the array and displayed below
        ArrayList list1 = new ArrayList();
        list1.add("Matt");
        list1.add("Jordan");
        list1.add("Tanner");

        System.out.println("Happy Path: Creating ArrayList");
        System.out.println("\t" + list1 + "\n");

        // Happy Path: add()
        // Result: Brother Barney is added to the team and displayed below
        list1.add("Brother Barney");

        System.out.println("Happy Path: add()");
        System.out.println("\t" + list1 + "\n");

        // Happy Path: get() and size();
        // Result: size() returns the size of the list and get retrieves the element
        int length = list1.size();
        System.out.println("Happy Path: get() and size()");
        System.out.println("\tList size is: " + length);

        for (int i = 0; i < length; i++){
            System.out.println("\tTeam Member: " + list1.get(i));
        }

        System.out.println(); //Placed here to allow for spacing

        // Happy Path: iterator()
        // Result: runs through the arraylist using an iterator
        Iterator itr = list1.iterator();

        System.out.println("Happy Path: iterator()");
        while(itr.hasNext()){
            Object member = itr.next();
            System.out.println("\t" + member);
        }

        System.out.println(); //Placed here to allow for spacing

        // Nasty Path: Sending the list a different datatype
        // Result: The integer was added?!?!?!?!?
        list1.add(7);

        System.out.println("Nasty Path: Adding a different datatype");
        System.out.println("\t" + list1 + "\n");

        // Nasty Path: adding the nextLine character to list
        // Result: nextLine character acts like it normally would after being added at the back of the list.
        list1.add("\n");
        System.out.println("With nextLine character added");
        System.out.println("\t" + list1 + "\n");

        // Nasty Path: add() null
        // Result: Null is added as an object
        list1.add(null);
        System.out.println("Adding NULL");
        System.out.println("\t" + list1 + "\n");

        // Nasty Path: list.remove(not in the list)
        // Result: The code functions as if nothing has happened since it didn't exist
        list1.remove("Dog Crap");
        System.out.println("Removing an object that's not there");
        System.out.println("\t" + list1 + "\n");
    }
}
