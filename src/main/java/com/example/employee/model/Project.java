// src/main/java/com/example/employee/model/Project.java
package com.example.employee.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "PROJECT_TBL")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private AccountName accountName;
    private String projectName;
    private float allocation;
    private Date projectStartDate;
    private Date projectEndDate;
    private String remarks;

    @ManyToMany(mappedBy = "projects",fetch = FetchType.LAZY)
    //@JsonBackReference
    @JsonIgnore
    private Set<Employee> employees;
}