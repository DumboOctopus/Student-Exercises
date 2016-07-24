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

        BigInteger max = new BigInteger("100");
        System.out.println("Guess a Big Integer between 1 and "+max);

        BigInteger userAnswer = input.promptBigInteger();
        BigInteger answer = BigIntegerUtil.random(BigInteger.ONE, max);

        BigInteger lowest = new BigInteger("1");
        BigInteger highest = new BigInteger(max.toString()); //create copy becase referece not value
        while(!userAnswer.equals(answer))
        {


            int compareToResult = userAnswer.compareTo(answer);
            if(compareToResult > 0){
                System.out.print("too big. ");
                highest = highest.max( userAnswer.subtract(new BigInteger("1")));
            }
            else if(compareToResult < 0){
                System.out.print("too small. ");
                lowest = lowest.min(userAnswer.add(BigInteger.ONE));
            }
            else {
                break;
            }
            System.out.println("Try again: (hint try: " + lowest.add(highest).divide(new BigInteger("2")));
            userAnswer = input.promptBigInteger();
        }

        System.out.println("YOU WIN :D");
    }
}
