package b2ctest1.com.b2ctest1.model;

/**
 * Created by Amanda on 05/12/2017.
 */

public class Product {
    private int id;
    private String description;
    private Double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return getDescription() + " - Price $" + getPrice();
    }
}
