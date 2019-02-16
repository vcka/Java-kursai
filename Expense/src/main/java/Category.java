import java.io.Serializable;

public class Category implements Serializable {
    private Long categoryId = System.currentTimeMillis();
    private String name;

    Category(String name) {
        this.name = name;
        System.out.println("Category created.");
    }

    Long getCategoryId() {
        return categoryId;
    }

    String getName() {
        return name;
    }
}

