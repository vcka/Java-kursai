import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class LithuanianOfficialIdProviderTest {

    @Test
    void testIdProvider_maleGenderStartsWith3(){
        LithuanianOfficialIdProvider idProvider = new LithuanianOfficialIdProvider();
        Person aaaa = new Person("aaaa", LocalDate.now(), Gender.MALE);
        String s = idProvider.generateOfficialId(aaaa);
        assertEquals('3', s.charAt(0));
    }

    @Test
    void testIdProvider_femaleGenderStartsWith4(){
        LithuanianOfficialIdProvider idProvider = new LithuanianOfficialIdProvider();
        LocalDate now = LocalDate.now();
        int checkDate = now.getYear();
        Person aaaa = new Person("aaaa", now, Gender.FEMALE);
        String s = idProvider.generateOfficialId(aaaa);
        assertEquals('4', s.charAt(0));
    }

    @Test
    void testIdProvider_femaleGenderCheckYear(){
        LithuanianOfficialIdProvider idProvider = new LithuanianOfficialIdProvider();
        LocalDate now = LocalDate.now();
        String checkDate = Integer.toString(now.getYear() % 100);
        Person aaaa = new Person("aaaa", now, Gender.FEMALE);
        String s = idProvider.generateOfficialId(aaaa);
        assertEquals(checkDate, s.substring(1,3));
    }
}