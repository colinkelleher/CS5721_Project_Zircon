package CS5721.project.Reminder;

import CS5721.project.entity.person.Employee;
import CS5721.project.entity.reminder.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReminderDecoratorTest {

    // today date and time
    LocalDateTime _date = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
    String date = _date.format(formatter);



    @Test
    public void testReminderWithDate(){
        ReminderDecorator withDescription = new DateDecorator(
                                        new Reminder());
        String result = withDescription.printReminder();
        Assertions.assertEquals("text\n"+date, result);
    }

    @Test
    public void testReminderWithLocationAndDescription(){
        ReminderDecorator withLocationAndDescription = new LocationDecorator(
                                            new DescriptionDecorator(
                                                    new Reminder()));
        String result = withLocationAndDescription.printReminder();
        Assertions.assertEquals("Here is a location.\ntext\nHere is a description.\n", result);
    }

    /*
    @Test
    public void testEmployeeReminder(){
        Employee newEmployee = new Employee();

        Assertions.assertEquals( , );
    }
    */

}
