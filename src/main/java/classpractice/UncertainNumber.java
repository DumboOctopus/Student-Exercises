package classpractice;

import java.util.InputMismatchException;

/**
 * In physics, numbers usually have sig figs so we don't think they are more accurate than they are.
 * However, this is not the best way of measuring uncertainty. Plus or minus notation is better e.g:
 *
 *  1.233 +/- 0.002;
 *
 *
 *  Hardness: decently hard to understand the concept but easy to write.
 *  Judgement: for older kids not younger ones.
 *
 */
public class UncertainNumber {
    private final double value;
    private final double uncertainity;
    public static final double THRESHOLD = 0.00001;


    public UncertainNumber(double value, double uncertainity) {
        this.value = value;
        this.uncertainity = uncertainity;
    }

    public UncertainNumber add(UncertainNumber other)
    {
        UncertainNumber number = new UncertainNumber(
                value + other.value,
                uncertainity + other.uncertainity
        );
        return number;
    }

    public UncertainNumber add(double other)
    {
        UncertainNumber number = new UncertainNumber(
                value + other,
                uncertainity
        );
        return number;
    }

    public UncertainNumber subtract(UncertainNumber other)
    {
        UncertainNumber number = new UncertainNumber(
                value - other.value,
                uncertainity + other.uncertainity
        );
        return number;
    }

    public UncertainNumber subtract(double other)
    {
        UncertainNumber number = new UncertainNumber(
                value - other,
                uncertainity
        );
        return number;
    }

    public UncertainNumber multiply(UncertainNumber other)
    {
        //make lots of variables so the kids understand it better. But also show them the simplified version bc its important
        double product = value * other.value;
        UncertainNumber number = new UncertainNumber(
                product,
                product * (uncertainity/value + other.uncertainity/other.value)
        );
        return number;
    }

    public UncertainNumber multiply(double other)
    {
        UncertainNumber number = new UncertainNumber(
                value * other,
                uncertainity*Math.abs(other)
        );
        return number;
    }

    public UncertainNumber divide(UncertainNumber other)
    {
        double answer = value / other.value;
        UncertainNumber number = new UncertainNumber(
                answer,
                answer * (getPercentUncertainty(this) + getPercentUncertainty(other))
        );
        return number;
    }

    public UncertainNumber divide(double other)
    {
        UncertainNumber number = new UncertainNumber(
                value / other,
                uncertainity/Math.abs(other)
        );
        return number;
    }


    public boolean equals(Object number)
    {
        if(!(number instanceof UncertainNumber)) throw new InputMismatchException("Must be of type UncertainNumber");
        UncertainNumber other = (UncertainNumber) number;
        return Math.abs(other.value - value) < THRESHOLD &&
                Math.abs(other.uncertainity - uncertainity) < THRESHOLD;
    }

    @Override
    public String toString() {
        return "UncertainNumber{" +
                "value=" + value +
                ", uncertainity=" + uncertainity +
                '}';
    }

    //===================UTILITY=============================//

    public static double getPercentUncertainty(UncertainNumber number)
    {
        return number.uncertainity / number.value;
    }


}
