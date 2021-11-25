package CS5721.project.Records;

import CS5721.project.records.entity.Records;
import CS5721.project.records.entity.RecordsDAO;
import CS5721.project.records.entity.RecordsDAOimpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RecordTests {

    RecordsDAO recordsDAO = new RecordsDAOimpl();
    Records record3 = new Records(3,"GDPR","GDPR Online", null,null,false,95L,"Test Employee");

    @Test
    void TestRecords(){
        Records records = recordsDAO.getRecords(1);
        Assertions.assertEquals("Thomas", records.getEmployeeName());
    }

    @Test
    void RecordsUpdateEmployee(){
        Records recordupdate = recordsDAO.getRecords(1);
        recordupdate.setEmployeeName("Colin");
        Assertions.assertEquals("Colin", recordsDAO.getRecords(1).getEmployeeName());
    }

    @Test
    void AddNewRecords(){
        List<Records> newRecords;
        newRecords = new ArrayList<>();
        newRecords.add(record3);
        Assertions.assertEquals(record3,newRecords.get(0));
    }

    @Test
    void RemoveRecords(){
        List<Records> newRecords;
        newRecords = new ArrayList<>();
        newRecords.add(record3);
        Assertions.assertEquals(record3,newRecords.get(0));
        newRecords.remove(0);
        Assertions.assertTrue(newRecords.isEmpty());

    }

}
