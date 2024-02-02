package com.example.springmvc.employee;


import com.example.springmvc.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EmployeeReposiratory extends JpaRepository<Employee,Integer>
{

    //add a method to sort by last name
    public List<Employee> findAllByOrderByLastNameAsc();

}

