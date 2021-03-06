package at.aau.ase.server;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MainTest {
    Main m;

    @Before
    public void setup() {
        m = new Main();
    }

    @Test
    public void test_main_sig_pos() {
        Assert.assertEquals(1, m.sig(42));
    }


    @Test
    public void test_main_sig_neg() {
        Assert.assertEquals(-1, m.sig(-7));
    }


    @Test
    public void test_main_sig_neut() {
        Assert.assertEquals(0, m.sig(0));
    }
}
