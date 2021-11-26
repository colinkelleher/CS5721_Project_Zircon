package CS5721.project.records.entity;

import CS5721.project.task.entity.Task;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class RecordsDAOimpl implements RecordsDAO<Records> {
    private final List<Records> recordList = new ArrayList<>();


    public RecordsDAOimpl(){
        Records record1 = new Records(1,"Manual Handling","MHI Ltd", LocalDate.of(2021,11,5),LocalDate.of(2023,11,5),true,94L,"Lisa");
        recordList.add(record1);
        Records record2 = new Records(2,"GDPR","GDPR Online", null,null,false,96L,"Thomas");
        recordList.add(record2);
        Records record3 = new Records(3,"Safety at work","Safe Inc.", null,null,false,18L,"Kate");
        recordList.add(record3);

    }

    @Override
    public ArrayList<Records> findAllRecords() {
        return (ArrayList<Records>) recordList;
    }

    @Override
    public ArrayList<Records> findEmployeeRecords(Long employeeId) {

        ArrayList<Records> _recordsList = new ArrayList<Records>();

        for (Records records : recordList){
            Long id = records.getEmployeeId();
            if (id.equals(employeeId)){
                _recordsList.add(records);
            }
        }

        return _recordsList;
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
