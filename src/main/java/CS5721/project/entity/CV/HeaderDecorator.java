package CS5721.project.entity.CV;

public class HeaderDecorator extends CVDecorator{

    public HeaderDecorator(InterfaceCV wrapper){
        super(wrapper);
    }

    @Override
    public String printCV(String text) {
        String _text = super.printCV(text);
        return addHeader(_text);
    }

    private String addHeader(String text){
        String header = "Here is a header.\n";
        return text + header;
    }

    @Override
    public int number() {
        return super.number()+2;
    }
}
