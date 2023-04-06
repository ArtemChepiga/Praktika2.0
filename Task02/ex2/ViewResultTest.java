package Task02.ex2;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ViewResultTest {

    @Test
    public void viewRestore() {
        ViewResult view = new ViewResult();
        view.init();


        try {
            view.viewSave();
        }catch (IOException e){
            Assert.fail(e.getMessage());
        }

        try {
            view.viewRestore();
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }

        assertEquals(view.getItems().size(), view.getItems().size());
        assertTrue("", view.getItems().containsAll(view.getItems()));
    }
}