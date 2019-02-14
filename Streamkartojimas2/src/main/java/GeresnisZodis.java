import java.util.function.BiPredicate;

public class GeresnisZodis {
//
//    public String geresnisZodis(String pirmasZodis, String antrasZodis, BiPredicate<String, String> biPredicate) {
//        biPredicate = (pirmasZodi, antrasZodi) -> pirmasZodis.length() > antrasZodis.length();
//    }

    public boolean compare(BiPredicate<String, String> bi, String i1,
                                  String i2) {
        return bi.test(i1, i2);
    }
}
