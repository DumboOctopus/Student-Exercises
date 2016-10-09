package classpractice;

import util.Input;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by neilprajapati on 9/16/16.
 * neilprajapati, dont forget to javaDoc this file.
 */
public class UncertainNumberDriver {

    public static void main(String[] args) {
        ArrayList<UncertainNumberWrapper> numbers = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        while(true)
        {
            try {
                String input = scan.nextLine();
                String command = input.substring(0, input.indexOf(" "));
                String data = input.substring(input.indexOf(" "));
                switch (command) {
                    case "def":
                        UncertainNumberWrapper tmp = parseVariable(data);
                        numbers.add(tmp);
                        System.out.println(tmp.getName() + tmp.getNumber());
                        System.out.println(numbers.size());
                        break;
                    case "calc":
                        break;
                }
            } catch(Exception e)
            {
                System.out.println("Error: "+ e.getMessage());
            }
        }
    }

    private static UncertainNumberWrapper parseVariable(String in)
    {
        Pattern pattern = Pattern.compile("([a-zA-z])+\\s*=\\s*(\\d+)\\s*\\+/-\\s*(\\d+)");
        Matcher matcher = pattern.matcher(in);
        if(!matcher.find()) throw new InputMismatchException("Must be writen like x = 2-/-");

        String variableName = matcher.group(1);
        System.out.println("matcher: "+matcher.group(1));

        return  UncertainNumberWrapper.createUncertainNumberWrapper(
                new UncertainNumber(
                        Double.parseDouble(matcher.group(2)),
                        Double.parseDouble(matcher.group(3))
                ),
                variableName
        );
    }




}
