package com.example.crud.Config;

import com.example.crud.Dto.EmployeeDto.AddEmployeeDto;
import com.example.crud.Entity.Department;
import com.example.crud.Entity.Employee;
import com.example.crud.Entity.Position;
import com.example.crud.Repository.DepartmentRepository;
import com.example.crud.Repository.EmployeeRepository;
import com.example.crud.Repository.PositionRepository;
import org.springframework.stereotype.Component;

@Component
public class EmployeeFactory {
    private final DepartmentRepository departmentRepository;
    private final PositionRepository positionRepository;
    private final EmployeeRepository employeeRepository;

    public EmployeeFactory(DepartmentRepository departmentRepository, PositionRepository positionRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.positionRepository = positionRepository;
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(AddEmployeeDto addEmployeeDto) {
        Employee employee = EmployeeMapper.toEntity(addEmployeeDto);
        setDepartmentRepository(employee, addEmployeeDto);
        return employee;
    }

    public Employee updateEmployee(AddEmployeeDto dto, int id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found id " + id));
        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        setDepartmentRepository(employee, dto);
        return employee;
    }

    public void setDepartmentRepository(Employee employee, AddEmployeeDto dto) {
        Department department = departmentRepository.findById(dto.getDepartment_id()).orElseThrow(() -> new RuntimeException("Not found id " + dto.getDepartment_id()));
        Position position = positionRepository.findById(dto.getPosition_id()).orElseThrow(() -> new RuntimeException("Not found id " + dto.getPosition_id()));
        employee.setDepartment(department);
        employee.setPosition(position);
    }
}
