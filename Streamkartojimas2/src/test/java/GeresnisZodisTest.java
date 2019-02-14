import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GeresnisZodisTest extends GeresnisZodis {

    @Test
    void testCompare() {
       assertTrue(compare((a,b)-> a.length()>b.length(),"Labas vakaras", "Viso gero"));
    }
}