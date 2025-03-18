package com.example.crud.Controller;

import com.example.crud.Dto.DepartmentDto.AddDepartmentDto;
import com.example.crud.Dto.DepartmentDto.DepartmentDto;
import com.example.crud.Entity.Department;
import com.example.crud.Service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/getAll")
    public List<DepartmentDto> getAll() {
        return departmentService.getAllDepartment();
    }

    @GetMapping("/getById/{id}")
    public DepartmentDto getById(@PathVariable int id) {
        return departmentService.getById(id);
    }

    @GetMapping("/getName/{name}")
    public List<DepartmentDto> getByName(@PathVariable String name) {
        return departmentService.getByTitle(name);
    }

    @PostMapping("/Post")
    public Department addDepartment(@RequestBody AddDepartmentDto dto) {
        return departmentService.addDepartment(dto);
    }

    @PutMapping("/Update/{id}")
    public Department update(@PathVariable int id, @RequestBody AddDepartmentDto dto) {
        return departmentService.updateDepartment(dto, id);
    }

    @DeleteMapping("/Delete/{id}")
    public Department deleteById(@PathVariable int id) {
        return departmentService.deleteDepartment(id);
    }

    @DeleteMapping("/DeleteAll")
    public Department delete() {
        return departmentService.deleteAll();
    }
}
