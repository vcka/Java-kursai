import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

class DateUtilTest {
    @Test
    void dateToStringTest() throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy MM dd");
        assertEquals("2019 02 01", DateUtil.dateToString(df.parse("2019 02 01")));
    }

    @Test
    void stringToDateTest() throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy MM dd");
        assertEquals(df.parse("2019 01 01"), DateUtil.stringToDate("2019 01 01"));
    }
}