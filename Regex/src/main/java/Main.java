import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
        String pattern = "(^|\\s*)([L|l][a-z]*)(\\s*)";
        System.out.println(text.replaceAll(pattern,"$1******$3"));
        System.out.println(text.replaceAll("\\s","\n"));
        String pattern2 = "([,|.])(\\s)";
        System.out.println(text.replaceAll(pattern2, "$1\n"));

        String emailPattern = "([a-zA-Z.\\-]*)([a-zA-Z])(@)([a-zA-Z])([a-zA-Z.\\-]*)([a-zA-Z])";
        System.out.println("vcka.as@ministras.lt".matches(emailPattern));

        String passwords = "tN6WgkPg\n" +
                "eX9qZRwr\n" +
                "nQfMQjJz\n" +
                "eAEwVSfh\n" +
                "vLCnbwXK\n" +
                "HUTCjjfs\n" +
                "bRATtkPw\n" +
                "VxGSzR8y\n" +
                "qYhWYquL\n" +
                "Kk3GajkG\n" +
                "VZ3s2U9v\n" +
                "QGJXQxHc\n" +
                "AA6WZVpA\n" +
                "Cws4xyXz\n" +
                "QeY8p4aX";
        String pwd = "([^|$])(\\n)(^)";
        System.out.println(passwords.replaceAll(pwd, "$1,$3["));
    }
}
