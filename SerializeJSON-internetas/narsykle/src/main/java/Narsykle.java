import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Narsykle {
    public static void main(String[] args) throws IOException, InterruptedException {
        ObjectMapper om = new ObjectMapper();
//        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        File file = new File("internetas/uzklausa.json");
        File fileWait = new File("internetas/atsakymas.json");
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Iveskite imones koda: ");
            String imonesKodas = sc.next();
            Uzklausa uzklausa = new Uzklausa(imonesKodas);
            om.writeValue(file, uzklausa);

            do {
                Thread.sleep(1000);
            } while (!fileWait.exists());

            Atsakymas atsakymas = om.readValue(fileWait, Atsakymas.class);
            System.out.println(atsakymas);
            fileWait.delete();

        }
    }
}
