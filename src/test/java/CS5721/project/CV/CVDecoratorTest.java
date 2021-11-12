package CS5721.project.CV;

import CS5721.project.entity.CV.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CVDecoratorTest {

    @Test
    public void testCVWithHeader(){
        String textCV = "";
        CVDecorator withHeader = new HeaderDecorator(
                                        new CV());
        String test = withHeader.printCV(textCV);
        Assertions.assertEquals("Here is a header.\n", test);
    }

    @Test
    public void testCVWithHeaderAndFooter(){
        String textCV = "";
        CVDecorator withHeaderFooter = new FooterDecorator(
                                            new HeaderDecorator(
                                                    new CV()));
        String test = withHeaderFooter.printCV(textCV);
        Assertions.assertEquals("Here is a header.\nHere is a footer.\n", test);
    }

    @Test // just here to test the order of the calls, will be deleted
    public void testCVNumber(){
        int number = 0;
        CVDecorator finalNumber = new HeaderDecorator(new FooterDecorator(new CV()));
        int fnumber = finalNumber.number(5);
        Assertions.assertEquals(12, fnumber);
    }
}
