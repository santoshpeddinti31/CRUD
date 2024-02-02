package com.example.springmvc.rest;


import com.example.springmvc.service.EmployeeService;
import com.example.springmvc.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {


    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService)
    {
        this.employeeService=theEmployeeService;
    }


    @GetMapping("/employees")
    public List<Employee> getAllData()
    {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId)
    {
        Employee theEmployee=employeeService.findById(employeeId);

        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee saveTheEmployee(@RequestBody Employee theEmployee)
    {
        Employee dbEmployee=employeeService.save(theEmployee);

        return dbEmployee;
    }


    @PutMapping("/employees")
    public Employee updateTheEmployee(@RequestBody Employee theEmployee)
    {
       Employee myEmployee= employeeService.save(theEmployee);

        return myEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployeeId(@PathVariable int employeeId)
    {
        Employee theEmployee=employeeService.findById(employeeId);
        employeeService.deleteById(theEmployee.getId());
        return "Employee id is deleted - "+employeeId;
    }

}
