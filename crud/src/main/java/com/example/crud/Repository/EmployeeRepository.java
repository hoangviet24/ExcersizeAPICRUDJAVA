package com.example.crud.Repository;
import com.example.crud.Dto.EmployeeDto.EmployeeDto;
import com.example.crud.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
