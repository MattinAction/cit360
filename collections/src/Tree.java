import java.util.*;
/**
 * Created by MattinAction on 9/30/16.
 * Teaching Experiences: Worked with Karlee and Matt's team to discuss happy/nasty paths 10/4/2016
 *
 */
public class Tree {
    public static void runTree() {
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

        try {
            // Nasty Path: adding null to treeset
            // Result: Runtime NullPointerException
            numbers.add(null);
            System.out.println("Nasty Path: Adding null to treeset");
            System.out.println("\t" + numbers + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // explore comparitors for sorting
        TreeSet<Student> nameComp = new TreeSet<>(new myNameComp());
        nameComp.add(new Student("Carlee", "Senior"));
        nameComp.add(new Student("Lee", "Professor"));
        nameComp.add(new Student("Matt", "Junior"));
        nameComp.add(new Student("Kenny", "Freshman"));

        for (Student s :nameComp) {
            System.out.println(s);
        }

        //For spacing
        System.out.println("+++++++++++++++++++++++++++++++++++");

        TreeSet<Student> gradeComp = new TreeSet<>(new myGradeComp());
        gradeComp.add(new Student("Carlee", "Senior"));
        gradeComp.add(new Student("Lee", "Professor"));
        gradeComp.add(new Student("Matt", "Junior"));
        gradeComp.add(new Student("Kenny", "Freshman"));

        for (Student s :gradeComp) {
            System.out.println(s);
        }
    }

    static class myNameComp implements Comparator<Student>{

        @Override
        public int compare(Student s1, Student s2){
            return s1.getName().compareTo(s2.getName());
        }
    }

    static class myGradeComp implements Comparator<Student> {

        @Override
        public int compare(Student s1, Student s2) {
            return s1.getGrade().compareTo(s2.getGrade());
        }
    }

    static class Student{

        private String name;
        private String grade;

        public Student (String n, String g){
            this.name = n;
            this.grade = g;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        public String toString(){
            return "Name: " + this.name + " -> Grade: " + this.grade;
        }

    }

}
