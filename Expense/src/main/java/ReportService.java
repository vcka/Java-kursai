import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ReportService {
    private Repository repo = Repository.getRepository();

    public Map<String, Double> calculateMonthlyTotal() {
        Map<String, Double> map = repo.getExpenseList().stream()
                .collect(Collectors.groupingBy
                        (expense -> DateUtil.getYearAndMonth(expense.getDate()),
                                Collectors.summingDouble(Expense::getAmount)));

//Old method
//        Map<String, Double> m = new TreeMap<>();
//        for (Expense expense : repo.getExpenseList()) {
//            Date expDate = expense.getDate();
//            String yearMonth = DateUtil.getYearAndMonth(expDate);
//            if (m.containsKey(yearMonth)){
//                //then expense is all ready present for a month
//                Double total =  m.get(yearMonth);
//                total = total + expense.getAmount();
//                m.put(yearMonth, total);
//            }else {
//                //this month is not added, add here
//                m.put(yearMonth, expense.getAmount());
//            }
//        }
        return new TreeMap<>(map);
    }

    public Map<Integer, Double> calculateYearlyTotal() {
        Map<Integer, Double> map = repo.getExpenseList().stream()
                .collect(Collectors.groupingBy
                        (expense -> DateUtil.getYear(expense.getDate()),
                                Collectors.summingDouble(Expense::getAmount)));

//Old method
//        Map<Integer, Double> m = new TreeMap<>();
//        for (Expense expense : repo.getExpenseList()) {
//            Date expDate = expense.getDate();
//            Integer year = DateUtil.getYear(expDate);
//            if (m.containsKey(year)) {
//                //then expense is all ready present for a year
//                Double total = m.get(year);
//                total = total + expense.getAmount();
//                m.put(year, total);
//            } else {
//                //this year is not added, add here
//                m.put(year, expense.getAmount());
//            }
//        }
        return new TreeMap<>(map);
    }

    public Map<String, Double> calculateCategoriesTotal() {
        Map<String, Double> map = repo.getExpenseList().stream()
                .collect(Collectors.groupingBy
                        (expense -> getCategoryNameByID(expense.getCategoryId()),
                                Collectors.summingDouble(Expense::getAmount)));

//Old method
//        Map<String, Double> m = new TreeMap<>();
//        for (Expense expense : repo.getExpenseList()) {
//            Long categoryID = expense.getCategoryId();
//            String categoryName = getCategoryNameByID(categoryID);
//            if (m.containsKey(categoryName)) {
//                //then expense is all ready present for a category
//                Double total = m.get(categoryName);
//                total = total + expense.getAmount();
//                m.put(categoryName, total);
//            } else {
//                //this category is not added, add here
//                m.put(categoryName, expense.getAmount());
//            }
//        }
        return new TreeMap<>(map);
    }

    public String getCategoryNameByID(Long categoryId) {
//        for (Category c : repo.getCategoryList()) {
//            if (c.getCategoryId().equals(categoryId)) {
//                return c.getName();
//            }
//        }
//        return null;
        return repo.getCategoryList().stream()
                .filter(category -> category.getCategoryId().equals(categoryId))
                .map(Category::getName)
                .collect(Collectors.joining());
    }
}
