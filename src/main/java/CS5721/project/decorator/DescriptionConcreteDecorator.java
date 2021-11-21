package CS5721.project.decorator;

import CS5721.project.reminder.entity.ReminderAbstract;

public class DescriptionConcreteDecorator extends ReminderDecorator {

	private final ReminderAbstract wrapper;
	private String description;

	public DescriptionConcreteDecorator(ReminderAbstract wrapper, String description) {
		this.wrapper = wrapper;
		this.description = description;
	}

	@Override
	public String addDetails(String detail) {
		return wrapper.addDetails(detail) + " - Description: " + description;
	}
}
