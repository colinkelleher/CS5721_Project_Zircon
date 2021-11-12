package CS5721.project.entity.CV;

public class CVDecorator implements InterfaceCV{

    private InterfaceCV wrapper;

    public CVDecorator(InterfaceCV wrapper){
        this.wrapper = wrapper;
    }

    @Override
    public String printCV(String text){
        return wrapper.printCV(text);
    }

    @Override
    public int number() {
        return wrapper.number();
    }
}
