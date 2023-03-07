import org.junit.Test;

import java.math.BigDecimal;

public class PriceTest {

    @Test(expected = IllegalArgumentException.class)
    public void givenNegativeUnitPrice_thenThrowException(){
        new Price(BigDecimal.valueOf(-1));
    }
}
