package pl.java.workshops.item;

public class GroceryItem extends ShoppingItem {

    private int weightInGramms;
    private int calories;

    public GroceryItem(String id, String category, String name, int price, int weightInGramms, int calories) {
        super(id, category, name, price);
        this.weightInGramms = weightInGramms;
        this.calories = calories;
    }

    public int getWeightInGramms() {
        return weightInGramms;
    }

    public int getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return super.toString() + " having " + calories + " calories";
    }
}
