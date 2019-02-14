import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IntegerLToStringLTest extends IntegerLToStringL {

    @Test
    void getIntegersToString() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertEquals("1o,2e,3o,4e,5o,6e", getIntegersToString(integerList), "1o,2e,3o,4e,5o,6e");
    }
}