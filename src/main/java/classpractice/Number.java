package classpractice;

/**
 * Created by neilprajapati on 8/13/16.
 * neilprajapati, dont forget to javaDoc this file.
 */
public class Number {
    private int value;

    public Number(int initialValue)
    {
        value = initialValue;
    }

    public void add(int otherNumber)
    {
        value += otherNumber;
    }

    public String toString()
    {
        return "Number: " + value;
    }

    //=======================UTILITY METHODS=====================//
    public static Number getMax(Number n1, Number n2)
    {
        if(n1.value > n2.value) return n1;
        else return n2;
    }

    public static Number getMin(Number n1, Number n2)
    {
        if(n1.value > n2.value) return n2;
        else return n1;
    }
}
