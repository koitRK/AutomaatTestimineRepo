package pckgTwo;

public class Student {
    String lastName;
    String firstName;
    Long birthDate;
    Course course;

    public Student(String inLastName, String inFirstName, Long inBirthDate, Course inCourse){
        this.lastName  = inLastName;
        this.firstName = inFirstName;
        this.birthDate = inBirthDate;
        this.course = inCourse;
    }
}