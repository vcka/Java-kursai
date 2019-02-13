import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class Serveris {
    public static void main(String[] args) throws IOException, InterruptedException {
        final Logger logger = LogManager.getRootLogger();
        while (true) {
            ObjectMapper om = new ObjectMapper();
            File imones = new File("internetas/imones.json");
            final List<Atsakymas> atsakymas = om.readValue(imones, new TypeReference<List<Atsakymas>>() {
            });

            File fileWait = new File("internetas/uzklausa.json");

            do {
                Thread.sleep(1000);
            } while (!fileWait.exists());

            Uzklausa uzklausa = om.readValue(fileWait, Uzklausa.class);
            logger.info("Imones kodo uzklausa: " + uzklausa.getImonesKodas());
            fileWait.delete();
            Atsakymas siusti = atsakymas.stream()
                    .filter(request -> request.getImonesKodas().equals(uzklausa.getImonesKodas()))
                    .findAny()
                    .orElse(null);
            File fileWrite = new File("internetas/atsakymas.json");
            om.writeValue(fileWrite, siusti);
        }
    }
}
