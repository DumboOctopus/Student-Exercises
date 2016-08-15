package classpractice;

import java.util.ArrayList;
import java.util.InputMismatchException;

/*
 * In physics, numbers usually have sig figs so we don't think they are more accurate than they are.
 * However, this is not the best way of measuring uncertainty. Plus or minus notation is better e.g:
 *
 *  1.233 +/- 0.002;
 *
 *
 *  Hardness: decently hard to understand the concept but easy to write.
 *  Judgement: for older kids not younger ones.
 *
 *
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

    public UncertainNumber toPowerOf(double pow)
    {
        double newValue = Math.pow(value, pow);
        return new UncertainNumber(
                newValue,
                newValue*(Math.abs(pow*getPercentUncertainty(this)))
        );
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


    //heh
    public static void main(String[] args) {
        UncertainNumber cylinderMass = new UncertainNumber(142.13, 0.01);
        UncertainNumber cylinderHeight = new UncertainNumber(5.65, 0.01);
        UncertainNumber cylinderDiameter = new UncertainNumber(1.91, 0.01);

        UncertainNumber wireMass = new UncertainNumber(4.33, 0.01);
        UncertainNumber wireLength = new UncertainNumber(37.22, 0.1);

        UncertainNumber cylinderVolume = (cylinderDiameter.divide(2).multiply(cylinderDiameter.divide(2)).multiply(Math.PI).multiply(cylinderHeight));
        UncertainNumber cylinderDensity = cylinderMass.divide(cylinderVolume);
        UncertainNumber wireRadiusSquared = wireMass.divide(wireLength.multiply(cylinderDensity).multiply(Math.PI));
        UncertainNumber wireRadius = (wireRadiusSquared.toPowerOf(0.5));
        System.out.println(wireRadius.multiply(2)); //note its in cm


    }

}
