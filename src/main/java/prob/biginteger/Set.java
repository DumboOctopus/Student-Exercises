package prob.biginteger;

/**
 * Created by neilprajapati on 7/16/16.
 * neilprajapati, dont forget to javaDoc this file.
 */
public class Set {
    private int first;
    private int second;

    public Set(int f, int s)
    {
        first = f;
        second = s;
    }

    public void add(Set other)
    {
        first += other.first;
        second += other.second;
    }

    public void subtract(Set other)
    {
        first -= other.first;
        second -= other.second;
    }

    public int getFirst()
    {
        return first;
    }

    public int getSecond()
    {
        return second;
    }

    public void swapFirstSecond()
    {
        int tmp = first;
        first = second;
        second = tmp;
    }

    /**
     * returns true if they sets have the same first and the same second
     */
    public boolean equals(Set other)
    {
        boolean areFirstTheSame = first == other.getFirst();
        boolean areSecondsTheSame = second == other.getSecond();
        return areFirstTheSame && areSecondsTheSame;
    }
}
