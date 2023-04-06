package hr.jpa.service;

import ch.qos.logback.core.pattern.color.BoldBlueCompositeConverter;
import hr.jpa.HRStatisticsProjecion;
import hr.jpa.entity.Employee;
import hr.jpa.repository.EmployeeReps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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


        return employeeReps.save(employee);
    }


    public Iterable<Employee> findall(){
        return employeeReps.findAll();
    }

    public Employee update(Employee employee){
        Employee currentEmployee = employeeReps.findById(employee.getId()).get();
        currentEmployee.setFirstName(employee.getFirstName());
        currentEmployee.setLastName(employee.getLastName());
        currentEmployee.setId(employee.getId());
        currentEmployee.setSalary(employee.getSalary());
        currentEmployee.setDepartment(employee.getDepartment());
        return employeeReps.save(currentEmployee);
    }
    public List<Employee> findByDepartmentId(int id){
        return employeeReps.findByDepartmentId(id);
    }

    public HRStatisticsProjecion getHRStatistics(){
        return employeeReps.getHRStatistics();
    }
    public List<Employee> filter(String name, int pageNumber, int pageSize, String sortCol, Boolean isAsc){
        if(name.isEmpty() || name.isBlank() || name == null){
            System.out.println("NULLLLLLLLLLLL");
        }
        Pageable page = PageRequest.of(pageNumber,pageSize,Sort.by(isAsc ? Sort.Direction.ASC : Sort.Direction.DESC,sortCol));
        return employeeReps.filter(name, page);
    }
}