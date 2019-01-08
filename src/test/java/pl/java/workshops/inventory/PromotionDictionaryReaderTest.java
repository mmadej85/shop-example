package pl.java.workshops.inventory;

import org.junit.Test;
import pl.java.workshops.promotions.Promotion;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;


public class PromotionDictionaryReaderTest {

    private PromotionDictionaryReader reader = new PromotionDictionaryReader("test-promotions.csv");

    @Test
    public void shouldCorrectlyReadPromotions() {
        ArrayList<Promotion> promotions = reader.read(items);

        assertThat(promotions.size(), is(equalTo(2)));
        assertThat(promotions.get(0).getItemId(), is(equalTo("1")));
        assertThat(promotions.get(0).toString(), is(equalTo("20% discount - For Product 1")));
        assertThat(promotions.get(1).getItemId(), is(equalTo("4")));
        assertThat(promotions.get(1).toString(), is(equalTo("30% discount - For Product 4")));
    }
}