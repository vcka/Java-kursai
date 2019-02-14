import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest extends FizzBuzz {

    @Test
    void fizzBuzzTest() {
        final List<String > objects = fizzBuzz(15);
        assertEquals("Fizz", objects.get(2));
        assertEquals("FizzBuzz", objects.get(14));
        assertEquals(true,fizzBuzz2(15).contains("FizzBuzz"));
    }
}