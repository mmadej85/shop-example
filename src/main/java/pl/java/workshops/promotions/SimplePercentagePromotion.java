package pl.java.workshops.promotions;


import pl.java.workshops.item.ShoppingItem;

public class SimplePercentagePromotion implements Promotion {
    private ShoppingItem item;

    private int percentage;

    public SimplePercentagePromotion(ShoppingItem item, int percentage) {
        this.item = item;
        this.percentage = percentage;
    }

    public ShoppingItem getItem() {
        return item;
    }

    public int getPercentage() {
        return percentage;
    }

    @Override
    public String toString() {
        return percentage + "% discount - For Product " + item;
    }
}
