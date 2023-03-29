package hr.jpa.repository;

import hr.jpa.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeReps extends CrudRepository<Employee, Integer> {

    @Query()
    public List<Employee> findByDepartment(int id);
    public List<Employee> findByDepartmentId(int id);
}
