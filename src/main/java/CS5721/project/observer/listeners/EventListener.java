package CS5721.project.observer.listeners;

import java.io.File;

public interface EventListener {
    void update (String eventType, File file);
}
