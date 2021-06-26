package Actions.ShopActions;

import Actions.Action;
import Actions.updateJSON;
import Entities.Product;
import Entities.ProductTypes;
import Entities.Shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EditProductAction implements Action {
    private Scanner scanner = new Scanner(System.in);
    private Scanner stringScanner = new Scanner(System.in);

    @Override
    public void doAction() {
        Shop shop = ChooseShopAction.chooseShop();
        if(shop == null){
            return;
        }

        int i = 0;
        for(Product product : shop.getProducts()){
            System.out.println((i + 1) + ". " + "Product name: " + product.getName()
            + "| Price: " + product.getPrice()
            + "| Amount: " + product.getAmount()
            + "| Types: " + product.getTypes().toString());
            i++;
        }

        System.out.print("Choose product you want to edit: ");
        int choice = scanner.nextInt();
        if(choice > shop.getProducts().size() || choice < 1){
            System.out.println("Wrong number");
            return;
        }

        Product product = shop.getProducts().get(choice - 1);
        List<Product> products = shop.getProducts();
        products.remove(choice - 1);

        while(true){
            System.out.print("Choose information you want to edit:\n"
                    + "1.Name\n2.Price\n3.Amount\n4.Types\n");

            choice = scanner.nextInt();
            if(choice > 4 || choice < 1) {
                System.out.println("Wrong number");
                continue;
            }

            if(choice == 1){
                System.out.print("Enter new name: ");
                String name = stringScanner.nextLine();
                product.setName(name);
            }
            else if(choice == 2){
                System.out.print("Enter new price: ");
                double price = scanner.nextDouble();
                product.setPrice(price);
            }
            else if(choice == 3){
                System.out.print("Enter new amount: ");
                int amount = scanner.nextInt();
                product.setAmount(amount);
            }
            else {
                List<ProductTypes> types = new ArrayList<>();
                while (true) {
                    System.out.println("Choose new type: ");
                    for (i = 0; i < ProductTypes.values().length; i++){
                        System.out.println((i + 1) + " " + ProductTypes.values()[i]);
                    }

                    choice = scanner.nextInt();
                    if(choice > ProductTypes.values().length || choice < 0) {
                        System.out.println("Wrong number");
                        continue;
                    }
                    ProductTypes type = ProductTypes.values()[choice - 1];

                    types.add(type);

                    System.out.print("\nDo you want to add more types for this product(YES-1 or NO-0)?: ");
                    choice = scanner.nextInt();
                    if(choice != 1)break;
                }
            }

            System.out.print("Do you want to change more information(YES-1 or NO-0)?: ");
            choice = scanner.nextInt();
            if(choice != 1)break;
        }
        products.add(product);

        updateJSON.update();
    }
}
