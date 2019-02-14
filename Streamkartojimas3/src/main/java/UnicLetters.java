import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UnicLetters {
    public List<String> characters(List<String> strings) {
        return strings.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
    }
}
