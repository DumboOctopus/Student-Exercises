package prob.biginteger.numguess;

import util.BigIntegerUtil;
import util.io.Input;

import java.math.BigInteger;

/**
 * Created by neilprajapati on 7/2/16.
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
                System.out.println("YOU WIN :D");
                return;
            }
            System.out.println("Try again: ");
            userAnswer = input.promptBigInteger();
        }
    }
}
