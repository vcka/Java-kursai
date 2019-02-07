package penkisimtai;

import com.github.javafaker.Faker;
import org.ajbrown.namemachine.Gender;
import org.ajbrown.namemachine.Name;
import org.ajbrown.namemachine.NameGenerator;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        if(args.length == 0) {
            Process p = Runtime.getRuntime().exec("cmd.exe /c start java -jar " + (new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath())).getAbsolutePath() + " cmd");
        }

        Faker faker = new Faker();
        for(int i = 0; i <100; i++){
            System.out.println(faker.chuckNorris().fact());
        }

        System.out.println("------------------------------------");
        for(int i = 0; i <100; i++){
            System.out.println(faker.dragonBall().character());
        }

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

    }
}
