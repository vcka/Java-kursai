import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest extends FizzBuzz {

    @Test
    void fizzBuzzTest() {
        final List<Object> objects = fizzBuzz(15);
        assertEquals("Fizz", objects.get(2));
        assertEquals("FizzBuzz", objects.get(14));
    }
}