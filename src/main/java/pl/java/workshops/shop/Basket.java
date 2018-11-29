package pl.java.workshops.shop;

import org.springframework.stereotype.Component;
import pl.java.workshops.item.ShoppingItem;
import pl.java.workshops.promotions.Promotion;
import pl.java.workshops.promotions.SimplePercentagePromotion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Basket {

    private int price;
    private List<ShoppingItem> items = new ArrayList<>();
    private List<Promotion> promotions = new ArrayList<>();

    public Basket(){};

    public Basket(List<Promotion> promotions) {
        this.promotions = promotions;
    }

    public void addProduct(ShoppingItem item) {
        items.add(item);
        price += item.getPrice();
    }

    public int calculatePrice() {
        for (Promotion promotion : promotions) {
            if (promotion instanceof SimplePercentagePromotion) {
                applySimplePercentagePromotion((SimplePercentagePromotion) promotion);
            }
        }
        return price;
    }

    private void applySimplePercentagePromotion(SimplePercentagePromotion promotion) {
        List<ShoppingItem> cheaperItems =
                items.stream().filter(i -> i.getId().equals(promotion.getItemId())).collect(Collectors.toList());
        if (cheaperItems.size() > 0) {
            ShoppingItem item = cheaperItems.get(0);
            price -= cheaperItems.size() * (promotion.getPercentage() / 100.0) * item.getPrice();
        }
    }
}
