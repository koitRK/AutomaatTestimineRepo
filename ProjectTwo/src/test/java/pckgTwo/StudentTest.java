package pckgTwo;

import org.junit.jupiter.api.Test;
import pckgTwo.Course;
import pckgTwo.Student;
import pckgTwo.Teacher;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StudentTest {

    @Test
    public void student_getTeacherNames_should_return_list_of_full_names() {
        //teacher and course objects not mocked because they are data classes and have no logic.
        Teacher teacher1 = new Teacher("Milvi", "Tisler", null);
        Teacher teacher2 = new Teacher("Liina", "Lindsalu", null);
        Course course1 = new Course(null, null, null, null, null, teacher1);
        Course course2 = new Course(null, null, null, null, null, teacher2);

        List<Course> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);
        Student student = new Student("John", "Smith", null, courses);

        List<String> result = student.getTeachersNames();
        assertEquals(Arrays.asList("Milvi Tisler", "Liina Lindsalu"), result);
    }

    @Test
    public void student_without_courses_getTeacherNames_should_return_empty_list() {
        List<Course> courses = new ArrayList<>();
        Student student = new Student("John", "Smith", null, courses);

        List<String> result = student.getTeachersNames();
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void student_sayHello_should_greet_student() {
        Student student = new Student("John", "Smith", null, null);

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        student.sayHello();
        assertEquals("Hello, student John Smith\r\n", String.valueOf(outContent));
    }
}