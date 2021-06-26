package Actions.ShopActions;

import Constructor.Context;
import Entities.Shop;

import java.awt.*;
import java.util.Scanner;

public class ChooseShopAction {
    private static Scanner scanner = new Scanner(System.in);
    public static Shop chooseShop(){
        if(Context.getService().getShops().size() == 0){
            System.out.println("There are no shops");
            return null;
        }

        int i = 0;
        for(Shop shop : Context.getService().getShops()) {
            System.out.print((i + 1) + ". Shop name: " + shop.getName() + "| Products: ");
            shop.getProducts().forEach(product -> System.out.print(product.getName() + " "));
            System.out.println("");
            i++;
        }

        System.out.print("\nChoose shop: ");
        int choice = scanner.nextInt();

        if(choice < 1 || choice > Context.getService().getShops().size()){
            System.out.println("\nWrong number");
            System.out.print("\nDo you want to try again(YES-1 or NO-0)?: ");
            choice = scanner.nextInt();
            if(choice == 1)chooseShop();
            return null;
        }

        return Context.getService().getShops().get(choice - 1);
    }
}
