package pl.java.workshops.promotions;


public class SimplePercentagePromotion implements Promotion {
    private String itemId;

    private int percentage;

    public SimplePercentagePromotion(String itemId, int percentage) {
        this.itemId = itemId;
        this.percentage = percentage;
    }

    @Override
    public String getItemId() {
        return itemId;
    }

    public int getPercentage() {
        return percentage;
    }

    @Override
    public String toString() {
        return percentage + "% discount - For Product " + itemId;
    }
}
