package CS5721.project.records.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RecordsDAOimpl implements RecordsDAO<Records> {
    private final List<Records> recordList = new ArrayList<>();


    public RecordsDAOimpl(){
        Records record1 = new Records(1,"Manual Handling","MHI Ltd", LocalDate.of(2021,11,5),LocalDate.of(2023,11,5),true,94L,"Lisa");
        recordList.add(record1);
        Records record2 = new Records(2,"GDPR","GDPR Online", null,null,false,96L,"Thomas");
        recordList.add(record2);

    }

    @Override
    public ArrayList<Records> findAllRecords() {
        return (ArrayList<Records>) recordList;
    }

    @Override
    public void deleteRecords(Records records) {
        recordList.remove(records.getRecordId());
    }

    @Override
    public Records getRecords(int recordId) {
        return recordList.get(recordId);
    }

    @Override
    public Records setCompleted(int recordId) {
        return recordList.get(recordId).setCompleted();
    }
}
