package pl.java.workshops.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.java.workshops.inventory.ItemDictionaryReader;
import pl.java.workshops.inventory.PromotionDictionaryReader;
import pl.java.workshops.item.ShoppingItem;
import pl.java.workshops.promotions.Promotion;
import pl.java.workshops.promotions.SimplePercentagePromotion;

import java.util.List;


@RestController
public class PromotionsController {

    @Autowired
    PromotionDictionaryReader reader;

    @RequestMapping("/promotions")
    public List<Promotion> index() {
        return reader.read();
    }}
