package CS5721.project.entity.CV;

public class FooterDecorator extends CVDecorator{

    public FooterDecorator(InterfaceCV wrapper){
        super(wrapper);
    }

    @Override
    public String printCV(String text) {
        String _text = super.printCV(text);
        return addFooter(_text);
    }

    private String addFooter(String text){
        String footer = "Here is a footer.\n";
        return text + footer;
    }

    @Override
    public int number() {
        return super.number()+1;
    }
}