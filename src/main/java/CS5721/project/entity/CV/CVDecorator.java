package CS5721.project.entity.CV;

public class CVDecorator implements InterfaceCV{

    private InterfaceCV wrapper;

    public CVDecorator(InterfaceCV wrapper){
        this.wrapper = wrapper;
    }

    @Override
    public void printCV(String text){
        wrapper.printCV(text);
    }

    @Override
    public int cost() {
        return wrapper.cost();
    }
}
