package algorithm.codeup.structure.recursion;

import algorithm.codeup.recursion.Ex1901;
import org.junit.Before;
import org.junit.Test;

public class Ex1901Test {

    private Ex1901 ex;

    @Before
    public void init() {
        this.ex = new Ex1901();
    }

    @Test
    public void case1() {
        final int max = 10;
        int start = 1;

        this.ex.print(max, start);
    }
}
