package com.example.crud.Dto.EmployeeDto;

public class EmployeeDto {
    private int id;
    private String name;
    private String email;
    private String department;
    private String position;

    public EmployeeDto() {
    }

    public EmployeeDto(int id, String name, String email, String department, String position) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
