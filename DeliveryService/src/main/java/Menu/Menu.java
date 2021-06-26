package Menu;


import Actions.ShopActions.ChooseShopAction;

import java.util.List;
import java.util.Scanner;

public class Menu {
    //CLASS FOR VIRTUAL PRESENTATION OF MENU
    private MenuItem root;
    private List<MenuItem> shopItems;
    private List<MenuItem> userItems;

    public List<MenuItem> getUserItems() {
        return userItems;
    }

    public void executeUserCommand() {
        Scanner scanner = new Scanner(System.in);

        int choice = scanner.nextInt();

        if(choice < 1 || choice > userItems.size()){
            System.out.println("Wrong number");
            return;
        }

        userItems.get(choice - 1).getAction().doAction();
    }

    public void setUserItems(List<MenuItem> userItems) {
        this.userItems = userItems;
    }

    public void executeShopCommand() {
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if(choice < 1 || choice > shopItems.size()){
            System.out.println("Wrong number");
            return;
        }

        shopItems.get(choice - 1).getAction().doAction();
    }

    public List<MenuItem> getShopItems() {
        return shopItems;
    }

    public void setShopItems(List<MenuItem> shopItems) {
        this.shopItems = shopItems;
    }

    public MenuItem getRoot() {
        return root;
    }

    public void setRoot(MenuItem root) {
        this.root = root;
    }
}
