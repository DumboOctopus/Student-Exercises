package string;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by neilprajapati on 8/6/16.
 * neilprajapati, dont forget to javaDoc this file.
 */
public class StringPuzzle {
    @Test
    public void test()
    {
        String in = "hi_python";
        assertEquals("hi_", string.StringProblems.bowlderize(in));
    }

    @Test
    public void test2()
    {
        String in = "hi_ppythonython";
        assertEquals("hi_", string.StringProblems.bowlderize(in));
    }

    @Test
    public void test3()
    {
        String in = "asdf";
        assertEquals("fdsa", string.StringProblems.reverse(in));
    }

    @Test
    public void test4()
    {
        String in = "benly";
        assertEquals(true, string.StringProblems.isGoodAdverb(in));

        in = "benefactor";
        assertEquals(false, string.StringProblems.isGoodAdverb(in));

        in = "terribly";
        assertEquals(false, string.StringProblems.isGoodAdverb(in));
    }
}
