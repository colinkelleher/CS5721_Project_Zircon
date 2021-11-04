package CS5721.project.observer.editor;

import CS5721.project.observer.publisher.EventManager;
import java.io.File;

public class Editor {
    public EventManager events;
    private File file;

    public Editor() {
        this.events = new EventManager("open", "save");
    }
}
