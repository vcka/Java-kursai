import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class FizzBuzz {
    public List<String> fizzBuzz(Integer i) {
        return IntStream.rangeClosed(1, i)
                .mapToObj(Integer::valueOf)
                .map(integer -> {
                    if (integer % 3 == 0 && integer % 5 == 0) {
                        return "FizzBuzz";
                    } else {
                        if (integer % 3 == 0) {
                            return "Fizz";
                        } else {
                            if (integer % 5 == 0) {
                                return "Buzz";
                            }
                        }
                    }
                    return integer.toString();
                })
                .collect(Collectors.toList());
    }

    public static String fizzBuzz2(int i) {
        return IntStream.rangeClosed(1, i)
                .mapToObj(number -> number % 3 == 0 ? (number % 5 == 0 ? "FizzBuzz" : "Fizz") : (number % 5 == 0 ? "Buzz" : String.valueOf(number)))
                .collect(Collectors.joining(","));
    }
}
