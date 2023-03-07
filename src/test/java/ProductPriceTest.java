import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ProductPriceTest {
    @Test(expected = IllegalArgumentException.class)
    public void givenNullPricingRule_thenThrowException(){
        new ProductPrice("A", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullSKU_thenThrowException(){
        new ProductPrice(null, PricingRuleFactory.createSimplePricingRule(new Price(BigDecimal.valueOf(3))));
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenEmptySKU_thenThrowException(){
        new ProductPrice(" ", PricingRuleFactory.createSimplePricingRule(new Price(BigDecimal.valueOf(3))));
    }


    @Test(expected = IllegalArgumentException.class)
    public void givenNegativeQuantity_whenGetPriceIsCalled_thenThrowException(){
        ProductPrice productPrice = new ProductPrice("A", PricingRuleFactory.createSimplePricingRule(new Price(BigDecimal.valueOf(3))));
        productPrice.getPrice(-1);
    }

    @Test
    public void testEquals() {
        ProductPrice p1 = new ProductPrice("123", PricingRuleFactory.createSimplePricingRule(new Price(BigDecimal.valueOf(3))));
        ProductPrice p2 = new ProductPrice("123", PricingRuleFactory.createSimplePricingRule(new Price(BigDecimal.valueOf(3))));
        ProductPrice p3 = new ProductPrice("456", PricingRuleFactory.createSimplePricingRule(new Price(BigDecimal.valueOf(3))));
        ProductPrice p4 = null;
        String s = "123";

        assertEquals("p1 should equal p2", p1, p2);
        assertNotEquals("p1 should not equal p3", p1, p3);
        assertNotEquals("p1 should not equal null", p1, p4);
        assertNotEquals("p1 should not equal a String", p1, s);
    }

    @Test
    public void testHashCode() {
        ProductPrice p1 = new ProductPrice("123", PricingRuleFactory.createSimplePricingRule(new Price(BigDecimal.valueOf(3))));
        ProductPrice p2 = new ProductPrice("123", PricingRuleFactory.createSimplePricingRule(new Price(BigDecimal.valueOf(3))));
        ProductPrice p3 = new ProductPrice("456", PricingRuleFactory.createSimplePricingRule(new Price(BigDecimal.valueOf(3))));

        assertEquals("p1 and p2 should have the same hash code", p1.hashCode(), p2.hashCode());
        assertNotEquals("p1 and p3 should have different hash codes", p1.hashCode(), p3.hashCode());
    }



}
