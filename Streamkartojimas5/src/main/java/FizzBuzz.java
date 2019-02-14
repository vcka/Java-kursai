import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {
    public String fizzBuzz(Integer i) {
        return IntStream.rangeClosed(1, i)
                .mapToObj(Integer::valueOf)
                .map(integer -> (integer % 3 == 0 ) ? "Fizz" : integer.toString())
                .collect(Collectors.joining(","));
    }
}
