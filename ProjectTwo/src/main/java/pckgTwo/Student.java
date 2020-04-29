package pckgTwo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Student extends PersonImpl{

    private List<Course> courses;

    public Student(String firstName, String lastName, LocalDate dateOfBirth, List<Course> courses) {
        super(firstName, lastName, dateOfBirth);
        this.courses = courses;
    }

    @Override
    public void sayHello() {
        System.out.println(String.format("Hello, student %s", getFullName()));
    }


    public List<String> getTeachersNames(){
        List<String> names = new ArrayList<>();
        for (Course course : courses){
            names.add(course.getTeacher().getFullName());
        }
        return names;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(List<Course> course) {
        this.courses.add((Course) course);
    }
}