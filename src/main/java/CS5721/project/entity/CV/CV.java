package CS5721.project.entity.CV;

public class CV implements InterfaceCV {

    public CV(){

    }

    public int cost(){
        return 10;
    }

    public void printCV(String text){
        System.out.println(text);
    }
}
