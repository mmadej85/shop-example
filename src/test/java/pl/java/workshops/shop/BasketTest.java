package pl.java.workshops.shop;

import org.junit.Test;
import pl.java.workshops.item.ClothingItem;
import pl.java.workshops.item.GroceryItem;
import pl.java.workshops.promotions.SimplePercentagePromotion;

import java.util.Collections;

import static java.util.Collections.singletonList;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;


public class BasketTest {

    private static final int TEN_PERCENTAGE = 10;
    private GroceryItem milk = new GroceryItem("1", "grocery", "milk", 20, 300, 200);
    private ClothingItem shirt = new ClothingItem("2", "clothes", "shirt", 30, "S");

    @Test
    public void shouldCorrectlyCalculatePriceWithNoPromotions() {
        Basket basket = new Basket(Collections.emptyList());

        basket.addProduct(milk);
        basket.addProduct(shirt);

        assertThat(basket.calculatePrice(), is(equalTo(50)));
    }

    @Test
    public void shouldCorrectlyCalculatePriceWhenPromotionsApplied() {
        Basket basket = new Basket(singletonList(new SimplePercentagePromotion("1", TEN_PERCENTAGE)));

        basket.addProduct(milk);
        basket.addProduct(milk);
        basket.addProduct(shirt);

        assertThat(basket.calculatePrice(), is(equalTo(66)));
    }


}