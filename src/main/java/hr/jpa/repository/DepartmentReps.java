package hr.jpa.repository;

import hr.jpa.entity.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentReps extends CrudRepository<Department,Integer> {
}
