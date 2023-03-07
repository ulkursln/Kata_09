import java.math.BigDecimal;

/**
 * The Price class represents the price of a product in a store.
 */
public class Price {

    /**
     * The unit price of the product.
     */
    private final BigDecimal unitPrice;

    /**
     * Constructs a Price object with the specified unit price.
     *
     * @param unitPrice the unit price of the product.
     * @throws IllegalArgumentException if the unit price is negative.
     */
    public Price(BigDecimal unitPrice) {
        if (unitPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Unit price cannot be negative");
        }
        this.unitPrice = unitPrice;
    }

    /**
     * Returns the unit price of the product.
     *
     * @return the unit price of the product.
     */
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

}
