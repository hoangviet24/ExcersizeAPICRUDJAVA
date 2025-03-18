package com.example.crud.Repository;

import com.example.crud.Entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<List<Employee>> findByNameContaining(String name, Pageable pageable);
    Page<Employee> findAll(Pageable pageable);
}
