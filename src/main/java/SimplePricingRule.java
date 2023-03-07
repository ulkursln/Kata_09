import java.math.BigDecimal;

/**
 * A simple implementation of the PricingRule interface that calculates the total price of a quantity of items
 * using a fixed unit price.
 */
public class SimplePricingRule implements PricingRule {

    /**
     * The fixed unit price for each item.
     */
    private final Price price;

    /**
     * Constructs a new SimplePricingRule object with the given unit price.
     *
     * @param price the fixed unit price for each item
     * @throws IllegalArgumentException if the given price is null
     */
    public SimplePricingRule(Price price) {
        if (price == null) {
            throw new IllegalArgumentException("Price cannot be null");
        }
        this.price = price;
    }

    /**
     * Returns the total price of a quantity of items based on the fixed unit price.
     *
     * @param quantity the quantity of items
     * @return the total price of the quantity of items based on the fixed unit price
     * @throws IllegalArgumentException if the given quantity is negative
     */
    @Override
    public BigDecimal getPrice(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        return price.getUnitPrice().multiply(BigDecimal.valueOf(quantity));
    }
}

