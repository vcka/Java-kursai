import com.github.javafaker.Faker;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        if(args.length == 0) {
            Process p = Runtime.getRuntime().exec("cmd.exe /c start java -jar " + (new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath())).getAbsolutePath() + " cmd");
        }
        Scanner sc = new Scanner(System.in);
        Faker faker = new Faker();
        String description = faker.weather().description();
        System.out.println(description);
        sc.nextLine();
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        sc.nextLine();
    }

}
