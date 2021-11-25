package CS5721.project;

import java.time.LocalDateTime;
import java.util.List;

import javax.inject.Inject;

import CS5721.project.calendar.entity.RegularEvent;
import CS5721.project.calendar.repository.CalendarEventRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import CS5721.project.builder.Director;
import CS5721.project.builder.EmployeeBuilder;
import CS5721.project.calendar.entity.Calendar;
import CS5721.project.calendar.repository.CalendarRepository;
import CS5721.project.clocking.entity.ClockingInfo;
import CS5721.project.clocking.entity.Shift;
import CS5721.project.clocking.repository.ClockingInfoRepository;
import CS5721.project.clocking.repository.ShiftRepository;
import CS5721.project.employee.entity.CompanyEntity;
import CS5721.project.employee.entity.DEPARTMENT;
import CS5721.project.employee.entity.Employee;
import CS5721.project.employee.entity.Team;
import CS5721.project.employee.repository.CompanyEntityRepository;
import CS5721.project.reminder.entity.ReminderList;
import CS5721.project.reminder.repository.ReminderListRepository;

@Controller
@RequestMapping(path = "")
public class ZirconWelcomePageController {

	public final CompanyEntityRepository companyEntityRepository;
	public final ShiftRepository shiftRepository;
	public final CalendarRepository calendarRepository;
	public final ClockingInfoRepository clockingInfoRepository;
	public final ReminderListRepository reminderListRepository;
	public final CalendarEventRepository calendarEventRepository;

	@Inject
	public ZirconWelcomePageController(CompanyEntityRepository companyEntityRepository, ShiftRepository shiftRepository,
									   CalendarRepository calendarRepository, ClockingInfoRepository clockingInfoRepository,
									   ReminderListRepository reminderListRepository, CalendarEventRepository calendarEventRepository) {
		super();
		this.companyEntityRepository = companyEntityRepository;
		this.shiftRepository = shiftRepository;
		this.calendarRepository = calendarRepository;
		this.clockingInfoRepository = clockingInfoRepository;
		this.reminderListRepository = reminderListRepository;
		this.calendarEventRepository = calendarEventRepository;
	}

	@GetMapping(path = "/")
	public String initialization(Model model) {

		Director director = new Director();
		EmployeeBuilder employeeBuilder = new EmployeeBuilder();

		Team company = new Team("Company", DEPARTMENT.EXECUTIVE_DEPARTMENT);
		director.constructNameOnly(employeeBuilder, "Kate");
		Employee chiefExecutive = employeeBuilder.getResult();
		Shift shift1 = chiefExecutive.getShift();
		shiftRepository.save(shift1);
		Calendar calendar1 = chiefExecutive.getCalendar();
		calendarRepository.save(calendar1);
		RegularEvent regularEvent = new RegularEvent(LocalDateTime.now().withDayOfMonth(1).withHour(8),LocalDateTime.now().withDayOfMonth(1).withHour(17));
		regularEvent.setCalendar(calendar1);
		calendarEventRepository.save(regularEvent);
		calendar1.addEvent(regularEvent);
		calendarEventRepository.save(regularEvent);
		calendarRepository.save(calendar1);
		ClockingInfo clockingInfo1 = chiefExecutive.getClockingInfo();
		clockingInfoRepository.save(clockingInfo1);
		ReminderList reminderList1 = chiefExecutive.getReminderList();
		reminderListRepository.save(reminderList1);

		List<CompanyEntity> companyEntities = company.getCompanyEntities();
		companyEntities.add(chiefExecutive);

		Team researchTeam = new Team("researchTeam", DEPARTMENT.RESEARCH_DEPARTMENT);
		director.constructNameOnly(employeeBuilder, "James");
		Employee researchManager = employeeBuilder.getResult();
		Shift shift2 = researchManager.getShift();
		shiftRepository.save(shift2);
		Calendar calendar2 = researchManager.getCalendar();
		calendarRepository.save(calendar2);
		ClockingInfo clockingInfo2 = researchManager.getClockingInfo();
		clockingInfoRepository.save(clockingInfo2);
		ReminderList reminderList2 = researchManager.getReminderList();
		reminderListRepository.save(reminderList2);
		List<CompanyEntity> researchEntities = researchTeam.getCompanyEntities();
		researchEntities.add(researchManager);

		Team businessTeam = new Team("businessTeam", DEPARTMENT.BUSINESS_DEPARTMENT);
		director.constructNameOnly(employeeBuilder, "Lisa");
		Employee businessManager = employeeBuilder.getResult();
		Shift shift3 = businessManager.getShift();
		shiftRepository.save(shift3);
		Calendar calendar3 = businessManager.getCalendar();
		calendarRepository.save(calendar3);
		ClockingInfo clockingInfo3 = businessManager.getClockingInfo();
		clockingInfoRepository.save(clockingInfo3);
		ReminderList reminderList3 = businessManager.getReminderList();
		reminderListRepository.save(reminderList3);
		List<CompanyEntity> businessEntities = businessTeam.getCompanyEntities();
		businessEntities.add(businessManager);

		Team marketingTeam = new Team("marketingTeam", DEPARTMENT.MARKETING_DEPARTMENT);
		director.constructNameOnly(employeeBuilder, "Thomas");
		Employee marketingManager = employeeBuilder.getResult();
		Shift shift4 = marketingManager.getShift();
		shiftRepository.save(shift4);
		Calendar calendar4 = marketingManager.getCalendar();
		calendarRepository.save(calendar4);
		ClockingInfo clockingInfo4 = marketingManager.getClockingInfo();
		clockingInfoRepository.save(clockingInfo4);
		ReminderList reminderList4 = marketingManager.getReminderList();
		reminderListRepository.save(reminderList4);
		List<CompanyEntity> marketingEntities = marketingTeam.getCompanyEntities();
		marketingEntities.add(marketingManager);

		companyEntities.add(researchTeam);
		companyEntities.add(businessTeam);
		companyEntities.add(marketingTeam);

		for(CompanyEntity companyEntity : companyEntities) {
			companyEntityRepository.save(companyEntity);
		}
		companyEntityRepository.save(company);

		return "clock.html";
	}

}
