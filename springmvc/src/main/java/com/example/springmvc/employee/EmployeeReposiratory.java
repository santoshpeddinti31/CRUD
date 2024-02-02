package com.example.springmvc.employee;


import com.example.springmvc.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EmployeeReposiratory extends JpaRepository<Employee,Integer>
{

    public List<Employee> findAllByOrderByLastNameAsc();

}

