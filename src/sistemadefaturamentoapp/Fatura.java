
package sistemadefaturamentoapp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Fatura implements Serializable {
    private List<Item> items;

    public Fatura() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public double getTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getTotal();
        }
        return total;
    }
}
