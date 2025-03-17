package com.example.crud.Controller;

import com.example.crud.Dto.DepartmentDto.DepartmentDto;
import com.example.crud.Service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("departments")
public class DepartmentController {
    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping()
    public List<DepartmentDto> getAll(){
        return departmentService.getAllDepartment();
    }
}
