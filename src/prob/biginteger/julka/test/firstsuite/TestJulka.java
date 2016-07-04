package prob.biginteger.julka.test.firstsuite;

import org.junit.Assert;
import org.junit.Test;
import prob.biginteger.julka.Julka;

import java.math.BigInteger;

/**
 * Created by neilprajapati on 7/2/16.
 */
public class TestJulka {

    @Test
    public void test1()
    {
        BigInteger difference = new BigInteger("10");
        BigInteger total = new BigInteger("2");
        BigInteger[] calc = Julka.calculateValues(total, difference);

        Assert.assertEquals(new BigInteger("6"), calc[0]);
        Assert.assertEquals(new BigInteger("4"), calc[1]);

    }
}
