package com.example.crud.Config;

import com.example.crud.Dto.DepartmentDto.DepartmentDto;
import com.example.crud.Entity.Department;
import com.example.crud.Entity.Employee;

import java.util.stream.Collectors;

public class DepartmentMapper {
    public static DepartmentDto toDTO(Department department) {
        return new DepartmentDto(
                department.getId(),
                department.getTitle(),
                department.getEmployeeList() != null ? department.getEmployeeList().stream().map(Employee::getName).collect(Collectors.toList()) : null
        );
    }
}
