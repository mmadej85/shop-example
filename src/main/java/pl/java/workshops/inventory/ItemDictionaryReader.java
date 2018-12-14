package pl.java.workshops.inventory;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.java.workshops.item.ClothingItem;
import pl.java.workshops.item.GroceryItem;
import pl.java.workshops.item.ShoppingItem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.valueOf;

@Component
public class ItemDictionaryReader implements Reader<ShoppingItem> {
    private String fileName;

    public ItemDictionaryReader(@Value("${items.filename}") String fileName) {
        this.fileName = fileName;
    }

    @Override
    public ArrayList<ShoppingItem> read() {
        ArrayList<ShoppingItem> items = new ArrayList<>();
        File file = FileUtil.getFile(fileName);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] fields = FileUtil.getFieldsFromNextLine(scanner);
                String itemType = fields[0];
                switch (itemType) {
                    case "grocery":
                        createGroceryItem(items, fields);
                        break;
                    case "clothes":
                        createClothingItem(items, fields);
                        break;
                    default:
                        createStandardShoppingItem(items, fields);
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Something bad happened!");
        }
        return items;
    }

    private void createStandardShoppingItem(ArrayList<ShoppingItem> items, String[] fields) {
        items.add(new ShoppingItem(fields[0], fields[1], fields[2], valueOf(fields[3])));
    }

    private void createClothingItem(ArrayList<ShoppingItem> items, String[] fields) {
        items.add(new ClothingItem(fields[0], fields[1], fields[2], valueOf(fields[3]), fields[4]));
    }

    private void createGroceryItem(ArrayList<ShoppingItem> items, String[] fields) {
        items.add(new GroceryItem(fields[0], fields[1], fields[2], valueOf(fields[3]), valueOf(fields[4]), valueOf(fields[5])));
    }
}
