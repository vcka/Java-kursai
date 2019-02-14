import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class UnicLettersTest extends UnicLetters {

    @Test
    void characters() {
        List<String> a = Arrays.asList("Labas", "Vakaras", "kurmis", "miega");
        List<String> result = Arrays.asList("L", "a", "b", "s", "V", "k", "r", "u", "m", "i", "e", "g");
        assertEquals(result, characters(a));
    }
}