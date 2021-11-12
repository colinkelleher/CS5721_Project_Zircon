package CS5721.project.entity.CV;

public class FooterDecorator extends CVDecorator{

    public FooterDecorator(InterfaceCV wrapper){
        super(wrapper);
    }

    @Override
    public String printCV(String text) {
        return addFooter(text);
    }

    private String addFooter(String text){
        String footer = "Here is a footer.\n";
        String _text = text + footer;
        return _text;
    }

    @Override
    public int number(int number) {
        return super.number(number)+1;
    }
}