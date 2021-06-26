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

public class ShowProductsByTypes implements Action {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void doAction() {
        List<Product> products = new ArrayList<>();
        while (true) {
            System.out.println("Choose type: ");
            //I OUTPUT TYPES TO HE CONSOLE
            Arrays.stream(ProductTypes.values()).collect(Collectors.toList()).forEach(productTypes -> System.out.println(productTypes.getIndex() + ". " + productTypes.toString()));

            int i = scanner.nextInt();
            if(i < 1 || i > ProductTypes.values().length){
                System.out.print("Wrong number\nDo you want to try again(YES-1 or NO-0)?: ");
                int choice = scanner.nextInt();
                if(choice == 1)continue;
                break;
            }
            //ADD PRODUCT IF IT HAS TYPE
            Context.getService().getShops().forEach(shop -> shop.getProducts().forEach(product -> {
                if(product.getTypes().contains(ProductTypes.values()[i - 1])) {
                    products.add(product);
                }
            }));
            System.out.print("Do you want to add more types(YES-1 or NO-0)?: ");
            int choice = scanner.nextInt();
            if(choice == 1)continue;
            break;
        }


        if (products.size() == 0){
            System.out.println("There are no product with such types");
            return;
        }
        //OUTPUT
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
