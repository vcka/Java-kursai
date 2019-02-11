import org.apache.commons.codec.digest.DigestUtils;

import javax.swing.*;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            Process p = Runtime.getRuntime().exec("cmd.exe /c start java -jar " + (new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath())).getAbsolutePath() + " cmd");
        }
        Scanner sc = new Scanner(System.in);
//
//        LanguageDetector detector = LanguageDetectorBuilder.fromAllBuiltInLanguages().build();
//        int counter = 0;
//        do {
//            System.out.println("Ka nors iveskite.");
//            counter++;
//            System.out.println(detector.detectLanguageOf(sc.nextLine()));
//        }while (counter<=10);
        String sha256hex = DigestUtils.sha256Hex("tekstas");
        String a = DigestUtils.sha256Hex("tekstas");
        System.out.println(sha256hex.equals(a));
        Console cons;
        char[] passwd;
        if ((cons = System.console()) != null && (passwd = cons.readPassword("[%s]", "Password:")) != null) {
            System.out.println(passwd);
            java.util.Arrays.fill(passwd, ' ');
        }
        sc.nextLine();


        final String password, message = "Enter password";
        if( System.console() == null )
        { // inside IDE like Eclipse or NetBeans
            final JPasswordField pf = new JPasswordField();
            password = JOptionPane.showConfirmDialog( null, pf, message,
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE ) == JOptionPane.OK_OPTION ?
                    new String( pf.getPassword() ) : "";
        }
        else
            password = new String( System.console().readPassword( "%s> ", message ) );

    }
}
