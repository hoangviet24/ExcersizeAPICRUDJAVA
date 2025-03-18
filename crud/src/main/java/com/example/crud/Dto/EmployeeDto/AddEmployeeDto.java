package com.example.crud.Dto.EmployeeDto;

public class AddEmployeeDto {
    private String name;
    private String email;
    private int department_id;
    private int position_id;

    public AddEmployeeDto() {
    }

    public AddEmployeeDto(String name, String email, int departmentId, int positionId) {
        this.name = name;
        this.email = email;
        department_id = departmentId;
        position_id = positionId;
    }

    public int getPosition_id() {
        return position_id;
    }

    public void setPosition_id(int position_id) {
        this.position_id = position_id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
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
}
