package Constructor;

import Entities.Order;
import Entities.User;
import Entities.DeliveryService;
import Entities.Shop;
import Json.JasonParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EntitiesInitializer {

    public void init(){
        Context.setService(initService());
    }

    private DeliveryService initService(){
        //IF JSON FILE IS NOT EMPTY THIS OBJECT GETS TO THE CONTEXT
        try {
            if(JasonParser.ReadJSON() != null) {
                return JasonParser.ReadJSON();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //IF EMPTY CREATING NEW OBJECT
        DeliveryService deliveryService = new DeliveryService();

        deliveryService.setUser(initUser());
        deliveryService.setShops(initShops());
        deliveryService.setOrders(initOrders());

        return deliveryService;
    }

    private User initUser(){
        User user = new User();

        return user;
    }

    private List<Shop> initShops(){
        List<Shop> shops = new ArrayList<>();

        return shops;
    }

    private List<Order> initOrders(){
        List<Order> orders = new ArrayList<>();

        return orders;
    }
}
