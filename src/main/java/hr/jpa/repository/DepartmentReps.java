package hr.jpa.repository;

import hr.jpa.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentReps extends JpaRepository<Department,Integer> {
}