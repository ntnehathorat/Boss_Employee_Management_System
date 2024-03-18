package com.example.Boss_Employee_Management_System.repository;

import com.example.Boss_Employee_Management_System.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {


    @Query(value = "SELECT * FROM EMPLOYEE", nativeQuery = true)
    List<Employee> employeeList();


    @Query(value = "SELECT * FROM EMPLOYEE WHERE boss_id =:bossId ", nativeQuery = true)
    List<Employee> listOfEmployee(int bossId);


    @Query(value = "SELECT * FROM employee WHERE id=:employeeId " , nativeQuery = true)
    Employee getEmployById(int employeeId);

}
