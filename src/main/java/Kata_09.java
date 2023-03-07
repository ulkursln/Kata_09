import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents the main class for the "kata09 checkout problem".
 */
public class Kata_09 {

    public static void main(String[] args) {
        Map<String, ProductPrice> pricingRules = new HashMap<>();


        // Define the pricing rules for each item
        Helper.addSimplePrice(pricingRules, "A", BigDecimal.valueOf(5));
        Helper.addSimplePrice(pricingRules, "B", BigDecimal.valueOf(13));
        Helper.addBulkPrice(pricingRules, "C", BigDecimal.valueOf(4),3, BigDecimal.valueOf(10) );
        Helper.addBulkPrice(pricingRules, "D", BigDecimal.valueOf(5), 2, BigDecimal.valueOf(9));


        // Create a new checkout system with the pricing rules and shoppingCart
        CheckOut checkOut = new CheckOut(pricingRules, new ShoppingCart());

        // Scan some items
        checkOut.scan("A");
        checkOut.scan("A");
        checkOut.scan("B");
        checkOut.scan("C");
        checkOut.scan("C");
        checkOut.scan("C");
        checkOut.scan("D");
        checkOut.scan("D");
        checkOut.scan("D");
        System.out.println("Total:" + checkOut.total());

    }
}
