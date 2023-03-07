import java.math.BigDecimal;
import java.util.Map;


/**
 * Represents a checkout system for a store. Handles scanning items and calculating the total price.
 */
public class CheckOut {
    /**
     * The pricing rules for each SKU.
     */
    private final Map<String, ProductPrice> pricingRules;

    /**
     * The items in the cart and their quantities.
     */
    private final ShoppingCart cart;

    /**
     * Constructs a new checkout system with the given pricing rules.
     *
     * @param pricingRules the pricing rules for each item
     * @param cart shopping cart to store scanned items
     * @throws IllegalArgumentException if pricingRules or cart is null
     */
    public CheckOut(Map<String, ProductPrice> pricingRules, ShoppingCart cart) {
        if (pricingRules == null) {
            throw new IllegalArgumentException("Pricing rules cannot be null");
        }
        if (cart == null) {
            throw new IllegalArgumentException("Cart cannot be null");
        }
        this.pricingRules = pricingRules;
        this.cart = cart;
    }


    /**
     * Scans an item and adds it to the cart.
     *
     * @param sku the stock-keeping unit (SKU) of the item
     * @throws IllegalArgumentException if sku is null, or no pricing rule is found for the given SKU
     */
    public void scan(String sku) {
        if (sku == null) {
            throw new IllegalArgumentException("SKU cannot be null");
        }
        if(sku.isEmpty()){
            throw new IllegalArgumentException("SKU cannot be empty String");
        }

        ProductPrice productPrice = pricingRules.get(sku);

        if (productPrice == null) {
            throw new IllegalArgumentException("No pricing rule found for SKU: " + sku);
        }
        cart.addItem(sku);

    }



    /**
     * Calculates the total price of all items in the cart, taking into account their pricing rules.
     *
     * @return the total price of all items in the cart
     * @throws IllegalStateException if cart is null
     * @throws IllegalArgumentException if there is no pricing rule for a SKU in the cart
     */
    public BigDecimal total() {
        Map<String, Integer> shoppingCart = cart.getCart();
        if (shoppingCart == null) {
            throw new IllegalStateException("Cart cannot be null");
        }
        BigDecimal total = BigDecimal.valueOf(0);
        for (Map.Entry<String, Integer> entry: shoppingCart.entrySet()) {
            String sku = entry.getKey();
            int quantity = entry.getValue();
            ProductPrice productPrice = pricingRules.get(sku);
            if (productPrice == null) {
                throw new IllegalArgumentException("No pricing rule found for SKU: " + sku);
            }

            BigDecimal itemTotal = productPrice.getPrice(quantity);
            total = total.add(itemTotal);
        }
        return total;
    }


}

