import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        Files.writeString(Path.of("string"),"|_\n_|\n".repeat(5).lines().collect(Collectors.joining("\n")));
        System.out.println("|_\n_|\n".repeat(5));
    }
}
