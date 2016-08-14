package classpractice;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by neilprajapati on 8/13/16.
 * neilprajapati, dont forget to javaDoc this file.
 */
public class UncertainNumberTest {



    @Test
    public void testAdd()
    {
        UncertainNumber width = new UncertainNumber(12.4, 0.5);
        UncertainNumber length = new UncertainNumber(28.5, 0.5);
        UncertainNumber perimeter = width.add(width).add(length).add(length);
        Assert.assertEquals(perimeter, new UncertainNumber(81.8, 2));
    }

    @Test
    public void testMultiply()
    {
        UncertainNumber width = new UncertainNumber(12.4, 0.5);
        UncertainNumber length = new UncertainNumber(28.5, 0.5);
        UncertainNumber area = length.multiply(width);
        Assert.assertEquals(area, new UncertainNumber(353.4, 20.45));
    }
}
