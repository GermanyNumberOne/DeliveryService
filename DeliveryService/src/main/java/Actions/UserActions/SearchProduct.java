package Actions.UserActions;

import Actions.Action;
import Constructor.Context;
import Entities.Product;
import Entities.ProductTypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SearchProduct implements Action {
    private Scanner scanner = new Scanner(System.in);
    private Scanner stringScanner = new Scanner(System.in);

    @Override
    public void doAction() {
        if(Context.getService().getShops().size() == 0) {
            System.out.println("There are no shops");
            return;
        }

        System.out.println("Choose the attributes of the product for which you want to start searching:");

        List<Product> products = new ArrayList<>();
        Product template = new Product();
        while(true){
            System.out.print("1.Name\n2.Price\n3.Type\nType your choice: ");
            int choice = scanner.nextInt();

            if(choice < 1 || choice > 3){
                System.out.print("\nWrong number\nDo you want to try again(YES-1 or NO-0)?: ");
                choice = scanner.nextInt();
                if(choice == 1)continue;
                return;
            }

            if(choice == 1){
                System.out.print("Enter product name: ");
                String name = stringScanner.nextLine();
                //SEARCHING PRODUCT BY THAT NAME
                template.setName(name);
                Context.getService().getShops().forEach(shop -> shop.getProducts().forEach(product -> {
                    if (product.getName().equals(name)) {
                        products.add(product);
                    }
                }));
            }
            else if(choice == 2){
                System.out.print("Enter product price: ");
                double price = scanner.nextDouble();
                //SEARCHING PRODUCT BY THAT PRICE
                template.setPrice(price);
                Context.getService().getShops().forEach(shop -> shop.getProducts().forEach(product -> {
                    if(product.getPrice() == price) {
                        products.add(product);
                    }
                }));
            }
            else if(choice == 3){
                System.out.print("Choose product type:\n");
                //OUTPUT PRODUCT TYPES
                Arrays.stream(ProductTypes.values()).collect(Collectors.toList()).forEach(productTypes -> System.out.println(productTypes.getIndex() + ". " + productTypes.toString()));
                int i = scanner.nextInt();
                if(i < 1 || i > ProductTypes.values().length){
                    System.out.print("Wrong number\nDo you want to try again(YES-1 or NO-0)?: ");
                    choice = scanner.nextInt();
                    if(choice == 1)continue;
                    return;
                }
                //SEARCHING PRODUCT BY THAT TYPE
                Context.getService().getShops().forEach(shop -> shop.getProducts().forEach(product -> {
                    if(product.getTypes().contains(ProductTypes.values()[i  - 1])){
                        products.add(product);
                    }
                }));
            }
            System.out.print("Do you want to add more searching attributes(YES-1 or NO-0)?: ");
            choice = scanner.nextInt();
            if(choice == 1)continue;
            break;
        }
        if(products.size() == 0){
            System.out.println("There are no products with such attributes");
            return;
        }
        products.forEach(product -> System.out.println((products.indexOf(product) + 1) + ". Name: " + product.getName()
        + "| Price: " + product.getPrice() + "| Types: " + product.getTypes().toString()));
        //SORTING
        System.out.print("Do you want to sort products by price(YES-1 or NO-0): ");
        int choice = scanner.nextInt();
        if(choice == 1){
            SortProductByPrice.SortByPrice(products);
        }
    }

}
