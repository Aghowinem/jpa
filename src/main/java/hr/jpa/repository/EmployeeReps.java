package hr.jpa.repository;

import hr.jpa.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeReps extends JpaRepository<Employee, Integer> {

    @Query()
    List<Employee> findByDepartment(int id);
    List<Employee> findByDepartmentId(int id);


}