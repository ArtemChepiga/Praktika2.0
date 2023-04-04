package Task02.ex1;

import org.junit.Assert;

public class MainTest {
    Main main = new Main();
    Calc calc = new Calc();

    @org.junit.Test
    public void serialize() {
        Assert.assertFalse(!main.serialize(calc));
    }

    @org.junit.Test
    public void deserealize() {
    }
}