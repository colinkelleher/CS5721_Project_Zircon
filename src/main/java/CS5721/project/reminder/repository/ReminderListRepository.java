package CS5721.project.reminder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import CS5721.project.reminder.entity.ReminderList;

@Repository
public interface ReminderListRepository extends JpaRepository<ReminderList, Long> {

}
