package pl.java.workshops.inventory;


import pl.java.workshops.promotions.Promotion;
import pl.java.workshops.promotions.SimplePercentagePromotion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.valueOf;

public class PromotionDictionaryReader implements Reader<Promotion> {

    private String fileName;

    public PromotionDictionaryReader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public ArrayList<Promotion> read() {
        ArrayList<Promotion> promotions = new ArrayList<>();
        File file = FileUtil.getFile(fileName);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] fields = FileUtil.getFieldsFromNextLine(scanner);
                String promotionType = fields[0];
                switch (promotionType) {
                    case "SimplePercentagePromotion":
                        createSimplePercentagePromotion(promotions, fields);
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Something bad happened!");
        }
        return promotions;
    }

    private void createSimplePercentagePromotion(ArrayList<Promotion> promotions, String[] fields) {
        promotions.add(new SimplePercentagePromotion(fields[1], valueOf(fields[2])));
    }
}
