package CS5721.project.entity.CV;

public class FooterDecorator extends CVDecorator{

    public FooterDecorator(InterfaceCV wrapper){
        super(wrapper);
    }

    @Override
    public void printCV(String text) {
        super.printCV(text);
    }

    private String addFooter(){
        String footer = "Here is a footer.";
        return footer;
    }

    @Override
    public int cost() {
        return super.cost()+3;
    }
}