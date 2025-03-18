package com.example.crud.Controller;

import com.example.crud.Dto.EmployeeDto.AddEmployeeDto;
import com.example.crud.Dto.EmployeeDto.EmployeeDto;
import com.example.crud.Entity.Employee;
import com.example.crud.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/GetAll")
    public List<EmployeeDto> getAll(
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "5") int size,
                                    @RequestParam(defaultValue = "false") boolean sort,
                                    @RequestParam(defaultValue = "name") String sortBy
                                   ) {
        if(name != null){
            return getByName(name,page,size,sort,sortBy);
        }
        else{
            return employeeService.GetAllEmployee(page,size,sort,sortBy);
        }
    }
    @GetMapping("/findById/{id}")
    public EmployeeDto getById(@PathVariable int id) {
        return employeeService.getById(id);
    }

    @PostMapping()
    public Employee addEmployeeDto(@RequestBody AddEmployeeDto addEmployeeDto) {
        return employeeService.addEmployee(addEmployeeDto);
    }

    @DeleteMapping("/Delete/{id}")
    public Employee deleteId(@PathVariable int id) {
        return employeeService.delete(id);
    }

    @DeleteMapping("/DeleteAll")
    public Employee delete() {
        return employeeService.delete();
    }

    @PutMapping("/Update/{id}")
    public Employee update(@RequestBody AddEmployeeDto addEmployeeDto, @PathVariable int id) {
        return employeeService.updateEmployee(addEmployeeDto, id);
    }

    @GetMapping("/getByname/{name}")
    public List<EmployeeDto> getByName(String name,
                                       @RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "1") int size,
                                       @RequestParam(defaultValue = "false") boolean sort,
                                       @RequestParam(defaultValue = "name") String sortBy) {
        return employeeService.getByName(name,page,size,sort,sortBy);
    }
}
