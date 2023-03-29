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

    public Employee insert(Employee employee){
        return employeeReps.save(employee);
    }

    public Employee update(Employee employee){
        Employee currentEmployee = employeeReps.findById(employee.getId()).get();
        currentEmployee.setName(employee.getName());
        currentEmployee.setId(employee.getId());
        currentEmployee.setSalary(employee.getSalary());
        currentEmployee.setDepartment(employee.getDepartment());
        return employeeReps.save(currentEmployee);
    }
}
