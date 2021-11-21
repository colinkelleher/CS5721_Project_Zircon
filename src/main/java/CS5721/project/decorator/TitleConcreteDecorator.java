package CS5721.project.decorator;

import CS5721.project.reminder.entity.ReminderAbstract;

public class TitleConcreteDecorator extends ReminderDecorator {
	private final ReminderAbstract wrapper;

	private String title;

	public TitleConcreteDecorator(ReminderAbstract wrapper, String title) {
		this.wrapper = wrapper;
		this.title = title;
	}

	@Override
	public String addDetails(String detail) {
		return wrapper.addDetails(detail) + title;
	}

}
