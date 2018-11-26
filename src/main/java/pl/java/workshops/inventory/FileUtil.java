package pl.java.workshops.inventory;

import java.io.File;
import java.util.Scanner;


public class FileUtil {

    public static File getFile(String fileName) {
        ClassLoader classLoader = FileUtil.class.getClassLoader();
        return new File(classLoader.getResource(fileName).getFile());
    }

    public static String[] getFieldsFromNextLine(Scanner scanner) {
        String line = scanner.nextLine();
        return line.split(";");
    }
}
