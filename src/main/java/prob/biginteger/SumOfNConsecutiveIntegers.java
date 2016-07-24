package prob.biginteger;

import util.Input;

import java.math.BigInteger;

/**
 * Created by neilprajapati on 7/16/16.
 * neilprajapati, dont forget to javaDoc this file.
 */
public class SumOfNConsecutiveIntegers {


    public static void main(String[] args) {
        Input input = new Input();
        System.out.println(sum(input.promptBigInteger("Sum of what number of ints")));
    }

    /**
     * Calculates the sum of the first n (positive) consecutive integers
     * @param n number of consecutive positive integers
     * @return the sum of the n consecutive postive integers.
     */
    public static BigInteger sum(BigInteger n)
    {
        BigInteger numerator = n.multiply(n.add(BigInteger.ONE));
        return numerator.divide(new BigInteger("2"));
    }
}
