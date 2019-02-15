import java.io.IOException;
import java.util.*;

public class PEMService {
    private Repository repo = Repository.getRepository();
    private ReportService reportService = new ReportService();
    private Scanner in = new Scanner(System.in);

    void onCategorizedExpenseList() {
        System.out.println("Categorized expense list");
        Map<String, Double> resultMap = reportService.calculateCategoriesTotal();
        Set<String> categories = resultMap.keySet();
        Double total = 0.0D;
        for (String categoryName : categories) {
            total = resultMap.get(categoryName) + total;
            System.out.println(categoryName + " : " + resultMap.get(categoryName));
        }
        System.out.println("Category total: " + total);

    }

    void onYearlyExpenseList() {
        System.out.println("Yearly expense list");
        Map<Integer, Double> resultMap = reportService.calculateYearlyTotal();
        Set<Integer> years = resultMap.keySet();
        Double total = 0.0D;
        for (Integer year : years) {
            total += resultMap.get(year);
            System.out.println(year + " : " + resultMap.get(year));
        }
        System.out.println("All times total: " + total);
    }

    void onMonthlyExpenseList() {
        System.out.println("Monthly expense list");
        Map<String, Double> resultMap = reportService.calculateMonthlyTotal();
        Set<String> keys = resultMap.keySet();
        for (String yearMonth : keys) {
            System.out.println(yearMonth + " : " + resultMap.get(yearMonth));
        }
    }

    void onExpenseList() {
        System.out.println("Expense list");
        List<Expense> expenseList = repo.getExpenseList();
        for (int i = 0; i < expenseList.size(); i++) {
            Expense expense = expenseList.get(i);
            String catName = reportService.getCategoryNameByID(expense.getCategoryId());
            String dateString = DateUtil.dateToString(expense.getDate());
            System.out.println((i + 1) + " " + catName + " " + expense.getAmount() + ", " + expense.getRemark() + ", " + dateString + ", " + expense.getCategoryId());
        }
    }

    void onCategoryDelete() throws IOException, InterruptedException {
        onCategoryList();
        System.out.print("Please enter the category to remove: ");
        int nr = checkInput();

        if (nr <= repo.getCategoryList().size()) {
            System.out.println("Category " + repo.getCategoryList().get(nr - 1).getName() + " will be removed.");
            repo.getExpenseList().removeIf(obj -> obj.getCategoryId().equals(repo.getCategoryList().get(nr - 1).getCategoryId()));
            repo.getCategoryList().remove(nr - 1);
        } else {
            System.out.println("No such category.");
            MenuUtils.pressAnyEnterToContinue();
            MenuUtils.clearScreen();
            onCategoryDelete();
        }
    }

    void onExpenseDelete() throws IOException, InterruptedException {
        onExpenseList();
        System.out.print("Please enter the expense to remove: ");
        int nr = checkInput();

        if (nr <= repo.getExpenseList().size()) {
            System.out.println("Expense " + repo.getExpenseList().get(nr - 1).getRemark() + " will be removed.");
            repo.getExpenseList().remove(nr - 1);
        } else {
            System.out.println("No such expense.");
            MenuUtils.pressAnyEnterToContinue();
            MenuUtils.clearScreen();
            onExpenseDelete();
        }
    }


    void onExpenseEntry() throws IOException, InterruptedException {
        System.out.println("Please input expense details...");
        onCategoryList();

        System.out.print("Choose category ");
        int catChoice = checkInput();
        if(catChoice<=repo.getCategoryList().size()) {
            Category selectedCategory = repo.getCategoryList().get(catChoice - 1);
            System.out.println("You chose: " + selectedCategory.getName());

            System.out.print("Please enter the amount: ");
            Double amount = in.nextDouble();
            System.out.print("Please write description: ");
            in.nextLine();
            String remark = in.nextLine();


            System.out.print("Enter date (DD/MM/YYYY): ");
            String dateAsString = in.nextLine();
            Date date = DateUtil.stringToDate(dateAsString);

            Expense expense = new Expense();
            expense.setCategoryId(selectedCategory.getCategoryId());
            expense.setAmount(amount);
            expense.setRemark(remark);
            expense.setDate(date);
            //Store expense
            repo.getExpenseList().add(expense);
            System.out.println("Your expense added.");
        } else {
            System.out.println("No such category.");
            MenuUtils.pressAnyEnterToContinue();
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            onExpenseEntry();
        }
    }

    void onCategoryList() {
        System.out.println("Listing categories");
        List<Category> categoryList = repo.getCategoryList();
        for (int i = 0; i < categoryList.size(); i++) {
            Category c = categoryList.get(i);
            System.out.println((i + 1) + ". " + c.getName() + ", " + c.getCategoryId());
        }
    }

    void onAddCategory() {
//        in.nextLine();//Unu1sed input
        System.out.print("Please name category: ");
        String catName = in.nextLine();
        if (repo.getCategoryList().toString().matches(catName)){
            System.out.println("Category all ready exists.");
        }else {
            Category cat = new Category(catName);
            repo.getCategoryList().add(cat);
            System.out.println("Category created.");
        }
    }

    public Repository getRepo() {
        return repo;
    }
    private int checkInput() {
        String input = in.nextLine();
        if (input.matches("\\d{1}")) {
           return Integer.parseInt(input);
        } else {
            System.out.println("Wrong choice, try again.");
            checkInput();
        }
        return 0;
    }
}
