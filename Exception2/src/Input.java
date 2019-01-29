import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    static void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Iveskite sveika skaiciu:");
        try {
            int sk = scanner.nextInt();
            System.out.println("Jus ivedete: "+sk);
        } catch (InputMismatchException ime) {
            System.out.println("Neteisingas skaicius, bandykite dar karta");
            input();
        } finally {
            scanner.close();
        }
    }
}
