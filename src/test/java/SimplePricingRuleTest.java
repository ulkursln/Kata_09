import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class SimplePricingRuleTest {

    @Test(expected = IllegalArgumentException.class)
    public void givenNullPrice_thenThrowException(){
        new SimplePricingRule(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNegativeQuantity_whenGetPriceIsCalled_thenThrowException(){
        SimplePricingRule rule = new SimplePricingRule(new Price(BigDecimal.valueOf(5)));
        rule.getPrice(-1);
    }
    @Test
    public void testWhenQuantityIsZero_thenPriceShouldBeZero(){
        SimplePricingRule rule = new SimplePricingRule(new Price( BigDecimal.valueOf(5)));
        BigDecimal actual = rule.getPrice(0);
        Assert.assertEquals(BigDecimal.valueOf(0),actual);
    }



    @Test
    public void testWhenQuantityIsPositive_thenPriceShouldBeCalculated(){
        SimplePricingRule rule = new SimplePricingRule(new Price(BigDecimal.valueOf(5)));
        BigDecimal actual = rule.getPrice(2);
        Assert.assertEquals(BigDecimal.valueOf(10),actual);
    }
}
