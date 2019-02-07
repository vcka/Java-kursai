import org.ajbrown.namemachine.Gender;
import org.ajbrown.namemachine.Name;
import org.ajbrown.namemachine.NameGenerator;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        if(args.length == 0) {
            Process p = Runtime.getRuntime().exec("cmd.exe /c start java -jar " + (new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath())).getAbsolutePath() + " cmd");
        } else {
            //code to be executed
        }
        NameGenerator generator = new NameGenerator();

// generate 1000 female names
        List<Name> names = generator.generateNames( 1000, Gender.FEMALE );


// generate 5000 male and female names.
        names.forEach(System.out::println);

    }
}
