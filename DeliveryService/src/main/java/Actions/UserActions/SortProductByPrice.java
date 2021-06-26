package Actions.UserActions;

import Entities.Product;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortProductByPrice {
    public static void SortByPrice(List<Product> products) {
        System.out.println("Before sorting");
        products.forEach(product -> System.out.println((products.indexOf(product) + 1) + ". Name" + product.getName()
                + "| Price: " + product.getPrice() + "| Types: " + product.getTypes().toString()));

        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if(o1.getPrice() > o2.getPrice())return 1;
                else if (o1.getPrice() < o2.getPrice())return -1;
                else return 0;
            }
        });

        System.out.println("After sorting");
        products.forEach(product -> System.out.println((products.indexOf(product) + 1) + ". Name" + product.getName()
                + "| Price: " + product.getPrice() + "| Types: " + product.getTypes().toString()));
    }
}
