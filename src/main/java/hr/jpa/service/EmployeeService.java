package hr.jpa.service;

import ch.qos.logback.core.pattern.color.BoldBlueCompositeConverter;
import hr.jpa.HRStatisticsProjecion;
import hr.jpa.entity.Employee;
import hr.jpa.projection.EmployeeProjection;
import hr.jpa.repository.EmployeeReps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public Page<EmployeeProjection> filter(String name ,int pageNum, int pageSize, String sortCol, Boolean isAsc) {

        if (name.isEmpty() || name.isBlank() || name == null) {
            name = null;
        }

        // Sort object with List of Order objects.
//		List<Order> orders = new ArrayList<Order>();
//
//		Order order1 = new Order(isAsc ? Direction.ASC : Direction.DESC, sortCol);
//		orders.add(order1);
//
//		Order order2 = new Order(Sort.Direction.ASC, "title");
//		orders.add(order2);

        Pageable page = PageRequest.of(pageNum, pageSize, Sort.by(isAsc ? Sort.Direction.ASC : Sort.Direction.DESC  ,sortCol));

        return employeeReps.filter(name, page);
    }
}