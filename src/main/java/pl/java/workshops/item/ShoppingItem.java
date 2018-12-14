package pl.java.workshops.item;

public class ShoppingItem implements Comparable<ShoppingItem> {

    private String id;
    private String category;
    private String name;
    private int price;

    public ShoppingItem(String id, String category, String name, int price) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "(" + id + ")" + name + " with price" + price;
    }


    @Override
    public int compareTo(ShoppingItem o) {
        int compare = Integer.compare(price, o.price);
        if (compare == 0) {
            compare = name.compareTo(o.name);
        }
        return compare;
    }
}
