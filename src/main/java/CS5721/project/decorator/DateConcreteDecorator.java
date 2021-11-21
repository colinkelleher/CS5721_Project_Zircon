package CS5721.project.decorator;

import CS5721.project.reminder.entity.ReminderAbstract;

public class DateConcreteDecorator extends ReminderDecorator {
	private final ReminderAbstract wrapper;

	public DateConcreteDecorator(ReminderAbstract wrapper) {
		this.wrapper = wrapper;
	}

	@Override
	public String addDetails(String detail) {
		return wrapper.addDetails(detail) + "Here is a date.\n";
	}

}
