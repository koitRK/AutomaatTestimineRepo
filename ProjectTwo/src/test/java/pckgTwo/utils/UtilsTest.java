package pckgTwo.utils;

import pckgTwo.Student;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;


public class UtilsTest {

    @Test
    public void utils_printStudentNames_should_print_full_names(){
        //student objects not mocked because they are data classes and have no logic.
        Student student1 = new Student("Jaan", "Tamm", null, null);
        Student student2 = new Student("John", "Smith", null, null);

        ArrayList<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Utils.printStudentsNames(students);

        assertEquals("Jaan Tamm\r\nJohn Smith\r\n", String.valueOf(outContent));
    }

    @Test
    public void utils_no_students_printStudentNames_should_print_nothing(){
        ArrayList<Student> students = new ArrayList<>();

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Utils.printStudentsNames(students);

        assertEquals("", String.valueOf(outContent));
    }
}
