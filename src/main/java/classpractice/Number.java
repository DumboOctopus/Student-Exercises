package classpractice;

/**
 * Note to neil, remember instead when teaching this next time, change the add method
 * so its more like BigInteger add method. Its more difficult to explain yes, but its
 * more intutive and the BigInteger analogy works a lot better then. :D
 *
 *
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
