import java.util.HashMap;

/**
 * Created by MattinAction on 9/30/16.
 */
public class Map {
    public static void runMap(){
        // Happy Path: Building the first instance of a hashmap
        HashMap<String,Integer> grades = new HashMap<>();

        // Happy Path: .put() method
        grades.put("Gregory", new Integer(90));
        grades.put("Harrop", new Integer(89));
        grades.put("Boone", new Integer(75));
        grades.put("Lopez", new Integer(87));
        grades.put("Getliff", new Integer(85));

        System.out.println("Initial display of the map");
        System.out.println("\t" + grades + "\n");

        // Happy Path: .get() method
        System.out.println("Looping through the hashMap");
        for (String currentKey: grades.keySet()) {
            System.out.println("\t" + currentKey + "\t=> " + grades.get(currentKey));
        }
        System.out.println("List complete" + "\n");

        // Happy Path: .size() method
        int length = grades.size();
        System.out.println("Hashmap Length: " + length + "\n");

        // Happy Path: .remove() method
        grades.remove("Boone");
        System.out.println("After Removal");

        for (String currentKey: grades.keySet()) {
            System.out.println("\t" + currentKey + "\t=> " + grades.get(currentKey));
        }

        length = grades.size();
        System.out.println("Hashmap Length: " + length + "\n");

        // Nasty Path: Key that doesn't exist
        // Result: returns null
        System.out.println("Nonexistent key = " + grades.get("Harold") + "\n");

        // Nasty Path: Key with null as value
        // Result: value returns as null
        grades.put("Oscar", null);
        System.out.println("Null value = " + grades.get("Oscar") + "\n");

    }

}
