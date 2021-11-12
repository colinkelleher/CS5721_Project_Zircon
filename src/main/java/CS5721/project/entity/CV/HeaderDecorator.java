package CS5721.project.entity.CV;

public class HeaderDecorator extends CVDecorator{

    public HeaderDecorator(InterfaceCV wrapper){
        super(wrapper);
    }

    @Override
    public String printCV(String text) {
        return addHeader(text);
    }

    private String addHeader(String text){
        String header = "Here is a header.\n";
        String _text = text + header;
        return _text;
    }

    @Override
    public int number(int number) {
        return super.number(number)*2;
    }
}
