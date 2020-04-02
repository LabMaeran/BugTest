package ModelObject;

import org.junit.Test;
import org.junit.Assert;

class ProductTest {

    @Test
    public void insertTest() throws Exception{
        Product p = new Product();
        p.setName("Ciocolata");
        int correct = 1;
        int actual = p.save();

        Assert.assertEquals(correct, actual);

    }

    @Test
    public void ReadTest() throws Exception{
        Product p = Product.getById(1);

        Assert.assertNull(p);

    }

}