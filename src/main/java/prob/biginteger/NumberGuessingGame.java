package prob.biginteger;

import util.BigIntegerUtil;
import util.Input;

import java.math.BigInteger;

/**
 * Note to Neil: review how to make bigIntegers every SINGLE DAY SO THEY KNOW FO SHO :D
 * Note to Neil: make them do an example of printing a random big integer first.
 */
public class NumberGuessingGame {
    public static void main(String[] args) {
        Input input = new Input();

        BigInteger max = new BigInteger("10");
        System.out.println("Guess a Big Integer between 1 and "+max);

        BigInteger userAnswer = input.promptBigInteger();
        BigInteger answer = BigIntegerUtil.random(BigInteger.ONE, max);


        while(!userAnswer.equals(answer))
        {
            int compareToResult = userAnswer.compareTo(answer);
            if(compareToResult > 0) System.out.print("too big. ");
            else if(compareToResult < 0) System.out.print("too small. ");
            else {
                break;
            }
            System.out.println("Try again: ");
            userAnswer = input.promptBigInteger();
        }

        System.out.println("YOU WIN :D");
    }
}
