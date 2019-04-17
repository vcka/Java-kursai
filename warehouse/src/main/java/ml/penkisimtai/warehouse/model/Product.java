package ml.penkisimtai.warehouse.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PRODUCT", uniqueConstraints={@UniqueConstraint(columnNames ={"name","description"})})
public class Product {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
//    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
//    private String id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name may not be blank")
    private String name;

    @NotBlank(message = "Description may not be blank")
    private String description;

    @NotBlank(message = "Type may not be blank")
    private String type;

    @NotBlank(message = "Category may not be blank")
    private String category;

    @NotNull(message = "Price may not be blank")
    private Double price;

    @NotNull(message = "Quantity may not be blank")
    private Integer quantity;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
