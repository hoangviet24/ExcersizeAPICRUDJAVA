package com.example.crud.Service;

import com.example.crud.Config.EmployeeMapper;
import com.example.crud.Config.ModelMapperConfig;
import com.example.crud.Dto.EmployeeDto.AddEmployeeDto;
import com.example.crud.Dto.EmployeeDto.EmployeeDto;
import com.example.crud.Entity.Department;
import com.example.crud.Entity.Employee;
import com.example.crud.Entity.Position;
import com.example.crud.Repository.DepartmentRepository;
import com.example.crud.Repository.EmployeeRepository;
import com.example.crud.Repository.PositionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper mapper;
    private final DepartmentRepository departmentRepository;
    private final PositionRepository positionRepository;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper mapper, DepartmentRepository departmentRepository, PositionRepository positionRepository) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
        this.departmentRepository = departmentRepository;
        this.positionRepository = positionRepository;
    }

    public List<EmployeeDto> GetAllEmployee(){
        List <Employee> employee = employeeRepository.findAll();
        return employee.stream()
                .map(emp -> mapper.map(emp,EmployeeDto.class))
                .collect(Collectors.toList());
    }
    public EmployeeDto getById(int id){
        Employee employee = employeeRepository.findById(id).orElse(null);
        return EmployeeMapper.toDTO(employee);
    }
    public Employee addEmployee(AddEmployeeDto addEmployeeDto){
        Employee employee = new Employee();
        employee.setName(addEmployeeDto.getName());
        employee.setEmail((addEmployeeDto.getEmail()));

        Department department = departmentRepository.findById(addEmployeeDto.getDepartment_id()).orElseThrow(() -> new RuntimeException("Department not found"));
        Position position = positionRepository.findById(addEmployeeDto.getPosition_id()).orElseThrow(() -> new RuntimeException("Position not found"));
        employee.setDepartment(department);
        employee.setPosition(position);

        return employeeRepository.save(employee);
    }
    public Employee updateEmployee(AddEmployeeDto addEmployeeDto,int id){
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found by id "+id));
        employee.setName(addEmployeeDto.getName());
        employee.setEmail(addEmployeeDto.getEmail());
        Department department = departmentRepository.findById(addEmployeeDto.getDepartment_id()).orElseThrow(() -> new RuntimeException("Department not found"));
        employee.setDepartment(department);
        Position position = positionRepository.findById(addEmployeeDto.getPosition_id()).orElseThrow(() -> new RuntimeException("Position not found"));
        employee.setPosition(position);

        return employeeRepository.save(employee);
    }
    public Employee delete(int id){
        employeeRepository.deleteById(id);
        return null;
    }
    public Employee delete(){
        employeeRepository.deleteAll();
        return null;
    }
}
