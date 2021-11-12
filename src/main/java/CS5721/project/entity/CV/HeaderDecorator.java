package CS5721.project.entity.CV;

public class HeaderDecorator extends CVDecorator{

    public HeaderDecorator(InterfaceCV wrapper){
        super(wrapper);
    }

    @Override
    public void printCV(String text) {
        super.printCV(text);
    }

    private String addHeader(){
        String header = "Here is a header.";
        return header;
    }

    @Override
    public int cost() {
        return super.cost()+2;
    }
}
