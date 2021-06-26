package Actions.UserActions;

import Actions.Action;
import Actions.ShopActions.ChooseShopAction;
import Constructor.Context;
import Entities.Order;
import Entities.Product;
import Entities.Shop;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MakeOrderAction implements Action {
    private Scanner scanner = new Scanner(System.in);
    @Override
    public void doAction() {

        if(Context.getService().getShops().size() == 0){
            System.out.println("There are no shops");
            return;
        }

        List<Order> orders = Context.getService().getOrders();
        if(orders == null)orders = new ArrayList<>();
        List<Product> order = new ArrayList<>();
        Order ord = new Order();

        while(true) {
            System.out.println("Choose shop you want to enter: ");
            Shop shop = ChooseShopAction.chooseShop();
            //OUTPUT PRODUCTS IN CONSOLE
            shop.getProducts().forEach(product -> System.out.println((shop.getProducts().indexOf(product) + 1)
                    + ". Name: " + product.getName() + "| Price: " + product.getPrice() + "| Amount: " + product.getAmount() + "| Types: " + product.getTypes().toString()));

            System.out.print("\nChoose product you want to order: ");
            int choice = scanner.nextInt();

            if (choice < 1 || choice > shop.getProducts().size()) {
                System.out.print("Wrong number\nDo you want to try again(YES-1 or NO-0)?: ");
                choice = scanner.nextInt();
                if (choice == 1) continue;
                return;
            }
            //ADD PRODUCT TO LIST
            order.add(shop.getProducts().get(choice - 1));
            //REDUCING AMOUNT OF THIS PRODUCT IN THE SHOP
            shop.getProducts().get(choice - 1).setAmount(shop.getProducts().get(choice - 1).getAmount() - 1);
            //REMOVE IT IF IT IS LESS THEN 1
            if(shop.getProducts().get(choice - 1).getAmount() < 1) {
                shop.getProducts().remove(choice - 1);
            }


            System.out.print("\nDo you want to add more products to order(YES-1 or NO-0)?: ");
            choice = scanner.nextInt();

            if(choice == 1)continue;
            break;
        }
        ord.setOrder(order);
        ord.setUserName(Context.getService().getUser().getLogin());
        orders.add(ord);
    }
}
