package Entities;

import java.util.List;

public class Product {
    private String name;
    private double price;
    private List<ProductTypes> types;
    private int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<ProductTypes> getTypes() {
        return types;
    }

    public void setTypes(List<ProductTypes> types) {
        this.types = types;
    }
}
