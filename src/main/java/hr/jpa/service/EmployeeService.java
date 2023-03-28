package hr.jpa.service;

import hr.jpa.entity.Employee;
import hr.jpa.repository.EmployeeReps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeReps employeeReps;

    public Optional<Employee> findById(int id){
        return employeeReps.findById(id);
    }



}
