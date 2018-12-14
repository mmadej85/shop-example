package pl.java.workshops.item;


public class ClothingItem extends ShoppingItem {

    private String size;


    public ClothingItem(String id, String category, String name, int price, String size) {
        super(id, category, name, price);
        this.size = size;
    }

    public String getSize() {
        return size;
    }
}
