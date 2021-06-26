package Actions.ShopActions;

import Actions.Action;
import Actions.updateJSON;
import Constructor.Context;
import Entities.Shop;

import java.util.Scanner;

public class DeleteShopAction implements Action {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void doAction() {
        if(Context.getService().getShops().size() == 0){
            System.out.println("There are no shops");
            return;
        }

        int i = 0;
        for(Shop shop : Context.getService().getShops()) {
            System.out.print((i + 1) + ". Shop name: " + shop.getName() + "| Products: ");
            shop.getProducts().forEach(product -> System.out.print(product.getName() + " "));
            System.out.println("");
            i++;
        }

        System.out.print("\nChoose shop you want to delete: ");
        int choice = scanner.nextInt();

        if(choice < 1 || choice > Context.getService().getShops().size()){
            System.out.println("\nWrong number");
            System.out.print("\nDo you want to try again(YES-1 or NO-0)?: ");
            choice = scanner.nextInt();
            if(choice == 1)doAction();
            return;
        }

        Context.getService().getShops().remove(choice - 1);

        updateJSON.update();
    }
}
