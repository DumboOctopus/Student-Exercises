package prob.biginteger;

import util.Input;

import java.math.BigInteger;

/**
 * http://www.spoj.com/problems/JULKA/
 *
 * Give tour of BigInteger
 * Give tour of Input
 *
 * Show Julka problem
 *
 *
 * PROBLEM DESCRIPTION:
 *  Julka surprised her teacher at preschool by solving the following riddle:

 Klaudia and Natalia have 10 apples together, but Klaudia has two apples more than Natalia. How many apples does each of he girls have?

 Julka said without thinking: Klaudia has 6 apples and Natalia 4 apples. The teacher tried to check if Julka's answer wasn't accidental and repeated the riddle every time increasing the numbers. Every time Julka answered correctly. The surprised teacher wanted to continue questioning Julka, but with big numbers she could't solve the riddle fast enough herself. Help the teacher and write a program which will give her the right answers.

 Write a program which:
    reads from prompts the user for the number of apples the girls have together and how many more apples Klaudia has,
    prints the number of apples belonging to Klaudia and the number of apples belonging to Natalia,

    sometimes it won't be possible to find out the number of apples each person has
        e.g:
            total is 4
            Klaudia has 1 more apple
            there is no way Klaudia can have 1 more apple. Try and think it out.
    if it is a case where it is not possible, print out "Not possible"



    Extra cred:
        if it is not possible, print out how many apples are needed.
        e.g
            total = 4
            klaudia has 1 more apple
            this would print 5 (klaudia would have 3 natalia would have 2)
    @see BigInteger
 */
public class Julka {
    public static void main(String[] args) {
        Input input = new Input();
        BigInteger totalApples = input.promptBigInteger("How many total apples:");
        BigInteger difference = input.promptBigInteger("How many more apples does Klaudia have:");

        BigInteger[] calc = calculateValues(totalApples, difference);
        if(calc == null)
        {
            System.out.println("Not possible");
        }else
        {
            System.out.println("Klaudia's apples: " + calc[0]);
            System.out.println("Natalia's apples: " + calc[1]);
        }


        input.close();
    }

    /**
     * @param totalApples the sum of natalia apples and klaudia's apples.
     * @param difference klaudias apples - natalia apples. Can be negative
     *
     * @return null if not possible. If possible, returns a big integer array where
            index 0 contains klaudia number an index 1 contains natalia's number
     */
    public static BigInteger[] calculateValues(BigInteger totalApples, BigInteger difference)
    {

        BigInteger sum = totalApples.add(difference);
        BigInteger two = new BigInteger("2");

        if(sum.remainder(two).equals(BigInteger.ZERO)) {
            BigInteger klaudiaApples = sum.divide(two);
            BigInteger nataliaApples = totalApples.subtract(klaudiaApples);

            return new BigInteger[]{klaudiaApples, nataliaApples};
        }
        return null;
    }
}
