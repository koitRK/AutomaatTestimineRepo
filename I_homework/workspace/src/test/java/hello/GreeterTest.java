package hello;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.mockito.MockitoAnnotations;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;


public class GreeterTest 
{
    @Mock
    private Counter counterMock;

    @InjectMocks
    private Greeter greeter = new Greeter();
 
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);        
    }

    @Test
    public void normal_greet(){
        when(counterMock.countLetters("Test Name")).thenReturn(15);

        String result = greeter.sayHello("Test Name");

        assertEquals("Greetings, Test Name, I see you have 15 character(s) in your name!", result);
    }


    @Test
    public void negative_greet(){
        when(counterMock.countLetters("Test Name")).thenReturn(-1);

        String result = greeter.sayHello("Test Name");

        assertEquals("Incorrect name", result);
    }

    @Test
    public void lower_than_min_greet(){
        when(counterMock.countLetters("Test Name")).thenReturn(1);

        String result = greeter.sayHello("Test Name");

        assertEquals("Incorrect name", result);
    }

    @Test
    public void greater_than_max_greet(){
        when(counterMock.countLetters("Test Name")).thenReturn(21);

        String result = greeter.sayHello("Test Name");

        assertEquals("Incorrect name", result);
    }

    @Test
    public void exception_greet(){
        when(counterMock.countLetters("Test Name")).thenThrow(new RuntimeException("Exception"));

        String result = greeter.sayHello("Test Name");

        assertEquals("Caught exception", result);
    }
}