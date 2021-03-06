package pl.java.workshops.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.java.workshops.inventory.ItemDictionaryReader;
import pl.java.workshops.item.ShoppingItem;

import java.util.List;


@RestController
public class ItemsController {

    @Autowired
    ItemDictionaryReader reader;

    @RequestMapping("/items")
    public List<ShoppingItem> index() {
        return reader.read();

}}
