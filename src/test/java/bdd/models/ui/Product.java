package bdd.models.ui;


public class Product {

    private String description;
    private String price;
    private Boolean isInStock;

    public Product(String description, String price, Boolean isInStock) {
        this.description = description;
        this.price = price;
        this.isInStock = isInStock;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public Boolean getIsInStock() {
        return isInStock;
    }
}
