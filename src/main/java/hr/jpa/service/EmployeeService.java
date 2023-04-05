package hr.jpa.service;

import hr.jpa.entity.Employee;
import hr.jpa.repository.EmployeeReps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeReps employeeReps;

    @Autowired
    private DepartmentService departmentService;

    public Optional<Employee> findById(int id){
        return employeeReps.findById(id);
    }

    public Employee insert(Employee employee){

        if(employee.getDepartment() != null){
//            employee.setDepartment(departmentService.findById(employee.getDepartment().getId()));
        }
        return employeeReps.save(employee);
    }


    public Iterable<Employee> findall(){
        return employeeReps.findAll();
    }

    public Employee update(Employee employee){
        Employee currentEmployee = employeeReps.findById(employee.getId()).get();
        currentEmployee.setName(employee.getName());
        currentEmployee.setId(employee.getId());
        currentEmployee.setSalary(employee.getSalary());
        currentEmployee.setDepartment(employee.getDepartment());
        return employeeReps.save(currentEmployee);
    }
    public List<Employee> findByDepartmentId(int id){
        return employeeReps.findByDepartmentId(id);
    }
}