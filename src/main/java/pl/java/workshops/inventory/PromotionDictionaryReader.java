package pl.java.workshops.inventory;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.java.workshops.item.ShoppingItem;
import pl.java.workshops.promotions.Promotion;
import pl.java.workshops.promotions.SimplePercentagePromotion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.valueOf;

@Component
public class PromotionDictionaryReader implements Reader<Promotion> {

    private String fileName;

    public PromotionDictionaryReader(@Value("${promotions.filename}") String fileName) {
        this.fileName = fileName;
    }

    public ArrayList<Promotion> read(List<ShoppingItem> items) {
        ArrayList<Promotion> promotions = new ArrayList<>();
        File file = FileUtil.getFile(fileName);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] fields = FileUtil.getFieldsFromNextLine(scanner);
                String promotionType = fields[0];
                switch (promotionType) {
                    case "SimplePercentagePromotion":
                        createSimplePercentagePromotion(promotions, fields, items);
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Something bad happened!");
        }
        return promotions;
    }

    private void createSimplePercentagePromotion(ArrayList<Promotion> promotions,
                                                 String[] fields,
                                                 List<ShoppingItem> items) {
        ShoppingItem item = getBasedOnId(fields[1], items);
        promotions.add(new SimplePercentagePromotion(item, valueOf(fields[2])));
    }

    private ShoppingItem getBasedOnId(String id, List<ShoppingItem> items) {
        return items
                .stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .get();
    }
}
