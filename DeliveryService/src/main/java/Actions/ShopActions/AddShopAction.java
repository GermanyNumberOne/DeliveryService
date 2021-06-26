package Actions.ShopActions;


import Actions.Action;
import Actions.updateJSON;
import Constructor.Context;
import Entities.Product;
import Entities.ProductTypes;
import Entities.Shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddShopAction implements Action {
    private Scanner scanner = new Scanner(System.in);
    private Scanner stringScanner = new Scanner(System.in);

    @Override
    public void doAction(){
        Shop newShop = new Shop();
        List<Shop> shops = Context.getService().getShops();

        if(shops.size() != 0) {
            newShop.setId(shops.get(shops.size() - 1).getId() + 1);
        } else {
            newShop.setId(0);
        }

        System.out.print("Enter shop's name: ");
        if (stringScanner.hasNextLine()) {
            newShop.setName(stringScanner.nextLine());
        }


        newShop.setProducts(new ArrayList<Product>());

        System.out.print("\nDo you want to add products to the shop(YES-1 or NO-0)?: ");
        int choice = scanner.nextInt();

        if(choice == 0) {
            shops.add(newShop);

            return;
        }

        List<Product> products = new ArrayList<>();
        while (true) {

            Product product = new Product();
            product = getNewProduct();
            if(product == null){
                System.out.println("You entered wrong information");
            }
            else products.add(product);

            System.out.println("Do you want to add more products(YES-1 or NO-0)?: ");
            choice = scanner.nextInt();
            if(choice == 0) {
                break;
            }
        }

        newShop.setProducts(products);
        shops.add(newShop);

        //DATA UPDATE
        updateJSON.update();
    }
    //METHOD FOR CREATING A NEW PRODUCT
    private Product getNewProduct() {
        Product product = new Product();

        System.out.print("Enter product name: ");
        String name;
        if(stringScanner.hasNextLine()) {
            name = stringScanner.nextLine();
        }

        else return null;
        product.setName(name);

        System.out.print("\nEnter product's price: ");
        double price;
        if(scanner.hasNextDouble()){
            price = scanner.nextDouble();
        }
        else return null;
        product.setPrice(price);

        System.out.print("\nEnter amount of this product: ");
        int amount;
        if(scanner.hasNextInt()){
            amount = scanner.nextInt();
        }
        else return null;
        product.setAmount(amount);


        System.out.print("\nChoose your product's types: ");
        List<ProductTypes> types = new ArrayList<>();

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


        return product;
    }
}
