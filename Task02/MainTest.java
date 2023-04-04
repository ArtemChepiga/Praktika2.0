package Task02;

import org.junit.Assert;

import static org.junit.Assert.*;

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