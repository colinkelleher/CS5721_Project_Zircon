package CS5721.project.Reminder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import CS5721.project.decorator.DescriptionConcreteDecorator;
import CS5721.project.decorator.TitleConcreteDecorator;
import CS5721.project.reminder.entity.Reminder;
import CS5721.project.reminder.entity.ReminderAbstract;

public class ReminderDecoratorTest {

	// today date and time
	LocalDateTime _date = LocalDateTime.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
	String date = _date.format(formatter);

	@Test
	public void testReminderWithTitleAndDescription() {
		ReminderAbstract withDescription = new DescriptionConcreteDecorator(
				new TitleConcreteDecorator(new Reminder(""), "Title"), "Description");
		String result = withDescription.addDetails("");
		Assertions.assertEquals("Title - Description: Description", result);
	}

}
