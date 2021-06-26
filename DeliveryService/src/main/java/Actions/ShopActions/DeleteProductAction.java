package Actions.ShopActions;

import Actions.Action;
import Actions.updateJSON;
import Entities.Product;
import Entities.Shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeleteProductAction implements Action {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void doAction(){
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

        System.out.print("Choose product you want to delete: ");

        int choice = scanner.nextInt();

        if(choice > shop.getProducts().size() || choice < 1) {
            System.out.println("Wrong number");
            System.out.print("Do you want to try again(YES-1 or NO-0)?: ");
            choice = scanner.nextInt();
            if(choice == 1)doAction();
            return;
        }

        List<Product> products = shop.getProducts();
        products.remove(choice - 1);

        updateJSON.update();
    }
}
