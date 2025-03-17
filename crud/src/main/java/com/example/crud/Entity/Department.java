package com.example.crud.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "departments")

public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
    private List<Employee> employeeList;
    public Department(){}
    public Department(int id, String title, List<Employee> employeeList) {
        this.id = id;
        this.title = title;
        this.employeeList = employeeList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
