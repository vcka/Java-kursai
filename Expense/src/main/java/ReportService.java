import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class ReportService {
    private Repository repo = Repository.getRepository();

    public Map<String, Double> calculateMonthlyTotal(){
        Map<String, Double> m = new TreeMap<>();
        for (Expense expense : repo.getExpenseList()) {
            Date expDate = expense.getDate();
            String yearMonth = DateUtil.getYearAndMonth(expDate);
            if (m.containsKey(yearMonth)){
                //then expense is all ready present for a month
                Double total =  m.get(yearMonth);
                total = total + expense.getAmount();
                m.put(yearMonth, total);
            }else {
                //this month is not added, add here
                m.put(yearMonth, expense.getAmount());
            }
        }
        return m;
    }

    public Map<Integer, Double>  calculateYearlyTotal(){
        Map<Integer, Double> m = new TreeMap<>();
        for (Expense expense : repo.getExpenseList()) {
            Date expDate = expense.getDate();
            Integer year = DateUtil.getYear(expDate);
            if (m.containsKey(year)){
                //then expense is all ready present for a year
                Double total =  m.get(year);
                total = total + expense.getAmount();
                m.put(year, total);
            }else {
                //this year is not added, add here
                m.put(year, expense.getAmount());
            }
        }
        return m;
    }

    public Map<String, Double> calculateCategoriesTotal(){
        Map<String, Double> m = new TreeMap<>();
        for (Expense expense : repo.getExpenseList()) {
            Long categoryID= expense.getCategoryId();
            String categoryName = getCategoryNameByID(categoryID);
            if (m.containsKey(categoryName)){
                //then expense is all ready present for a category
                Double total =  m.get(categoryName);
                total = total + expense.getAmount();
                m.put(categoryName, total);
            }else {
                //this category is not added, add here
                m.put(categoryName, expense.getAmount());
            }
        }
        return m;
    }
    public String getCategoryNameByID(Long categoryId) {
        for (Category c : repo.getCategoryList()) {
            if (c.getCategoryId().equals(categoryId)) {
                return c.getName();
            }
        }
        return null;
    }
}
