package CS5721.project.entity.CV;

import java.util.Scanner;

public class CustomTextDecorator extends CVDecorator{
    public CustomTextDecorator(InterfaceCV wrapper) {
        super(wrapper);
    }

    @Override
    public String printCV(String text) {
        return addCustomText(text);
    }

    public String addCustomText(String text){
        Scanner sc= new Scanner(System.in);    //System.in is a standard input stream
        System.out.print("Enter text- ");
        String customText = sc.nextLine();
        String _text = text + customText;
        return _text;
    }
}
