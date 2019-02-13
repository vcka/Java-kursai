import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Imone> imones = new ArrayList<>();
        Faker faker = new Faker();
        for (int i = 0; i < 100; i++){
            imones.add(new Imone(faker.company().name(), faker.code().asin(),faker.number().numberBetween(50,500), faker.number().numberBetween(500,3000)));
        }
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("imones.json");
        mapper.writeValue(file, imones);
    }
}
