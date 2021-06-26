package Actions.ShopActions;

import Actions.Action;
import Actions.updateJSON;
import Entities.Product;
import Entities.ProductTypes;
import Entities.Shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddProductAction implements Action {
    private Scanner scanner = new Scanner(System.in);
    private Scanner stringScanner = new Scanner(System.in);

    @Override
    public void doAction(){
        Shop shop = ChooseShopAction.chooseShop();

        if(shop == null){
            return;
        }

        Product product = new Product();

        System.out.print("Enter product name: ");
        String name;
        if(stringScanner.hasNextLine()){
            name = stringScanner.nextLine();
        }
        else {
            System.out.println("You entered wrong information");
            return;
        }
        product.setName(name);

        System.out.print("\nEnter product's price: ");
        double price;
        if(scanner.hasNextDouble()){
            price = scanner.nextDouble();
        }
        else {
            System.out.println("You entered wrong information");
            return;
        }
        product.setPrice(price);

        System.out.print("\nEnter amount of this product: ");
        int amount;
        if(scanner.hasNextInt()){
            amount = scanner.nextInt();
        }
        else {
            System.out.println("You entered wrong information");
            return;
        }
        product.setAmount(amount);


        System.out.print("\nChoose your product's types: ");
        List<ProductTypes> types = new ArrayList<>();
        //ADDING PRODUCT TYPES
        while (true) {
            System.out.println("Choose type: ");
            for (int i = 0; i < ProductTypes.values().length; i++){
                System.out.println((i + 1) + " " + ProductTypes.values()[i]);
            }

            int choice = scanner.nextInt();
            if(choice > ProductTypes.values().length || choice < 1) {
                System.out.println("Wrong number\nDo you want to try again(YES-1 or NO-0)?: ");
                choice = scanner.nextInt();
                if(choice == 1)continue;
                break;
            }
            ProductTypes type = ProductTypes.values()[choice - 1];

            types.add(type);

            System.out.print("\nDo you want to add more types for this product(YES-1 or NO-0)?: ");
            choice = scanner.nextInt();
            if(choice != 1)break;
        }

        product.setTypes(types);

        List<Product> products = shop.getProducts();
        products.add(product);
        shop.setProducts(products);
        updateJSON.update();
    }
}
