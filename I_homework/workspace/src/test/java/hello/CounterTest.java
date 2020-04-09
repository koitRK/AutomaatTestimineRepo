package hello;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class CounterTest 
{
    
    public Counter counter = new Counter();

    @Test
    public void normal_count(){
        int result = counter.countLetters("Test Name");
        assertEquals(9, result);
    }
}
