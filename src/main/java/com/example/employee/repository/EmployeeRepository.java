// src/main/java/com/example/employee/repository/EmployeeRepository.java
package com.example.employee.repository;

import com.example.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//    List<Employee> findByProjects_ProjectAllocations_Project_ProjectNameOrderByOverallExperienceDesc(String projectName);
//    List<Employee> findByPrimarySkillAndSecondarySkill(String primarySkill, String secondarySkill);
//    List<Employee> findUnallocatedEmployeesByPrimarySkill(String primarySkill);
//    List<Employee> findByEmployeename(String name);
}