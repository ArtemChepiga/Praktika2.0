package Task02.ex3;

import Task02.ex1.Calc;
import Task02.ex2.ViewResult;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ViewTableTest {
    private ViewResult calc = new ViewResult();
    private ViewTable tb = new ViewTable();

    @Test
    public void testInit(){
        calc.viewInit();
        Assert.assertEquals(10, calc.getItems().size());
        try {
            calc.viewSave();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testRestore(){
        try {
            calc.viewRestore();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Assert.assertEquals(calc.getItems().size(), tb.getItems().size());

    }


}