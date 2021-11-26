package CS5721.project.Records;

import CS5721.project.records.entity.Records;
import CS5721.project.records.entity.RecordsDAO;
import CS5721.project.records.entity.RecordsDAOimpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class RecordGetSetTests {
    RecordsDAO recordsDAO = new RecordsDAOimpl();
    Records record4 = new Records(3,"GDPR","GDPR Online", LocalDate.of(2021,11,11),null,false,95L,"Test Employee");
    List<Records> newRecords;

    @Test
    void testGetRecordName() {
        Assertions.assertEquals("GDPR", record4.getRecordName());
    }

    @Test
    void testCompleted(){
        Assertions.assertEquals(false,record4.getCompleted());
    }

    @Test
    void testTrainingDate(){
        Assertions.assertEquals(LocalDate.of(2021,11,11),record4.getTrainingDate());
    }

    @Test
    void setTrainingDateTest(){
        record4.setTrainingDate(LocalDate.of(2021,11,12));
        Assertions.assertEquals(LocalDate.of(2021,11,12), record4.getTrainingDate());
    }
}
