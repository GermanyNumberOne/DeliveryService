package Constructor;

import Actions.ShopActions.AddShopAction;
import Actions.ShopActions.DeleteShopAction;
import Actions.UserActions.*;
import Menu.*;
import Actions.ShopActions.*;

import java.util.ArrayList;
import java.util.List;

public class MenuInitializer {
    public void init(){
        Context.setMenu(initMenu());
    }

    private Menu initMenu(){
        Menu menu = new Menu();

        menu.setRoot(initRoot());
        menu.setShopItems(initShopMenuItems());
        menu.setUserItems(initUserMenuItems());

        return menu;
    }

    private MenuItem initRoot(){
        MenuItem root = new MenuItem();
        root.setName("Choose a number:");

        return root;
    }

    //INITIALIZING SHOP ITEMS
    private List<MenuItem> initShopMenuItems() {
        List<MenuItem> shopMenuItems = new ArrayList<MenuItem>();

        MenuItem addProductItem = new MenuItem();
        addProductItem.setName("Add product");
        addProductItem.setAction(new AddProductAction());

        MenuItem deleteProductItem = new MenuItem();
        deleteProductItem.setName("Delete product");
        deleteProductItem.setAction(new DeleteProductAction());

        MenuItem editProductItem = new MenuItem();
        editProductItem.setName("Edit product");
        editProductItem.setAction(new EditProductAction());

        MenuItem addShopItem = new MenuItem();
        addShopItem.setName("Add shop");
        addShopItem.setAction(new AddShopAction());

        MenuItem deleteShopItem = new MenuItem();
        deleteShopItem.setName("Delete shop");
        deleteShopItem.setAction(new DeleteShopAction());

        shopMenuItems.add(addProductItem);
        shopMenuItems.add(deleteProductItem);
        shopMenuItems.add(editProductItem);
        shopMenuItems.add(addShopItem);
        shopMenuItems.add(deleteShopItem);

        return shopMenuItems;
    }
    //INITIALIZING USER ITEMS
    private List<MenuItem> initUserMenuItems(){
        List<MenuItem> userMenuItems = new ArrayList<MenuItem>();


        MenuItem searchProduct = new MenuItem();
        searchProduct.setName("Search product");
        searchProduct.setAction(new SearchProduct());

        MenuItem showProductsByType = new MenuItem();
        showProductsByType.setName("Show products by type");
        showProductsByType.setAction(new ShowProductsByTypes());

        MenuItem makeOrderItem = new MenuItem();
        makeOrderItem.setName("Make order");
        makeOrderItem.setAction(new MakeOrderAction());


        userMenuItems.add(searchProduct);
        userMenuItems.add(showProductsByType);
        userMenuItems.add(makeOrderItem);

        return  userMenuItems;
    }
}
