package pl.java.workshops.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.java.workshops.inventory.ItemDictionaryReader;
import pl.java.workshops.inventory.PromotionDictionaryReader;
import pl.java.workshops.item.ShoppingItem;
import pl.java.workshops.promotions.Promotion;

import java.util.ArrayList;
import java.util.List;


@RestController
public class PromotionsController {

    @Autowired
    PromotionDictionaryReader promotionDictionaryReader;
    @Autowired
    ItemDictionaryReader itemDictionaryReader;

    @RequestMapping("/promotions")
    public List<Promotion> index() {
        ArrayList<ShoppingItem> items = itemDictionaryReader.read();
        return promotionDictionaryReader.read(items);
    }}
