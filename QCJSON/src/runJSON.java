import org.quickconnectfamily.json.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Used to show happy paths and nasty paths of examples
 * Created by MattinAction on 10/21/16.
 */
public class runJSON {
    public static void main (String args[]){
        // Happy Path: Object to JSON String
        // Result: The object is translated into a JSON String
        studentsDemo toTest = new studentsDemo("Charles", 24, "Sophomore");

        try{
            String jsonString = JSONUtilities.stringify(toTest);
            System.out.println("From Object: ");
            System.out.println("\t" + jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Happy Path: JSON String to Object
        // Result: The string is converted, to an instance of the studentDemo object

        try {
            // Hard coding the JSON string that will be parsed into an object
            String jsonString2 = "{\"studentName\":\"Harold\",\"studentAge\":22,\"studentClass\":\"Freshman\"}";

            // Creating a hashmap that will be passed to the object
            HashMap toStudent = ((HashMap) JSONUtilities.parse(jsonString2));

            // Creating the instance of the studentsDemo object
            studentsDemo fromJSONString = new studentsDemo(toStudent);

            // Showing the results
            System.out.println("From String: ");
            System.out.println("\t" + fromJSONString);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Happy Path: Array of objects -> JSON String
        // Result: A JSON string is created but it leaves me with more questions than answers.

        // Creating the various objects
        studentsDemo student1 = new studentsDemo("Hank", 22, "Sophomore");
        studentsDemo student2 = new studentsDemo("Bob", 25, "Junior");
        studentsDemo student3 = new studentsDemo("Matt", 25, "Senior");

        // Creating and loading the array of objects
        ArrayList<studentsDemo> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);

        System.out.println("Loaded array of students:");
        System.out.println("\t" + students);

        // Stringify the array of objects
        try {
            String jsonString = JSONUtilities.stringify(students);
            System.out.println("From array of objects:");
            System.out.println("\t" + jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
        }



        // Happy Path: JSON String with array of objects -> Array of objects
        // Result: The objects are available with the arrayList, but it doesn't allow for instancing

        try {
            // The basic string to work with it is an array of objects within the JSON string
            String stringIn = "[{\"studentName\":\"Hank\",\"studentAge\":22,\"studentClass\":\"Sophomore\"},{\"studentName\":\"Bob\",\"studentAge\":25,\"studentClass\":\"Junior\"},{\"studentName\":\"Matt\",\"studentAge\":25,\"studentClass\":\"Senior\"}]";

            // Parsing the JSON string
            ArrayList fromArray = ((ArrayList) JSONUtilities.parse(stringIn));
            System.out.println("fromArray: ");
            System.out.println("\t" + fromArray);

            // Setting up the counter to name each of the objects

            // Looping through the ArrayList to create the objects
            for (Object a : fromArray) {
                studentsDemo aStudent  = new studentsDemo((HashMap) a);
                System.out.println(aStudent.getStudentName());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        // Happy Path: Writing a JSON string to a file
        // Result: If no file exists, it is created, and then the string is written to the file.

        File aFile = new File("test.json");
        try {
            //Creating an instance that will be passed to the file
            studentsDemo aStudent = new studentsDemo("Charles", 24, "Sophomore");

            FileOutputStream aFileStream = new FileOutputStream(aFile);
            JSONOutputStream jsonOut = new JSONOutputStream(aFileStream);
            jsonOut.writeObject(aStudent);
            jsonOut.close();
            System.out.println("Writing process complete!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Happy Path: Reading from file with JSONInputStream
        // Result: JSON string is read from the file creates an instance of the object

        try {
            FileInputStream aFileStream = new FileInputStream(aFile);
            JSONInputStream objectIn = new JSONInputStream(aFileStream);
            HashMap newStudent = ((HashMap) objectIn.readObject());
            studentsDemo newStudent1 = new studentsDemo(newStudent);
            objectIn.close();

            System.out.println("From file: ");
            System.out.println("\t" + newStudent1);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        // Nasty Path: Give Stringify null
        // Result: Processes the stringify normally and will display null
        try {
            String jsonString = JSONUtilities.stringify(null);
            System.out.println("Nasty Path: Give Stringify null");
            System.out.println("\t" + jsonString);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Nasty Path: Give Stringify a different datatype (integer)
        // Result: Processes the stringify normally and will display the integer
        try {
            int dogCrap = 3;
            String jsonString = JSONUtilities.stringify(dogCrap);
            System.out.println("Nasty Path: Give Stringify an integer");
            System.out.println("\t" + jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Nasty Path: Give JSON Parser an empty string
        // Result: Returns "Unexpected token END OF FILE" error.

        try {
            // Hard coding the JSON string that will be parsed into an object
            String jsonString2 = "";

            // Creating a hashmap that will be passed to the object
            HashMap toStudent = null;

            toStudent = ((HashMap) JSONUtilities.parse(jsonString2));

            // Creating the instance of the studentsDemo object
            studentsDemo fromJSONString = new studentsDemo(toStudent);

            // Showing the results
            System.out.println("Nasty Path: Empty String ");
            System.out.println("\t" + fromJSONString);

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Nasty Path: Passing JSON Parser null
        // Result: Null pointer exception
        try {
            // Creating a hashmap that will be passed to the object
            HashMap toStudent = null;

            toStudent = ((HashMap) JSONUtilities.parse(null));

            // Creating the instance of the studentsDemo object
            studentsDemo fromJSONString = new studentsDemo(toStudent);

            // Showing the results
            System.out.println("Nasty Path: Null ");
            System.out.println("\t" + fromJSONString);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Nasty Path: Writing to an file that doesn't have write permissions
        // Result: Did not write to the file, but did not throw an error
        File bFile = new File("permTest.json");
        try {
            //Creating an instance that will be passed to the file
            studentsDemo aStudent = new studentsDemo("Charles", 24, "Sophomore");

            FileOutputStream aFileStream = new FileOutputStream(bFile);
            JSONOutputStream jsonOut = new JSONOutputStream(aFileStream);
            jsonOut.writeObject(aStudent);
            jsonOut.close();
            System.out.println("Write to file w/o permissions complete!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Nasty Path: Reading from a file that doesn't exist
        // Result: No output was shown, but no exceptions were thrown?!
        File cFile = new File("nonTest.json");
        try {
            FileInputStream aFileStream = new FileInputStream(cFile);
            JSONInputStream objectIn = new JSONInputStream(aFileStream);
            HashMap newStudent = ((HashMap) objectIn.readObject());
            studentsDemo newStudent1 = new studentsDemo(newStudent);
            objectIn.close();

            System.out.println("From file that doesn't exist: ");
            System.out.println("\t" + newStudent1);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Nasty Path: Reading from a file that doesn't have read permissions
        // Result: Object was not read from file, but no exception was thrown
        try {
            FileInputStream aFileStream = new FileInputStream(bFile);
            JSONInputStream objectIn = new JSONInputStream(aFileStream);
            HashMap newStudent = ((HashMap) objectIn.readObject());
            studentsDemo newStudent1 = new studentsDemo(newStudent);
            objectIn.close();

            System.out.println("From file w/o permissions: ");
            System.out.println("\t" + newStudent1);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Nasty Path: Trying to read a jpg
        // Result: Unexpected character at position 0 exception
        File mattPic = new File("mattPic.jpg");
        try {
            FileInputStream aFileStream = new FileInputStream(mattPic);
            JSONInputStream objectIn = new JSONInputStream(aFileStream);
            HashMap newStudent = ((HashMap) objectIn.readObject());
            studentsDemo newStudent1 = new studentsDemo(newStudent);
            objectIn.close();

            System.out.println("From picture: ");
            System.out.println("\t" + newStudent1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        // Nasty Path: Reading for more objects than have been written
        // Result: Unexpected token END OF FILE.
        try{
            // Writing three objects to the file
            FileOutputStream aFileStream = new FileOutputStream(aFile);
            JSONOutputStream jsonOut = new JSONOutputStream(aFileStream);
            jsonOut.writeObject(student1);
            jsonOut.writeObject(student2);
            jsonOut.writeObject(student3);
            jsonOut.close();
            System.out.println("Writing process complete!");

            // Reading 4 objects from the file
            FileInputStream aFileIPStream = new FileInputStream(aFile);
            JSONInputStream objectIn = new JSONInputStream(aFileIPStream);
            HashMap newStudent1 = ((HashMap) objectIn.readObject());
            HashMap newStudent2 = ((HashMap) objectIn.readObject());
            HashMap newStudent3 = ((HashMap) objectIn.readObject());
            HashMap newStudent4 = ((HashMap) objectIn.readObject());
            objectIn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}

class studentsDemo implements Serializable{
    private String studentName;
    private long studentAge;
    private String studentClass;

    public studentsDemo(String aStudentName, int aStudentAge, String aStudentClass){
        this.studentName = aStudentName;
        this.studentAge = aStudentAge;
        this.studentClass = aStudentClass;
    }

    public studentsDemo(HashMap aStudent){
        this.studentName = (String)aStudent.get("studentName");
        this.studentAge = (long)aStudent.get("studentAge");
        this.studentClass = (String)aStudent.get("studentClass");
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentAge() {
        return (int) studentAge;
    }

    public void setStudentAge(long studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    @Override
    public String toString() {
        return "studentsDemo{" +
                "studentName='" + studentName + '\'' +
                ", studentAge=" + studentAge +
                ", studentClass='" + studentClass + '\'' +
                '}';
    }
}
