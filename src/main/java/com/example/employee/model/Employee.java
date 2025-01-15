// src/main/java/com/example/employee/model/Employee.java
package com.example.employee.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "EMPLOYEE_TBL")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employeeId;
    private String employeeName;

    @Enumerated(EnumType.STRING)
    private CapabilityCentre capabilityCentre;

    @Temporal(TemporalType.DATE)
    private Date dateOfJoining;

    @Enumerated(EnumType.STRING)
    private Designation designation;

    private String primarySkill;
    private String secondarySkill;
    private int overallExperience;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "EMPLOYEE_PROJECT_TABLE",
            joinColumns = {
                    @JoinColumn(name = "employee_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "project_id", referencedColumnName = "id")
            }
    )
    //@JsonManagedReference
    @JsonIgnore
    private Set<Project> projects;
}