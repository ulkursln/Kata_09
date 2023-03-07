import java.math.BigDecimal;
import java.util.Map;

/**
  A helper class for adding pricing rules to a given map of pricing rules for a checkout system.
*/
public class Helper {

    /**
     Adds a simple pricing rule with the given unit price to the given map of pricing rules for a checkout system.
     @param pricingRules The map of pricing rules for a checkout system.
     @param sku The stock-keeping unit (SKU) of the product to add a pricing rule for.
     @param unitPrice The unit price of the product.
     */
    public static void addSimplePrice(Map<String, ProductPrice> pricingRules, String sku, BigDecimal unitPrice){

        if (sku == null) {
            throw new IllegalArgumentException("SKU cannot be null");
        }
        if(sku.isBlank()){
            throw new IllegalArgumentException("SKU cannot be empty String");
        }
        if (pricingRules == null) {
            throw new IllegalArgumentException("Pricing rules cannot be null");
        }
        pricingRules.put(sku, new ProductPrice(sku, PricingRuleFactory.createSimplePricingRule(new Price(unitPrice))));
    }

    /**

     Adds a bulk pricing rule with the given unit price, bulk quantity, and bulk price to the given map of pricing rules for a checkout system.
     @param pricingRules The map of pricing rules for a checkout system.
     @param sku The stock-keeping unit (SKU) of the product to add a pricing rule for.
     @param unitPrice The unit price of the product.
     @param bulkQuantity The minimum quantity to buy in order to get the bulk price.
     @param bulkPrice The price for buying in bulk.
     */
    public static void addBulkPrice(Map<String, ProductPrice> pricingRules, String sku, BigDecimal unitPrice, int bulkQuantity, BigDecimal bulkPrice){
        if (sku == null) {
            throw new IllegalArgumentException("SKU cannot be null");
        }
        if(sku.isBlank()){
            throw new IllegalArgumentException("SKU cannot be empty String");
        }
        if (pricingRules == null) {
            throw new IllegalArgumentException("Pricing rules cannot be null");
        }
        pricingRules.put(sku, new ProductPrice(sku, PricingRuleFactory.createBulkPricingRule(new Price(unitPrice),bulkPrice, bulkQuantity)));
    }
}
