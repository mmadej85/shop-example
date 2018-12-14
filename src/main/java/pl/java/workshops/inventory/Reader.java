package pl.java.workshops.inventory;

import java.util.ArrayList;

public interface Reader<T> {

    ArrayList<T> read();
}
