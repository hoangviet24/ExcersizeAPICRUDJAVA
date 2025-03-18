package com.example.crud.Service;

import com.example.crud.Config.EmployeeFactory;
import com.example.crud.Config.EmployeeMapper;
import com.example.crud.Dto.EmployeeDto.AddEmployeeDto;
import com.example.crud.Dto.EmployeeDto.EmployeeDto;
import com.example.crud.Entity.Employee;
import com.example.crud.Repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.SortedSet;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper mapper;
    private final EmployeeFactory employeeFactory;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper mapper, EmployeeFactory employeeFactory) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
        this.employeeFactory = employeeFactory;
    }

    public List<EmployeeDto> GetAllEmployee(int page, int size,boolean sort, String sortBy) {
        Pageable pageable;
        if(sort){
            Sort sorting = Sort.by(sortBy).descending();
            pageable = PageRequest.of(page,size,sorting);
        }
        else {
            Sort sorting = Sort.by(sortBy).ascending();
            pageable = PageRequest.of(page,size,sorting);

        }
        return employeeRepository.findAll(pageable)
                .stream()
                .map(employee -> mapper.map(employee,EmployeeDto.class))
                .collect(Collectors.toList());
    }

    public EmployeeDto getById(int id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return EmployeeMapper.toDTO(employee);
    }

    public List<EmployeeDto> getByName(String name, int page, int size, boolean sort, String sortBy) {
        Pageable pageable;
        if(sort){
            Sort sorting =  Sort.by(sortBy).descending();
            pageable = PageRequest.of(page,size,sorting);
        }
        else{
            Sort sorting = Sort.by(sortBy).ascending();
            pageable = PageRequest.of(page,size,sorting);
        }
        List<Employee> employee = employeeRepository.findByNameContaining(name,pageable).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return employee.stream()
                .map(emp -> mapper.map(emp, EmployeeDto.class))
                .collect(Collectors.toList());
    }

    public Employee addEmployee(AddEmployeeDto addEmployeeDto) {
        Employee employee = employeeFactory.createEmployee(addEmployeeDto);
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(AddEmployeeDto addEmployeeDto, int id) {
        Employee employee = employeeFactory.updateEmployee(addEmployeeDto, id);
        return employeeRepository.save(employee);
    }

    public Employee delete(int id) {
        employeeRepository.deleteById(id);
        return null;
    }

    public Employee delete() {
        employeeRepository.deleteAll();
        return null;
    }
}
