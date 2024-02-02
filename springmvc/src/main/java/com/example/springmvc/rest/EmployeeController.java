package com.example.springmvc.rest;


import com.example.springmvc.employee.EmployeeService;
import com.example.springmvc.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService theEmployeeService)
    {
        this.employeeService=theEmployeeService;
    }



    @GetMapping("/list")
    public String listEmployees(Model theModel)
    {
        List<Employee> theEmployee=employeeService.findAll();
        theModel.addAttribute("employees",theEmployee);
        return "employees/list-employees";
    }


    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel)
    {
        Employee theEmployee=new Employee();
        theModel.addAttribute("employee",theEmployee);

        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String postTheData(@ModelAttribute("employee") Employee theEmployee)
    {
        employeeService.save(theEmployee);

        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId,Model theModel)
    {

        Employee myEmployee=employeeService.findById(theId);

        theModel.addAttribute("employee",myEmployee);

        return "employees/employee-form";

    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId)
    {

        employeeService.deleteById(theId);

        return "redirect:/employees/list";
    }

}
