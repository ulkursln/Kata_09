import java.math.BigDecimal;

public interface PricingRule {

    /**
     * Calculates the price for a given quantity of items.
     *
     * @param quantity The quantity of items to calculate the price for.
     * @return The price for the given quantity of items.
     */
    BigDecimal getPrice(int quantity);
}
