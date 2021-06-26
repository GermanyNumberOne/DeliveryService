package Constructor;

import Main.Client;

public class MainInitializer {
    public void init(){
        initMenu();
        initEntities();
        Client.run();
    }
    //MENU INITIALIZER
    private void initMenu(){
        MenuInitializer menuInitializer = new MenuInitializer();
        menuInitializer.init();
    }
    //ENTITIES INITIALIZER
    private void initEntities(){
        EntitiesInitializer entitiesInitializer = new EntitiesInitializer();
        entitiesInitializer.init();
    }
}
