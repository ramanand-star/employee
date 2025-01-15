package com.example.employee.controller;

import com.example.employee.model.Employee;
import com.example.employee.repository.ProjectRepository;
import com.example.employee.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ProjectRepository projectRepository;

    @PostMapping(value = "/allocate", consumes = "application/json")
    public void allocateProjectsToEmployee(@RequestBody Employee employee) {
        employeeService.allocateProjectsToEmployee(employee);
    }

    @PostMapping(value = "/addEmployee", consumes = "application/json", produces = "application/json")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }
    //Add a project allocation

    @PutMapping("/allocate")
    public void modifyProjectAllocation(@RequestParam Long employeeId, @RequestParam Long projectId) {
        employeeService.modifyProjectAllocation(employeeId, projectId);
    }
//
//    @GetMapping("/second-most-experienced/{projectName}")
//    public Employee getSecondMostExperienced(@PathVariable String projectName) {
//        return employeeService.getSecondMostExperienced(projectName);
//    }

    //http://localhost:8080/api/employees/skills?primarySkill=Java&secondarySkill=Spring
//    @GetMapping("/skills")
//    public List<Employee> getEmployeesBySkills(@RequestParam String primarySkill, @RequestParam String secondarySkill) {
//        log.info("Primary Skill: " + primarySkill + ", Secondary Skill: " + secondarySkill);
//        return employeeService.getEmployeesBySkills(primarySkill, secondarySkill);
//    }
//
//    @GetMapping("/unallocated/{primarySkill}")
//    public List<Employee> getUnallocatedEmployees(@PathVariable String primarySkill) {
//        return employeeService.getUnallocatedEmployees(primarySkill);
//    }
}