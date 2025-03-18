package com.example.crud.Service;

import com.example.crud.Config.DepartmentMapper;
import com.example.crud.Dto.DepartmentDto.AddDepartmentDto;
import com.example.crud.Dto.DepartmentDto.DepartmentDto;
import com.example.crud.Entity.Department;
import com.example.crud.Repository.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final ModelMapper mapper;
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper mapper) {
        this.departmentRepository = departmentRepository;
        this.mapper = mapper;
    }

    public List<DepartmentDto> getAllDepartment() {
        List<Department> department = departmentRepository.findAll();
        return department.stream().map(DepartmentMapper::toDTO).collect(Collectors.toList());
    }

    public DepartmentDto getById(int id) {
        Department department = departmentRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return DepartmentMapper.toDTO(department);
    }

    public List<DepartmentDto> getByTitle(String title) {
        List<Department> department = departmentRepository.findByTitleContaining(title).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return department.stream()
                .map(DepartmentMapper::toDTO).collect(Collectors.toList());
    }

    public Department addDepartment(AddDepartmentDto addDepartmentDto) {
        Department department = mapper.map(addDepartmentDto, Department.class);
        return departmentRepository.save(department);
    }

    public Department updateDepartment(AddDepartmentDto addDepartmentDto, int id) {
        return departmentRepository.findById(id).map(department -> {
            mapper.map(addDepartmentDto, department);
            return departmentRepository.save(department);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Department deleteDepartment(int id) {
        departmentRepository.deleteById(id);
        return null;
    }

    public Department deleteAll() {
        departmentRepository.deleteAll();
        return null;
    }
}
