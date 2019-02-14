import java.util.List;
import java.util.stream.Collectors;

public class IntegerLToStringL {
    public String getIntegersToString(List<Integer> integerList) {
        return integerList.stream()
                .map(integer -> (integer % 2 == 0) ? integer + "e" : integer + "o")
                .collect(Collectors.joining(","));
    }
}
