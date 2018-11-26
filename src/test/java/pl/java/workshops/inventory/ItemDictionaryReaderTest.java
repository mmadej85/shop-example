package pl.java.workshops.inventory;

import org.junit.Test;
import pl.java.workshops.item.ShoppingItem;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ItemDictionaryReaderTest {

    private ItemDictionaryReader reader = new ItemDictionaryReader("test-items.csv");

    @Test
    public void shouldCorrectlyReadItems() {
        ArrayList<ShoppingItem> items = reader.read();

        assertThat(items.size(), is(equalTo(4)));
        assertThat(items.get(0).getName(), is(equalTo("smoothie")));
        assertThat(items.get(1).getName(), is(equalTo("socks")));
        assertThat(items.get(2).getName(), is(equalTo("t-shirt")));
        assertThat(items.get(3).getName(), is(equalTo("apple")));
    }
}