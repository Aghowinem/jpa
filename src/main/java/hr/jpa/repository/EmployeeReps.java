package hr.jpa.repository;

import hr.jpa.HRStatisticsProjecion;
import hr.jpa.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeReps extends JpaRepository<Employee, Integer> {

    @Query()
    List<Employee> findByDepartment(int id);
    List<Employee> findByDepartmentId(int id);

    //#JPQL
    @Query(value = "select emp from Employee emp where (emp.firstName = :name)")
    List<Employee> filter(String name, Pageable sort );

    //#nativeQuery
    @Query(value = "select (select count(*) from newdb2.hr_department) DeptCount," +
            " (select count(*) from newdb2.employee) EmpCount," +
            "(select count(*) from newdb2.sec_users) UsersCount;",nativeQuery = true)
    HRStatisticsProjecion getHRStatistics();
}