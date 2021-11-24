package CS5721.project.records.entity;

import org.springframework.context.annotation.Bean;

import java.beans.BeanProperty;
import java.util.ArrayList;

public interface RecordsDAO<T> {
    ArrayList<T> findAllRecords();
    void deleteRecords(T t);
    Records getRecords(int recordId);
    Records setCompleted(int recordId);
}
