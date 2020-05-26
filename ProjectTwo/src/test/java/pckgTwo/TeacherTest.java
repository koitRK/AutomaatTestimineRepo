package pckgTwo;

import org.junit.jupiter.api.Test;
import pckgTwo.Teacher;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class TeacherTest {

    @Test
    public void teacher_sayHello_should_greet_teacher() {
        Teacher teacher = new Teacher("Alfred", "Aas", null);

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        teacher.sayHello();
        assertEquals("Hello, teacher Alfred Aas\r\n", String.valueOf(outContent));
    }
}