package hr.jpa.repository;

import hr.jpa.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeReps extends CrudRepository<Employee, Integer> {

}
