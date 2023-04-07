package hr.jpa.controller;

import hr.jpa.HRStatisticsProjecion;
import hr.jpa.entity.Employee;
import hr.jpa.entity.EmployeeResponse;
import hr.jpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
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
    public EmployeeResponse findById(@PathVariable int id){
        Optional<Employee> emp = employeeService.findById(id);
        EmployeeResponse res = new EmployeeResponse();
        res.setId(emp.get().getId());
        res.setName(emp.get().getFirstName());
        res.setDepartment(emp.orElseThrow().getDepartment());
        res.setUser(emp.get().getUser());
        return res;
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

    @GetMapping("/statistics")
    public ResponseEntity<?> getHRStatistics(){
        return ResponseEntity.ok(employeeService.getHRStatistics());
    }

    @GetMapping("/filter")
    public ResponseEntity<?> filter(@RequestParam String name, @RequestParam int pageNumber, @RequestParam int pageSize, @RequestParam String sortCol, @RequestParam Boolean isAsc){
        return ResponseEntity.ok(employeeService.filter(name, pageNumber, pageSize, sortCol, isAsc));
    }
}