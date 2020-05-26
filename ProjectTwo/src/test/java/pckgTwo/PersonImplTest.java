package pckgTwo;

import org.junit.jupiter.api.Test;
import pckgTwo.PersonImpl;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

class PersonImplTest {

    @Test
    void personImpl_sayHello_should_greet_person() {
        PersonImpl personImpl = new PersonImpl("Jaan", "Tamm", null);

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        personImpl.sayHello();
        assertEquals("Hello, person Jaan Tamm\r\n", String.valueOf(outContent));
    }
}