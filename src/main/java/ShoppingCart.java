import java.util.*;

/**
 * Represents a shopping cart that can hold a collection of items.
 */
public class ShoppingCart {

    /**
     * The map storing count of items for each sku.
     */

    private final Map<String, Integer> cart;

    /**
     * Constructs a new shopping cart object with an empty list of items.
     */
    public ShoppingCart(){

        this.cart = new HashMap<>();
    }

    /**
     * Adds an item to the shopping cart. If the item already exists in the cart,
     * increments its count.
     * @param sku The sku of item to add to the cart.
     */
    public void addItem(String sku){
        addItem(sku,1);
    }

    public void addItem(String sku, int quantity){
        cart.put(sku, cart.getOrDefault(sku, 0) + quantity);
    }

    /**
     Returns the Maps of SKU to count in the shopping cart.
     @return The map of SKU to count in the shopping cart.
     */
    public Map<String, Integer> getCart() {
        return cart;
    }
}

