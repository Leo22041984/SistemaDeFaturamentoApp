
package sistemadefaturamentoapp;
import java.io.Serializable;

public class Item implements Serializable {
    private String itemName;
    private double price;
    private int quantity;

    public Item(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return itemName + " - R$" + price + " x " + quantity + " = R$" + getTotal();
    }
}
