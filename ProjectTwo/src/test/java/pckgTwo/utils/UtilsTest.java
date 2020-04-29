package pckgTwo.utils;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.mockito.MockitoAnnotations;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import pckgTwo.Student;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class UtilsTest {

    @Mock
    private Student studentMock1;
    @Mock
    private Student studentMock2;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void utils_printStudentNames_should_print_full_names(){
        when(studentMock1.getFullName()).thenReturn("Jaan Tamm");
        when(studentMock2.getFullName()).thenReturn("John Smith");
        ArrayList<Student> students = new ArrayList<>();
        students.add(studentMock1);
        students.add(studentMock2);

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Utils.printStudentsNames(students);

        assertEquals("Jaan Tamm\r\nJohn Smith\r\n", String.valueOf(outContent));
    }
}
