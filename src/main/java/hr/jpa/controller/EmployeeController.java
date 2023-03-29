package hr.jpa.controller;

import hr.jpa.entity.Employee;
import hr.jpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/findall")
    public Iterable<Employee> findall(){
        return employeeService.findall();
    }
    @GetMapping("/findbyid/{id}")
    public Optional<Employee> findById(@PathVariable int id){
        return employeeService.findById(id);
    }
    @PostMapping()
    public int insert(@RequestBody Employee employee){
        Employee Inserted = employeeService.insert(employee);
        return Inserted.getId();
    }

    @PutMapping()
    public Employee update(@RequestBody Employee employee){
        return employeeService.update(employee);
    }

    @GetMapping("/department/{id}")
    public List<Employee> findByDepartmentId(@PathVariable int id){
        return employeeService.findByDepartmentId(id);
    }
}
