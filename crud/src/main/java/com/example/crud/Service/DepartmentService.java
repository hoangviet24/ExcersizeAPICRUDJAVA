package com.example.crud.Service;

import com.example.crud.Config.DepartmentMapper;
import com.example.crud.Dto.DepartmentDto.DepartmentDto;
import com.example.crud.Entity.Department;
import com.example.crud.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private DepartmentRepository departmentRepository;
    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
    public List<DepartmentDto> getAllDepartment(){
        List<Department> department = departmentRepository.findAll();
        return department.stream().map(DepartmentMapper::toDTO).collect(Collectors.toList());
    }
}
