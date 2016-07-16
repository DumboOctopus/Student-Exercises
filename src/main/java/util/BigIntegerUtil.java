package util;

import java.math.BigInteger;
import java.util.Random;

/**
 * Utility class which contains useful methods for BigInteger
 */
public class BigIntegerUtil {

    //written by bill the lizard (http://stackoverflow.com/questions/2290057/how-to-generate-a-random-biginteger-value-in-java)
    /**
     * This is not a very complicated method. <p>
     * It simply takes a concept and does stuff.
     *
     * @param lowerBound the lowest number that can be generated
     * @param upperBound the highest number that can be generated
     * @return a random <code>BigInteger</code> between <code>lowerBound</code> and <code>upperBound</code> inclusively.
     * @see java.math.BigInteger
     */
    public static BigInteger random(BigInteger lowerBound, BigInteger upperBound)
    {
        Random rand = new Random();
        BigInteger result = new BigInteger(upperBound.bitLength(), rand);
        while( result.compareTo(upperBound) > 0 || result.compareTo(lowerBound) < 0) {
            result = new BigInteger(upperBound.bitLength(), rand);
        }
        return result;
    }
}
