package CS5721.project.entity.CV;

public class CV implements InterfaceCV {

    public CV(){

    }


    public String printCV(String text){
        return text;
    }

    @Override
    public int number() {
        return 5;
    }
}
