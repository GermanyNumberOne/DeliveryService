package Main;

import Actions.updateJSON;
import Constructor.Context;

import java.util.Scanner;

public class Client {
    private static Scanner scanner = new Scanner(System.in);

    public static void run(){

        while (true) {


            System.out.print("\n1.Login as user\n2.Login as shop owner\n3.Exit program\nType your choice:");
            int choice = scanner.nextInt();

            if (choice < 1 || choice > 3) {
                System.out.println("Wrong number");
                System.out.print("Do you want ot try again(YES-1 or NO-0)?: ");
                choice = scanner.nextInt();
                if (choice == 1) continue;
                break;
            }

            if (choice == 3) break;

            else if (choice == 1) {

                for (int i = 0; i < Context.getMenu().getUserItems().size(); i++) {
                    System.out.println((i + 1) + ". " + Context.getMenu().getUserItems().get(i).getName());
                }
                System.out.print(Context.getMenu().getRoot().getName());

                Context.getMenu().executeUserCommand();
            }

            else if (choice == 2) {
                for (int i = 0; i < Context.getMenu().getShopItems().size(); i++) {
                    System.out.println((i + 1) + ". " + Context.getMenu().getShopItems().get(i).getName());
                }
                System.out.print(Context.getMenu().getRoot().getName());

                Context.getMenu().executeShopCommand();
            }

        }

        updateJSON.update();
    }
}
