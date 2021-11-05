package CS5721.project.Observer;


import CS5721.project.observer.publisher.EventManager;
import CS5721.project.observer.publisher.EventSystem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EventManagerTest {

    @Test
    public void eventManagerTest (){
        EventManager eventManager = new EventSystem("create_event","create_request");

    }

}
