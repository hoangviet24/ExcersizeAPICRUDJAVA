package com.example.crud.Config;

import com.example.crud.Dto.EmployeeDto.AddEmployeeDto;
import com.example.crud.Dto.EmployeeDto.EmployeeDto;
import com.example.crud.Entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto toDTO(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getDepartment() != null ? employee.getDepartment() : null,
                employee.getPosition() != null ? employee.getPosition() : null
        );
    }

    public static Employee toEntity(AddEmployeeDto addEmployeeDto) {
        Employee employee = new Employee();
        employee.setName(addEmployeeDto.getName());
        employee.setEmail(addEmployeeDto.getEmail());
        return employee;
    }
}
