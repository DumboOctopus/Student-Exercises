package util;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * This class is rather confusing to use so heres a general description.
 *
 * Input is a class which is instianiated to get user input from the terminal.
 * Unlike scanner, it reprompts the user if there is an issue with the input. For example,
 * one types "hi" when the code was prompting an int.
 *
 * Usually, one creates an instance of the Input object to get Input with code similar to:
 * <code>
 *     Input input = new Input();
 *     ...
 *     String response = input.promptString("I love u");
 *
 * </code>
 *
 * However, in order to make it more initive, there are static (class) methods which
 * will handle the creation of the Input by itself.
 *
 * <code>
 *     String response = Input.getString("i love u");
 * </code>
 *
 * Note: all methods starting with "get" are static. All starting with "prompt" are non-static.
 *
 */
public class Input {
    private Scanner scan;

    public Input()
    {
        scan = new Scanner(System.in);
    }


    //=====================PROMPTING=============================//
    public int promptInt(String question)
    {
        System.out.println(question);
        return promptInt();
    }

    public int promptInt()
    {
        while(!scan.hasNextInt()){
            if(scan.hasNextLine()){
                System.out.println(scan.nextLine()+ " is not an int. Retry:");
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
            if(scan.hasNextLine()){
                System.out.println(scan.nextLine()+ " is not an double. Retry:");
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
            if(scan.hasNextLine()){
                System.out.println(scan.nextLine() + " is not an BigInteger. Retry:");
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
        return scan.nextLine();
    }

    //=========================OPENING AND CLOSING SCANNER=============//
    public void close()
    {
        if(scan != null) {
            scan.close();
            scan = null;
        }
    }

    //=====================IF U DON'T WANT IT WITH OBJECTS==================//
    private static Input defaultInput;

    static{
        defaultInput = new Input();
    }
    public static int getInt(String question)
    {
        return defaultInput.promptInt(question);
    }

    public static int getInt()
    {
        return defaultInput.promptInt();
    }


    public static double getDouble(String question)
    {
        return defaultInput.promptDouble(question);
    }

    public static double getDouble()
    {
        return defaultInput.promptDouble();
    }


    public static BigInteger getBigInteger(String question)
    {
        return defaultInput.promptBigInteger(question);
    }
    public static BigInteger getBigInteger()
    {
        return defaultInput.promptBigInteger();
    }

    public String getString(String question)
    {
        return defaultInput.promptString(question);
    }
    public String getString()
    {
        return defaultInput.promptString();
    }

}
