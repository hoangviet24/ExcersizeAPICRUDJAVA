package com.example.crud.Controller;

import com.example.crud.Dto.EmployeeDto.AddEmployeeDto;
import com.example.crud.Dto.EmployeeDto.EmployeeDto;
import com.example.crud.Entity.Employee;
import com.example.crud.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private static final String UPLOAD_DIR = "uploads/";
    private final EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public List<EmployeeDto> getAll(){
        return employeeService.GetAllEmployee();
    }
    @GetMapping("/{id}")
    public EmployeeDto getById(@PathVariable int id){
        return employeeService.getById(id);
    }
    @PostMapping()
    public Employee addEmployeeDto(@RequestBody AddEmployeeDto addEmployeeDto){
        return employeeService.addEmployee(addEmployeeDto);
    }
    @DeleteMapping("/{id}")
    public Employee deleteId(@PathVariable int id){
        return employeeService.delete(id);
    }
    @DeleteMapping()
    public Employee delete(){
        return employeeService.delete();
    }
    @PutMapping("/{id}")
    public Employee update(@RequestBody AddEmployeeDto addEmployeeDto,@PathVariable int id){
        return employeeService.updateEmployee(addEmployeeDto,id);
    }

}
