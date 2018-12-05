package pl.java.workshops.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.java.workshops.shop.Basket;

@RestController
public class HelloController {

    @Autowired
    Basket basket;

    @RequestMapping("/")
    public String index() {
        return basket.toString();
    }

}
