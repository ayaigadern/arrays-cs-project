package samplearrays;

import java.util.Arrays;
import java.util.Comparator;

public class ManageStudent {

    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students) {
        Student oldest=students[0];
        for(Student student:students){
            if (student.getAge()> oldest.getAge()){
                oldest=student;
            }

        }

        return oldest;
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students) {
        int countAdult=0;
        for(Student student:students){
            if(student.getAge()>=18){
                countAdult+=1;
            }
        }
        return countAdult;

    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students) {
        double averageGrade=0;
        for(Student student:students){
            averageGrade+=student.getGrade();
        }
        averageGrade=(averageGrade*1.0/students.length*1.0);
        return  averageGrade;

    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findStudentByName(Student[] students, String name) {
        for(Student student:students){
            if(student.getName()==name){
                return student;
            }
        }
        System.out.println("Student not found");
        return null;

    }

    // 6) Sort Students by Grade (descending)
    public static void sortByGradeDesc(Student[] students) {
        for(int i=0;i<students.length;i++){
            for(int j=1;j< students.length-i;j++){
                if(students[j].getGrade()>students[j-1].getGrade()){
                    Student a=students[j];
                    students[j]=students[j-1];
                    students[j-1]=a;

                }
            }

        }


    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {
        System.out.print("[ ");
        for(Student student : students){
            if(student.getGrade()>=15){
                System.out.print(student.getName()+", ");
            }

        }
        System.out.print("]");

    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        for(Student student:students){
            if(student.getId()==id){
                student.setGrade(newGrade);
                return true;
            }
        }
        System.out.println("Student not found");
        return false;

    }

    // 9) Find Duplicate Names
    public static boolean hasDuplicateNames(Student[] students) {
        String[] namesArray=new String[students.length];
        int index=0;
        for(Student student : students){
            namesArray[index]=student.getName();
            index+=1;
        }
        for(String name:namesArray){
            int count=0;
            for(String name_:namesArray){
                if (name_==name){
                    count+=1;
                }
            }
            if(count>1){
                System.out.println("Duplicates found");
                return true;
            }

        }
        return false;


    }

    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] appendStudent(Student[] students, Student C) {
        if(Arrays.asList(students).contains(C)){
            System.out.println("Thes student already exists");
            return null;
        }
        int arrayLength= students.length +1; //the length of the new array
        Student updatedStudents[];
        updatedStudents=new Student[arrayLength]; //the new array
        int count=0; //counter so i can copy each course number from the original array
        for(Student i:students){
            updatedStudents[count]=i; //copy the elements
            count+=1; //pass to next index
        }
        updatedStudents[arrayLength-1]=C; //the last element of the new array will be the updated Courses
        students=updatedStudents;
        return students;

    }

    // 1) Create an Array of Students + demos for all tasks
    public static void main(String[] args) {
        // Create & initialize array of 5 students
        Student[] arr = new Student[5];

        // Initialize each element using different constructors
        arr[0] = new Student(1, "John");            // only id & name
        arr[1] = new Student(2, "John", 20);       // id, name, age
        arr[2] = new Student(3, "Michael", 22, 18); // id, name, age, grade
        arr[3] = new Student(4, "Sarah", 19);       // another with 3 args
        arr[4] = new Student(5, "David", 21, 15);   // another with 4 args


        // Print all
        System.out.println("== All Students ==");
        for (Student s : arr) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());

        // 2) Oldest
       System.out.println(findOldest(arr));


        // 3) Count adults
        System.out.println(countAdults(arr));

        // 4) Average grade
        System.out.println(averageGrade(arr));

        // 5) Find by name

        System.out.println(findStudentByName(arr,"John"));
        // 6) Sort by grade desc
        // sort function
        sortByGradeDesc(arr);
        System.out.println("\n== Sorted by grade (desc) ==");
        for (Student s : arr) System.out.println(s);

        // 7) High achievers >= 15
        System.out.println("\nHigh achievers:");
        printHighAchievers(arr);

        // 8) Update grade by id
        // function
        boolean updated=updateGrade(arr,4,20);
        System.out.println("\nUpdated id=4? " + updated);
        System.out.println(findStudentByName(arr, "Dina"));

        // 9) Duplicate names

        System.out.println(hasDuplicateNames(arr));
        // 10) Append new student
        appendStudent(arr,new Student(6,"Alice"));

    }
}

