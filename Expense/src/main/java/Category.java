import java.io.Serializable;

public class Category implements Serializable {
    private Long categoryId = System.currentTimeMillis();
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }
}
