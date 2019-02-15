import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Repository {
    private List<Expense> expenseList = new ArrayList<>();
    private List<Category> categoryList = new ArrayList<>();
    private static Repository repository;

    private Repository(){
    }

    public static Repository getRepository(){
        if (repository==null){
            repository = new Repository();
        }
        return repository;
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public void setExpenseList(List<Expense> expenseList) {
        this.expenseList = expenseList;
    }

    public void categorySave() throws IOException {
        FileOutputStream fos = new FileOutputStream("Categories.db");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(categoryList);
        oos.close();
    }

    public void categoryLoad() throws IOException {
        FileInputStream fis = new FileInputStream("Categories.db");
        ObjectInputStream ois = new ObjectInputStream(fis);
        try {
            setCategoryList((List<Category>) ois.readObject());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ois.close();
    }

    public void expenseSave() throws IOException {
        FileOutputStream fos = new FileOutputStream("Expenses.db");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(expenseList);
        oos.close();
    }

    public void expenseLoad() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("Expenses.db");
        ObjectInputStream ois = new ObjectInputStream(fis);
        setExpenseList((List<Expense>) ois.readObject());
        ois.close();
    }
}
