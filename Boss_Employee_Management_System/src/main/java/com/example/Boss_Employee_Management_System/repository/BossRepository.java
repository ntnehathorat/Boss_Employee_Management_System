package com.example.Boss_Employee_Management_System.repository;

import com.example.Boss_Employee_Management_System.entity.Boss;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BossRepository extends JpaRepository<Boss,Integer> {

    @Query(value = "SELECT * FROM BOSS" , nativeQuery = true)
    List<Boss> bossList();


}
