import java.util.*;
/**
 * Created by MattinAction on 9/30/16.
 * Teaching Experiences: Worked with Karlee and Matt's team to discuss happy/nasty paths 10/4/2016
 *
 */
public class Tree {
    public static void runTree(){
        // Happy Path: Building the instance of a treeSet
        TreeSet<Integer> numbers = new TreeSet<>();

        // Happy Path: .add() method
        numbers.add(3);
        numbers.add(37);
        numbers.add(48);
        numbers.add(32);
        numbers.add(21);
        numbers.add(23);

        System.out.println("Printing the TreeSet: ");
        System.out.println("\t" + numbers + "\n");

        // Happy Path: .contains() method
        System.out.println("Does 21 exist? " + numbers.contains(21));
        System.out.println("Does 78 exist? " + numbers.contains(78) + "\n");

        // Happy Path: .first() method
        System.out.println("The first object in the tree is: " + numbers.first() + "\n");

        // Happy Path: .size() method
        System.out.println("Objects in Tree: " + numbers.size() + "\n");

        // Happy Path: .subSet() method
        SortedSet<Integer> lessNumbers;
        lessNumbers = numbers.subSet(3,32);
        System.out.println("Smaller Number set:");
        System.out.println("\t" + lessNumbers + "\n");

        try {
            // Nasty Path: contains(null)
            // Result: Runtime NullPointerExceptions
            System.out.println("Does null exist? " + numbers.contains(null) + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Nasty Path: .subSet() where the top bound doesn't exist
        // Result: Pulls the numbers still within the range.
        SortedSet<Integer> lesserNumbers;
        lesserNumbers = numbers.subSet(3,40);
        System.out.println("Nasty Number Non-existent: ");
        System.out.println("\t" + lesserNumbers + "\n");


        try {
            // Nasty Path: .subSet() null on the upper bound
            // Result: Runtime NullPointerException
            SortedSet<Integer> Numbers1;
            Numbers1 = numbers.subSet(3,null);
            System.out.println("Nasty Number Non-existent: ");
            System.out.println("\t" + Numbers1 + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
