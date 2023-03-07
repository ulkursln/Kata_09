import org.junit.Assert;
import org.junit.Test;

public class ShoppingCartTest {
    @Test
    public void testWhenItemDoesNotExist_thenAddItemWithCountAsOne(){
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("A");
        Integer expected = 1;
        Assert.assertEquals(expected,cart.getCart().get("A"));
    }
    @Test
    public void testWhenItemExists_thenIncrementCount(){
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("A");
        cart.addItem("A");
        Integer expected = 2;
        Assert.assertEquals(expected,cart.getCart().get("A"));
    }
}
