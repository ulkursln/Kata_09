import java.math.BigDecimal;

/**
 * A factory class for creating pricing rules.
 */
public class PricingRuleFactory {

    /**
     * Creates a new SimplePricingRule with the given product price.
     *
     * @param price The price of a single unit of the product.
     * @return A new SimplePricingRule object.
     */
    public static PricingRule createSimplePricingRule(Price price){

        return new SimplePricingRule(price);
    }

    /**
     * Creates a new BulkPricingRule with the given product price, bulk quantity, and bulk price.
     *
     * @param price The price of a single unit of the product.
     * @param bulkQuantity The quantity required to trigger the bulk price.
     * @param bulkPrice The price per unit for quantities greater than or equal to bulkQuantity.
     * @return A new BulkPricingRule object.
     */
    public static PricingRule createBulkPricingRule(Price price, BigDecimal bulkPrice, int bulkQuantity ){
        return new BulkPricingRule(price, bulkPrice, bulkQuantity);
    }

}
