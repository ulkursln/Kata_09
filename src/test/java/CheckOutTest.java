import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CheckOutTest {

    @Test(expected = IllegalArgumentException.class)
    public void givenNullPricingRules_thenThrowException(){
        new CheckOut(null,new ShoppingCart());
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullShoppingCart_thenThrowException(){
        new CheckOut(new HashMap<>(), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullSKU_whenScanIsCalled_thenThrowException(){
        CheckOut checkout = new CheckOut(new HashMap<>(),new ShoppingCart());
        checkout.scan(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenEmptySKU_whenScanIsCalled_thenThrowException(){
        CheckOut checkout = new CheckOut(new HashMap<>(), new ShoppingCart());
        checkout.scan(" ");
    }

    @Test
    public void testTotalForSingleItem(){
        Map<String, ProductPrice> pricingRules = new HashMap<>();
        BigDecimal unitPrice = BigDecimal.valueOf(5);
        Helper.addSimplePrice(pricingRules, "A", unitPrice);
        CheckOut checkOut = new CheckOut(pricingRules, new ShoppingCart());

        checkOut.scan("A");

        Assert.assertEquals(unitPrice,checkOut.total());
    }

    @Test
    public void testTotalForEmptyCart(){
        Map<String, ProductPrice> pricingRules = new HashMap<>();
        BigDecimal unitPrice = BigDecimal.valueOf(5);
        Helper.addSimplePrice(pricingRules, "A", unitPrice);
        CheckOut checkOut = new CheckOut(pricingRules, new ShoppingCart());

        Assert.assertEquals(BigDecimal.valueOf(0),checkOut.total());
    }

    @Test
    public void testTotalForMultipleItemsInTheCart(){
        Map<String, ProductPrice> pricingRules = new HashMap<>();
        Helper.addSimplePrice(pricingRules, "A", BigDecimal.valueOf(5));
        Helper.addSimplePrice(pricingRules, "B", BigDecimal.valueOf(13));
        Helper.addBulkPrice(pricingRules, "C", BigDecimal.valueOf(4),3, BigDecimal.valueOf(10) );
        Helper.addBulkPrice(pricingRules, "D", BigDecimal.valueOf(5), 2, BigDecimal.valueOf(9));

        CheckOut checkOut = new CheckOut(pricingRules, new ShoppingCart());

        checkOut.scan("A");
        checkOut.scan("A");
        checkOut.scan("B");
        checkOut.scan("C");
        checkOut.scan("C");
        checkOut.scan("C");
        checkOut.scan("D");
        checkOut.scan("D");
        checkOut.scan("D");

        Assert.assertEquals(BigDecimal.valueOf(47),checkOut.total());
    }
}
