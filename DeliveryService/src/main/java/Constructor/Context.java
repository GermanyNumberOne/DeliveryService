package Constructor;

import Entities.DeliveryService;
import Menu.Menu;

public class Context {
    private static DeliveryService service;
    private static Menu menu;


    public static DeliveryService getService() {
        return service;
    }

    public static void setService(DeliveryService service) {
        Context.service = service;
    }

    public static Menu getMenu() {
        return menu;
    }

    public static void setMenu(Menu menu) {
        Context.menu = menu;
    }
}
