package pckgTwo;

import org.junit.jupiter.api.Test;
import pckgTwo.utils.Utils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class PersonImplTest {

    @Test
    void personImpl_sayHello_should_greet_person() {
        PersonImpl personImpl = new PersonImpl("Jaan", "Tamm", LocalDate.of(2020, 1, 1));

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        personImpl.sayHello();

        assertEquals("Hello, person Jaan Tamm\r\n", String.valueOf(outContent));
    }
}