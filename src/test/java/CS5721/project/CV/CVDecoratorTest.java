package CS5721.project.CV;

import CS5721.project.entity.CV.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CVDecoratorTest {

    @Test
    public void testCVWithHeader(){
        //String textCV =
        //Assertions.assertEquals("This is a CV", textCV);
    }

    @Test
    public void testCVWithHeaderAndFooter(){
        int cost;
        InterfaceCV cv = new FooterDecorator(
                            new HeaderDecorator(
                                new CV()));
        cost = cv.cost();
        Assertions.assertEquals(15, cost);
    }
}
