package Entities;

public enum ProductTypes {
    FOOD (1),
    TECHNICS (2),
    CLOTHES (3),
    ACCESSORY (4),
    DECORATION (5),
    SPORTS (6),
    BEAUTY (7),
    STUDY (8),
    HOME (9);

    private int index;

    ProductTypes(int index) {
        this.index = index;
    }

    public ProductTypes getType(int index){
        return ProductTypes.values()[index - 1];
    }

    public int getIndex(){
        return index;
    }
}
