package classpractice;

import java.util.InputMismatchException;

/**
 * In physics, numbers usually have sig figs so we don't think they are more accurate than they are.
 * However, this is not the best way of measuring uncertainty. Plus or minus notation is better e.g:
 *
 *  1.233 +/- 0.002;
 *
 */
public class UncertainNumber {
    private final double value;
    private final double uncertainity;
    public static final double comparisonThreshold = 0.00001;


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

    public UncertainNumber subtract(UncertainNumber other)
    {
        UncertainNumber number = new UncertainNumber(
                value - other.value,
                uncertainity + other.uncertainity
        );
        return number;
    }

    public UncertainNumber multiply(UncertainNumber other)
    {
        double product = value * other.value;
        UncertainNumber number = new UncertainNumber(
                product,
                product * (uncertainity/value + other.uncertainity/other.value)
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


    public boolean equals(Object number)
    {
        if(!(number instanceof UncertainNumber)) throw new InputMismatchException("Must be of type UncertainNumber");
        UncertainNumber other = (UncertainNumber) number;
        return Math.abs(other.value - value) < comparisonThreshold &&
                Math.abs(other.uncertainity - uncertainity) < comparisonThreshold;
    }

    //===================UTILITY=============================//

    public static double getPercentUncertainty(UncertainNumber number)
    {
        return number.uncertainity / number.value;
    }


}
