package com.example.firstproject.service;

import com.example.firstproject.customException.BusinessException;
import com.example.firstproject.entity.Employee;
import com.example.firstproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {

        try {
            return employeeRepository.findAll();
        }catch (Exception e){
            throw new BusinessException("604","Something went wrong while fetching employee list"+e.getMessage());
        }
    }

    public Employee getEmployeeById(Long id) {
        try {
            return employeeRepository.findById(id).get();
        }catch (java.util.NoSuchElementException e){
            throw new BusinessException("605","Given employee does not exist"+e.getMessage());
        }catch (IllegalArgumentException e){
            throw new BusinessException("606","Given employee ID is null"+e.getMessage());
        }
    }

    public Employee addEmployee(Employee employee) {

        if(employee.getName().isEmpty() || employee.getName().length()==0){
            throw new BusinessException("601","Please send proper name.");
        }
        try {
            return employeeRepository.save(employee);
        }catch (IllegalArgumentException e){
            throw new BusinessException("602","Given employee is null"+e.getMessage());
        }catch (Exception e){
            throw new BusinessException("603","Something went wrong while adding employee"+e.getMessage());
        }
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
