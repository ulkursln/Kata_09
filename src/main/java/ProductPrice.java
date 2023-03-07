import java.math.BigDecimal;


/**
 * The `ProductPrice` class represents the pricing information for a product.
 * It stores the SKU of the product and a pricing rule that determine
 * the price of the product based on the quantity ordered.
 */
public class ProductPrice {

    /**
     * The SKU of the product.
     */
    private final String sku;

    /**
     * The list of pricing rules for the product.
     */
    private final PricingRule pricingRule;



    /**
     * Constructs a new `ProductPrice` object with the given SKU and pricing rule.
     *
     * @param sku The SKU of the product.
     * @param pricingRule The pricing rule for the product.
     * @throws IllegalArgumentException If the SKU or the pricing rule is null.
     */
    public ProductPrice(String sku, PricingRule pricingRule) {
        if (pricingRule == null) {
            throw new IllegalArgumentException("Price Rule cannot be null");
        }
        if (sku == null) {
            throw new IllegalArgumentException("SKU cannot be null");
        }
        if(sku.isBlank()){
            throw new IllegalArgumentException("SKU cannot be empty String");
        }


        this.sku = sku;
        this.pricingRule = pricingRule;

    }

    /**
     * Returns the SKU of the product.
     *
     * @return The SKU of the product.
     */
    public String getSku() {
        return sku;
    }

    /**
     * Returns the price of the product based on the given quantity.
     * This method uses the first pricing rule in the list.
     *
     * @param quantity The quantity of the product ordered.
     * @return The price of the product based on the given quantity.
     * @throws IllegalArgumentException If there are no pricing rules defined.
     */
    public BigDecimal getPrice(int quantity){

        if(quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        return pricingRule.getPrice(quantity);
    }


    //!!If your objects will be persisted using an ORM in the future , make sure to always use getters,
    // and never field references in hashCode() and equals().
    // Lazy loaded objects have null-fields, but ORMs usually use the getters to force loading of lazy loaded objects.
    /**
     * Returns true if the given object is equal to this `ProductPrice` object.
     * Two `ProductPrice` objects are equal if they have the same SKU.
     *
     * @param obj The object to compare.
     * @return True if the given object is equal to this `ProductPrice` object.
     */
    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if (!(obj instanceof ProductPrice))
            return false;
        if(obj == this)
            return true;
        return ((ProductPrice) obj).getSku().equals(this.sku);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime *result
                + ((getSku() == null) ? 0 :getSku().hashCode());
        return result;
    }
}
