package com.example.Boss_Employee_Management_System.service;

import com.example.Boss_Employee_Management_System.dto.ResponseDto.BossNameAgeRatingResponseDto;
import com.example.Boss_Employee_Management_System.dto.ResponseDto.BossResponseDto;
import com.example.Boss_Employee_Management_System.dto.ResponseDto.EmployeeNameRatingResponseDto;
import com.example.Boss_Employee_Management_System.dto.ResponseDto.EmployeeResponseDto;
import com.example.Boss_Employee_Management_System.dto.requestDto.EmployeeRequestDto;
import com.example.Boss_Employee_Management_System.exception.BossNotFoundException;
import com.example.Boss_Employee_Management_System.exception.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeService {

    public EmployeeResponseDto addEmployee(EmployeeRequestDto employeeRequestDto) throws BossNotFoundException;


   public List<EmployeeNameRatingResponseDto> getEmployeeList();

   public BossNameAgeRatingResponseDto getBossName(int employeeId) throws EmployeeNotFoundException;

   public List<EmployeeNameRatingResponseDto> getEmployeesAgeGreaterThanX(int age);

   public EmployeeResponseDto updateAgeOfEmployeeById(int id,int age);
}
