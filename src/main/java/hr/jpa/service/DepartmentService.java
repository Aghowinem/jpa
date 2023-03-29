package hr.jpa.service;

import hr.jpa.entity.Department;
import hr.jpa.entity.Employee;
import hr.jpa.repository.DepartmentReps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentReps departmentReps;

    public Optional<Department> findById(int id){
        return departmentReps.findById(id);
    }
    public Department update(Department department){

        Department currentDepartment = departmentReps.findById(department.getId()).get();
        
        currentDepartment.setName(department.getName());
        return departmentReps.save(currentDepartment);
    }
}
