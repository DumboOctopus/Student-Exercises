package prob.biginteger;

/**
 * Created by neilprajapati on 7/16/16.
 * neilprajapati, dont forget to javaDoc this file.
 */
public class Main {
    public static void main(String[] args) {
        Set s = new Set(5, 6);

        System.out.println(s.getFirst());
        System.out.println(s.getSecond());

        Set set2 = new Set(10, 12);
        System.out.println(set2.getFirst());
        System.out.println(set2.getSecond());

        s.add(set2);
        s.swapFirstSecond();
        System.out.println(s.equals(set2));
        System.out.println(s.getFirst());
        System.out.println(s.getSecond());

    }
}
