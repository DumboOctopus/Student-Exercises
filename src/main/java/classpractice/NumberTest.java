package classpractice;

/**
 * Created by neilprajapati on 8/13/16.
 * neilprajapati, dont forget to javaDoc this file.
 */
public class NumberTest {

    public static void main(String[] args) {
        Number number = new Number(12);
        Number number1 = new Number(34);

        Number max = Number.getMax(number1, number);


        System.out.println(max);
        System.out.println(max.toString());
    }
}
