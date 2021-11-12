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
        String result = withHeader.printCV(textCV);
        Assertions.assertEquals("Here is a header.\n", result);
    }

    @Test
    public void testCVWithHeaderAndFooter(){
        String textCV = "";
        CVDecorator withHeaderFooter = new FooterDecorator(
                                            new HeaderDecorator(
                                                    new CV()));
        String result = withHeaderFooter.printCV(textCV);
        Assertions.assertEquals("Here is a header.\nHere is a footer.\n", result);
    }

    @Test // just here to see the order of the calls, will be deleted
    public void testCVNumber(){
        int number = 0;
        CVDecorator complexNumber = new HeaderDecorator(new FooterDecorator(new CV()));
        int result = complexNumber.number(5);
        Assertions.assertEquals(12, result);
    }

    @Test
    public void testCustomText(){
        String textCV = "";
        CVDecorator withCustomText = new CustomTextDecorator(new CV());
        String result = withCustomText.printCV(textCV);
        Assertions.assertEquals("Hi", result);
    }
}
