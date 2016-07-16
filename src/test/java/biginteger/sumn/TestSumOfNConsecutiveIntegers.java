package biginteger.sumn;

import org.junit.Test;
import prob.biginteger.SumOfNConsecutiveIntegers;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

/**
 * Created by neilprajapati on 7/16/16.
 * neilprajapati, dont forget to javaDoc this file.
 */
public class TestSumOfNConsecutiveIntegers {

    @Test
    public void test1()
    {
        BigInteger n = new BigInteger("5");
        BigInteger answer = SumOfNConsecutiveIntegers.sum(n);
        assertEquals(new BigInteger("15"), answer);
    }

}
