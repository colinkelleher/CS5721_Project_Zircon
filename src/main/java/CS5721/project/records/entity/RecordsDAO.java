package CS5721.project.records.entity;

import java.util.ArrayList;

public interface RecordsDAO<T> {
    ArrayList<T> findAllRecords();
    Records getRecords(int recordId);
    Records setCompleted(int recordId);
}
