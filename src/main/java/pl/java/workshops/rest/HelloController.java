package pl.java.workshops.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.java.workshops.item.ShoppingItem;
import pl.java.workshops.inventory.ItemDictionaryReader;
import pl.java.workshops.shop.Basket;

@RestController
public class HelloController {

    @Autowired
    Basket basket;

    @RequestMapping("/")
    public String index() {
        basket.addProduct(new ShoppingItem("1","grocery","milk",10));
        return basket.toString();
    }

}
