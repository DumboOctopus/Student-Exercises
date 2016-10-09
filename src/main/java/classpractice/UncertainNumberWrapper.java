package classpractice;

import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * Created by neilprajapati on 9/16/16.
 * neilprajapati, dont forget to javaDoc this file.
 */
public class UncertainNumberWrapper {
    private static ArrayList<UncertainNumberWrapper> instances;
    private UncertainNumber number;
    private final String name;

    static{
        instances = new ArrayList<>();
    }
    public static UncertainNumberWrapper createUncertainNumberWrapper(UncertainNumber number, String name)
    {
        UncertainNumberWrapper n = new UncertainNumberWrapper(number, name);
        instances.add(n);
        return n;
    }


    private UncertainNumberWrapper(UncertainNumber number, String name) {
        for(UncertainNumberWrapper wrapper: instances)
            if(name.equals(wrapper.getName())) throw new InputMismatchException("Name is taken already");
        this.number = number;
        this.name = name;
    }

    public UncertainNumber getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public void setNumber(UncertainNumber number) {
        this.number = number;
    }
}
