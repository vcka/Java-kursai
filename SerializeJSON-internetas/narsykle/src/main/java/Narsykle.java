import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Narsykle {
    public static void main(String[] args) throws IOException, InterruptedException {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Iveskite imones koda: ");
            String imonesKodas = sc.nextLine();
            sc.close();
            Uzklausa uzklausa = new Uzklausa(imonesKodas);
            ObjectMapper om = new ObjectMapper();
            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            File file = new File("internetas/uzklausa.json");
            om.writeValue(file, uzklausa);

            File fileWait = new File("internetas/atsakymas.json");

            do {
                Thread.sleep(1000);
            } while (!fileWait.exists());

            Atsakymas atsakymas = om.readValue(fileWait, Atsakymas.class);
            System.out.println(atsakymas);
            fileWait.delete();
        }
    }
}
