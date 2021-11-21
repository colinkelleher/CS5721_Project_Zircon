package CS5721.project.decorator;

import CS5721.project.reminder.entity.ReminderAbstract;

public abstract class ReminderDecorator extends ReminderAbstract {

	public abstract String addDetails(String detail);
}
