package Entities;

import java.util.List;

public class Order {
    private String userName;
    private List<Product> order;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Product> getOrder() {
        return order;
    }

    public void setOrder(List<Product> order) {
        this.order = order;
    }
}
