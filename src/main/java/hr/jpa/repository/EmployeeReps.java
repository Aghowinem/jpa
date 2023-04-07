package hr.jpa.repository;

import hr.jpa.HRStatisticsProjecion;
import hr.jpa.entity.Employee;
import hr.jpa.projection.EmployeeProjection;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
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
    @Query(value = "select emp from #{#entityName} emp where (:empName is null or emp.firstName like :empName)")
    Page<EmployeeProjection> filter(@Param("empName") String name, Pageable pageable);

    //#nativeQuery
    @Query(value = "select (select count(*) from newdb2.hr_department) DeptCount," +
            " (select count(*) from newdb2.employee) EmpCount," +
            "(select count(*) from newdb2.sec_users) UsersCount;",nativeQuery = true)
    HRStatisticsProjecion getHRStatistics();
}