package biginteger.julka;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import prob.biginteger.Julka;

/**
 * Created by neilprajapati on 7/2/16.
 */
public class TestJulka {

    @Test
    public void test1()
    {
        BigInteger total = new BigInteger("10");
        BigInteger difference = new BigInteger("2");
        BigInteger[] calc = Julka.calculateValues(total, difference);

        Assert.assertNotEquals(calc, null);
        Assert.assertEquals(new BigInteger("6"), calc[0]);
        Assert.assertEquals(new BigInteger("4"), calc[1]);
    }

    @Test
    public void test2()
    {
        BigInteger total = new BigInteger("4");
        BigInteger difference = new BigInteger("4");
        BigInteger[] calc = Julka.calculateValues(total, difference);

        Assert.assertNotEquals(calc, null);
        Assert.assertEquals(new BigInteger("4"), calc[0]);
        Assert.assertEquals(new BigInteger("0"), calc[1]);
    }

    @Test
    public void test3()
    {
        BigInteger total = new BigInteger("4");
        BigInteger difference = new BigInteger("-2");
        BigInteger[] calc = Julka.calculateValues(total, difference);

        Assert.assertNotEquals(calc, null);
        Assert.assertEquals(new BigInteger("1"), calc[0]);
        Assert.assertEquals(new BigInteger("3"), calc[1]);
    }

    @Test
    public void cornerCase()
    {
        BigInteger total = new BigInteger("2");
        BigInteger difference = new BigInteger("1");
        BigInteger[] calc = Julka.calculateValues(total, difference);

        Assert.assertEquals(true, calc == null);
    }
}
