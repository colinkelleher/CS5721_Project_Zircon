package CS5721.project.records.controller;

import CS5721.project.employee.entity.CompanyEntity;
import CS5721.project.employee.service.EmployeeFinderService;
import CS5721.project.records.entity.Records;

import CS5721.project.records.service.RecordsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping(path = "")
public class DisplayAllRecordPageController {
    public final RecordsService recordsService;
    public final EmployeeFinderService employeeFinderService;

    public DisplayAllRecordPageController(RecordsService recordsService, EmployeeFinderService employeeFinderService){
        this.recordsService = recordsService;
        this.employeeFinderService = employeeFinderService;
    }

    @GetMapping(path = "/records")
    public String recordsPage(Model model , @RequestParam Long employeeId) {
        CompanyEntity employee = employeeFinderService.execute(employeeId);
        String employeeName = employee.getName();
        //ArrayList<Records> records = recordsService.findAllRecords();
        ArrayList<Records> records = recordsService.findEmployeeRecords(employeeId);
        model.addAttribute("employeeName",employeeName);
        model.addAttribute("employeeId", employeeId);
        model.addAttribute("records",records);
        return "records.html";

    }
}
