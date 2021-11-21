package CS5721.project.Clock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import CS5721.project.clocking.entity.ClockingInfo;

import java.time.LocalDateTime;

public class ClockingInfoTest {
    ClockingInfo clockingInfo = new ClockingInfo();

    @Test
    public void clockingInTest (){

        clockingInfo.setClockingInTime(LocalDateTime.of(2021, 11, 5, 9, 0));
        Assertions.assertEquals((LocalDateTime.of(2021, 11, 5, 9, 0)),clockingInfo.getClockingInTime());
    }
    @Test
    public void clockingOutTest (){
        clockingInfo.setClockingOutTime(LocalDateTime.of(2021, 11, 5, 18, 0));
        Assertions.assertNotEquals(LocalDateTime.of(2021, 11, 6, 18, 0),clockingInfo.getClockingOutTime());
    }

    @Test
    public void clockingDepartmentTest(){
        clockingInfo.setDepartment("Checkouts");
        Assertions.assertEquals("Checkouts",clockingInfo.getDepartment());
    }
}

