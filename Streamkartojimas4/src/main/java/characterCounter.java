import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class characterCounter {
    public Map<Character, Long> checker(List<Character> characterList){
        return characterList.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
    }
}
