package string;

/**
 * Created by neilprajapati on 8/6/16.
 * neilprajapati, dont forget to javaDoc this file.
 */
public class StringProblems {

    public static void main(String[] args) {
        System.out.println(firstTwo("hill"));
        printAllChars("hill");

        System.out.println(reverse("Hello"));
        System.out.println(bowlderize("UR a python!"));
        System.out.println(isGoodAdverb("ben walked quickly"));
    }

    public static String firstTwo(String in)
    {
        return in.substring(0, 2);
    }

    public static void printAllChars(String in)
    {
        for (int i = 0; i < in.length(); i++) {
            System.out.println(in.substring(i, i + 1));
        }
    }

    //remember to teach both types of connactanation. Out = out + "hi" and out += "hi"
    public static String reverse(String in)
    {
        String out = "";

        for(int i = in.length() -1; i >= 0; i--)
        {
            out += in.substring(i, i +1);
        }

        return out;
    }

    public static String bowlderize(String in)
    {
        String out = in;
        while(out.indexOf("python") != -1)
        {
            System.out.println(out);
            int index = out.indexOf("python");
            out = out.substring(0, index) + out.substring(index + "python".length());
        }
        return out;
    }


    public static boolean isGoodAdverb(String in)
    {
        if(in.length() < 5) return false;
        if(in.substring(0, 3).equals("ben"))
        {
            if(in.substring(in.length() -2).equals("ly"))
            {
                return true;
            }
        }
        return false;
    }

}
