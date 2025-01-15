package com.example.employee.service;

import com.example.employee.model.Employee;
import com.example.employee.model.Project;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Transactional
    public Employee allocateProjectsToEmployee(Employee employee) {
        Employee managedEmployee = employeeRepository.findById(employee.getId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        // Ensure all projects are managed entities
        Set<Project> managedProjects = employee.getProjects().stream()
                .map(project -> projectRepository.findById(project.getId())
                        .orElseThrow(() -> new RuntimeException("Project not found")))
                .collect(Collectors.toSet());

        // Check if the total number of projects exceeds 3
        if (managedEmployee.getProjects().size() + managedProjects.size() > 3) {
            throw new RuntimeException("Employee cannot be allocated to more than 3 projects");
        }

        managedEmployee.setProjects(managedProjects);
        return employeeRepository.save(managedEmployee);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    @Transactional
    public void modifyProjectAllocation(Long employeeId, Long projectId) {
        // Fetch the employee and project from the database
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project : " +projectId +" not found"));

        // Check if the employee is already allocated to 3 projects
        if (employee.getProjects().size() >= 3) {
            throw new RuntimeException("Employee is already allocated to the maximum number of projects (3)");
        }

        // Check if the project is already associated with the employee
        if (employee.getProjects().contains(project)) {
            throw new RuntimeException("Project is already allocated to the employee");
        }

        // Add the project to the employee's projects
        employee.getProjects().add(project);

        // Save the updated employee
        employeeRepository.save(employee);
    }
}