package samplearrays;

public class CourseNumbersArray {

    //Add new course number
    public static int[] addCourse(int courseNumber,int[] coursesArray){
        if(checkCourseNumber(courseNumber,coursesArray)){
            System.out.println("This course already exists");
            return null;
        }
        int arrayLength= coursesArray.length +1; //the length of the new array
        int updatedCourses[];
        updatedCourses=new int[arrayLength]; //the new array
        int count=0; //counter so i can copy each course number from the original array
        for(int i:coursesArray){
            updatedCourses[count]=i; //copy the elements
            count+=1; //pass to next index
        }
        updatedCourses[arrayLength-1]=courseNumber; //the last element of the new array will be the updated Courses
        coursesArray=updatedCourses;
        return coursesArray;
    }

    //Print the contents of updatedCourses
    public static void printUpdatedCourse(int[] updatedCourses){
        System.out.print("[ ");
        for(int i : updatedCourses){ //print all the lements of the updated courses
            System.out.print(i+", ");
        }
        System.out.print("]");
    }

    //chack if updated courses contains a specific course number
    public static boolean checkCourseNumber(int courseNumber,int[] updatedCourses){
        for(int i : updatedCourses){
            if(i==courseNumber){ //check if any element of updated courses containd=s the course number
                return true; //if yes return true
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};
        registeredCourses=CourseNumbersArray.addCourse(100,registeredCourses); //add course number 100 to registred courses
        CourseNumbersArray.printUpdatedCourse(registeredCourses);

    }

}
