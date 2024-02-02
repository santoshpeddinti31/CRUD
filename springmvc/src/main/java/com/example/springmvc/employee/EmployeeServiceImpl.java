package com.example.springmvc.employee;

import com.example.springmvc.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeReposiratory employeeReposiratory;


    @Autowired
    public EmployeeServiceImpl(EmployeeReposiratory theEmployeeReposiratory)
    {
        this.employeeReposiratory=theEmployeeReposiratory;
    }


    @Override
    public List<Employee> findAll() {
        return employeeReposiratory.findAllByOrderByLastNameAsc();
    }

    @Override
    public Employee findById(int theId) {

        Optional<Employee> theEmployee=employeeReposiratory.findById(theId);

        Employee myEmployee=null;

        if(theEmployee.isPresent())
        {
            myEmployee=theEmployee.get();
        }
        else {

            throw new RuntimeException("Employee id not found - "+theId);
        }

        return myEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {

        Employee dbEmployee=employeeReposiratory.save(theEmployee);
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
        employeeReposiratory.deleteById(theId);
    }
}
