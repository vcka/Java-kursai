import java.io.IOException;
import java.util.Scanner;

public class MenuUtils {
    private PEMService pemService = new PEMService();
    private static Scanner in = new Scanner(System.in);
    private int choice;

    private void printMenu() throws IOException, InterruptedException {
        System.out.println("------------Menu-----------");
        System.out.println("1. Add category");
        System.out.println("2. Category list");
        System.out.println("3. Expense entry");
        System.out.println("4. Expense list");
        System.out.println("5. Monthly expense list");
        System.out.println("6. Yearly expense list");
        System.out.println("7. Categorized expense list");
        System.out.println("8. Delete expense by nr");
        System.out.println("9. Delete category by nr");
        System.out.println("0. Exit");
        System.out.println("---------------------------");
        System.out.println("Enter your choice: ");
        checkInput(in.nextLine());
    }

    static void pressAnyEnterToContinue() {
        System.out.println("Press enter to continue...");
        in.nextLine();
    }

    private void onExit() {
        try {
            pemService.getRepo().categorySave();
            pemService.getRepo().expenseSave();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    public void showMenu() throws IOException, InterruptedException {
        try {
            pemService.getRepo().categoryLoad();
            pemService.getRepo().expenseLoad();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No data loaded.");
        }

        while (true) {
            printMenu();
            switch (choice) {
                case 1:
                    pemService.onAddCategory();
                    pressAnyEnterToContinue();
                    clearScreen();
                    break;
                case 2:
                    pemService.onCategoryList();
                    pressAnyEnterToContinue();
                    clearScreen();
                    break;
                case 3:
                    pemService.onExpenseEntry();
                    pressAnyEnterToContinue();
                    clearScreen();
                    break;
                case 4:
                    pemService.onExpenseList();
                    pressAnyEnterToContinue();
                    clearScreen();
                    break;
                case 5:
                    pemService.onMonthlyExpenseList();
                    pressAnyEnterToContinue();
                    clearScreen();
                    break;
                case 6:
                    pemService.onYearlyExpenseList();
                    pressAnyEnterToContinue();
                    clearScreen();
                    break;
                case 7:
                    pemService.onCategorizedExpenseList();
                    pressAnyEnterToContinue();
                    clearScreen();
                    break;
                case 8:
                    pemService.onExpenseDelete();
                    pressAnyEnterToContinue();
                    clearScreen();
                    break;
                case 9:
                    pemService.onCategoryDelete();
                    pressAnyEnterToContinue();
                    clearScreen();
                    break;
                case 0:
                    onExit();
                    break;
            }
        }
    }
    public void checkInput(String input) throws IOException, InterruptedException {

        if (input.matches("\\d{1}")) {
            choice = Integer.parseInt(input);
        } else {
            System.out.println("Wrong choice, try again.");
            pressAnyEnterToContinue();
            clearScreen();
            printMenu();
        }
    }
    static void clearScreen() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}
