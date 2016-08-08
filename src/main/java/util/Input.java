package util;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by neilprajapati on 6/25/16.
 * neilprajapati, dont forget to javaDoc this file.
 */
public class Input {
    private Scanner scan;

    public Input()
    {
        scan = new Scanner(System.in);
    }


    //=====================PROMPTING=============================//
    public int promtInt(String question)
    {
        System.out.println(question);
        return promptInt();
    }

    public int promptInt()
    {
        while(!scan.hasNextInt()){
            if(scan.hasNext()){
                System.out.println(scan.next() + " is not an int. Retry:");
            }
        }
        return scan.nextInt();
    }


    public double promptDouble(String question)
    {
        System.out.println(question);
        return promptDouble();
    }

    public double promptDouble()
    {
        while(!scan.hasNextDouble()){
            if(scan.hasNext()){
                System.out.println(scan.next() + " is not an double. Retry:");
            }
        }
        return scan.nextDouble();
    }


    public BigInteger promptBigInteger(String question)
    {
        System.out.println(question);
        return promptBigInteger();
    }
    public BigInteger promptBigInteger()
    {
        while(!scan.hasNextBigInteger()){
            if(scan.hasNext()){
                System.out.println(scan.next() + " is not an BigInteger. Retry:");
            }
        }
        return scan.nextBigInteger();
    }

    public String promptString(String question)
    {
        System.out.println(question);
        return promptString();
    }
    public String promptString()
    {
        return scan.next();
    }

    //=========================OPENING AND CLOSING SCANNER=============//
    public void close()
    {
        if(scan != null) {
            scan.close();
            scan = null;
        }
    }

}
