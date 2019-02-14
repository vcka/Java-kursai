import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class characterCounterTest extends characterCounter {

    @Test
    void checkerTest() {
        List<Character> chars = Arrays.asList('a', 'a', 'a', 'b', 'b');
        final Map<Character, Long> checker = checker(chars);
        assertEquals(3, checker.get('a'));
        assertEquals(2, checker.size());
    }
}