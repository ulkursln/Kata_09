import java.math.BigDecimal;

/**
 * The BulkPricingRule class represents a pricing rule for bulk purchasing of a product.
 * It implements the PricingRule interface.
 */
public class BulkPricingRule implements PricingRule{

    /**
     * The original price of the product.
     */
    private final Price price;

    /**
     * The price for buying in bulk.
     */
    private final BigDecimal bulkPrice;

    /**
     * The minimum quantity to buy in order to get the bulk price.
     */
    private final int bulkQuantity;

    /**
     * Constructs a new bulk pricing rule for a product.
     *
     * @param price the original price of the product.
     * @param bulkQuantity the minimum quantity to buy in order to get the bulk price.
     * @param bulkPrice the price for buying in bulk.
     * @throws IllegalArgumentException if price is not set or bulk-quantity or bulk-price are negative.
     */
    public BulkPricingRule(Price price, BigDecimal bulkPrice, int bulkQuantity) throws IllegalArgumentException {
        if (price == null) {
            throw new IllegalArgumentException("Price cannot be null");
        }
        if (bulkQuantity <= 0) {
            throw new IllegalArgumentException("Bulk quantity should be positive");
        }
        if (bulkPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Bulk price cannot be negative");
        }

        this.price = price;
        this.bulkPrice = bulkPrice;
        this.bulkQuantity = bulkQuantity;
    }

    /**
     * Calculates the price for a given quantity of items using the bulk pricing rule.
     *
     * @param quantity the quantity of items to calculate the price for.
     * @return the price for the given quantity of items.
     * @throws IllegalArgumentException if the quantity is negative.
     */
    @Override
    public BigDecimal getPrice(int quantity) throws IllegalArgumentException {
        if(quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        int bulkCount = quantity / bulkQuantity;
        int remainder = quantity % bulkQuantity;
        return bulkPrice.multiply(BigDecimal.valueOf(bulkCount))
                .add(price.getUnitPrice().multiply(BigDecimal.valueOf(remainder)));
    }
}
