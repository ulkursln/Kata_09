import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;

public class HelperTest {

    @Test(expected = IllegalArgumentException.class)
    public void givenNullSKU_whenAddSimplePriceIsCalled_thenThrowException(){
        Helper.addSimplePrice(new HashMap<>(), null, BigDecimal.valueOf(5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenEmptySKU_whenAddSimplePriceIsCalled_thenThrowException(){
        Helper.addSimplePrice(new HashMap<>(), " ", BigDecimal.valueOf(5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullPricingRules_whenAddSimplePriceIsCalled_thenThrowException(){
        Helper.addSimplePrice(null, "A", BigDecimal.valueOf(5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullSKU_whenAddBulkPriceIsCalled_thenThrowException(){
        int bulkQuantity = 2;
        BigDecimal bulkPrice = BigDecimal.valueOf(6);
        Helper.addBulkPrice(new HashMap<>(), null, BigDecimal.valueOf(4),bulkQuantity, bulkPrice);

    }

    @Test(expected = IllegalArgumentException.class)
    public void givenEmptySKU_whenAddBulkPriceIsCalled_thenThrowException(){
        int bulkQuantity = 2;
        BigDecimal bulkPrice = BigDecimal.valueOf(6);
        Helper.addBulkPrice(new HashMap<>(), " ", BigDecimal.valueOf(4),bulkQuantity, bulkPrice);

    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullPricingRules_whenAddBulkPriceIsCalled_thenThrowException(){
        int bulkQuantity = 2;
        BigDecimal bulkPrice = BigDecimal.valueOf(6);
        Helper.addBulkPrice(null, "A", BigDecimal.valueOf(4),bulkQuantity, bulkPrice);

    }
}
