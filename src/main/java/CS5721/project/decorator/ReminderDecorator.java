package CS5721.project.decorator;

import CS5721.project.entity.reminder.ReminderAbstract;
import CS5721.project.entity.reminder.ReminderInterface;

public abstract class ReminderDecorator extends ReminderAbstract {

    public abstract String addDetails(String detail);

}
