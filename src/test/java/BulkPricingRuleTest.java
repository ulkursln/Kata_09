import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class BulkPricingRuleTest {
    @Test(expected = IllegalArgumentException.class)
    public void givenNullPriceRule_thenThrowException(){
        new BulkPricingRule(null,BigDecimal.valueOf(6), 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNegativeBulkQuantity_thenThrowException(){
        new BulkPricingRule(new Price(BigDecimal.valueOf(5)),BigDecimal.valueOf(6), -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenZeroBulkQuantity_thenThrowException(){
        new BulkPricingRule(new Price(BigDecimal.valueOf(5)),BigDecimal.valueOf(6), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNegativeBulkPrice_thenThrowException(){
        new BulkPricingRule(new Price(BigDecimal.valueOf(5)),BigDecimal.valueOf(-1), 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNegativeQuantity_thenThrowException(){
        int bulkQuantity = 2;
        BigDecimal bulkPrice = BigDecimal.valueOf(8);
        BulkPricingRule rule = new BulkPricingRule(new Price(BigDecimal.valueOf(5)), bulkPrice, bulkQuantity);
        rule.getPrice(-1);
    }

    @Test
    public void givenZeroQuantity_thenPriceShouldBeZero(){
        int bulkQuantity = 2;
        BigDecimal bulkPrice = BigDecimal.valueOf(8);
        BulkPricingRule rule = new BulkPricingRule(new Price(BigDecimal.valueOf(5)), bulkPrice, bulkQuantity);
        Assert.assertEquals(BigDecimal.valueOf(0),rule.getPrice(0));
    }

    @Test
    public void testWhenQuantityIsEqualToBulkQuantity_thenPriceShouldBulkPrice(){
        int bulkQuantity = 2;
        BigDecimal bulkPrice = BigDecimal.valueOf(8);
        BulkPricingRule rule = new BulkPricingRule(new Price(BigDecimal.valueOf(5)), bulkPrice, bulkQuantity);
        Assert.assertEquals(bulkPrice,rule.getPrice(bulkQuantity));
    }

    @Test
    public void testWhenQuantityIsLargerThanBulkQuantity_thenPriceShouldBeCalculatedUsingBulkPriceAndSimplePrice(){
        int bulkQuantity = 2;
        BigDecimal bulkPrice = BigDecimal.valueOf(8);
        BulkPricingRule rule = new BulkPricingRule(new Price(BigDecimal.valueOf(5)), bulkPrice, bulkQuantity);
        Assert.assertEquals(BigDecimal.valueOf(13),rule.getPrice(3));
    }

    @Test
    public void testWhenQuantityIsSmallerThanBulkQuantity_thenPriceShouldBeCalculatedUsingSimplePrice(){
        int bulkQuantity = 2;
        BigDecimal bulkPrice = BigDecimal.valueOf(8);
        BulkPricingRule rule = new BulkPricingRule(new Price(BigDecimal.valueOf(5)), bulkPrice, bulkQuantity);
        Assert.assertEquals(BigDecimal.valueOf(5),rule.getPrice(1));
    }

}
