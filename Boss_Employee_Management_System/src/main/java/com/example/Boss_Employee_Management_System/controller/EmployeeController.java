package com.example.Boss_Employee_Management_System.controller;


import com.example.Boss_Employee_Management_System.dto.ResponseDto.BossNameAgeRatingResponseDto;
import com.example.Boss_Employee_Management_System.dto.ResponseDto.EmployeeNameRatingResponseDto;
import com.example.Boss_Employee_Management_System.dto.ResponseDto.EmployeeResponseDto;
import com.example.Boss_Employee_Management_System.dto.requestDto.EmployeeRequestDto;
import com.example.Boss_Employee_Management_System.exception.BossNotFoundException;
import com.example.Boss_Employee_Management_System.exception.EmployeeNotFoundException;
import com.example.Boss_Employee_Management_System.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @PostMapping("/add")
    public ResponseEntity addEmployee(@RequestBody EmployeeRequestDto employeeRequestDto) throws BossNotFoundException {
        EmployeeResponseDto employeeResponseDto = employeeService.addEmployee(employeeRequestDto);
        return new ResponseEntity<>(employeeResponseDto, HttpStatus.CREATED);
    }


    @GetMapping("/get_employee_list")
    public ResponseEntity getEmployeeList()
    {
        List<EmployeeNameRatingResponseDto> employeeNameRatingResponseDtoList = employeeService.getEmployeeList();
        return new ResponseEntity<>(employeeNameRatingResponseDtoList,HttpStatus.FOUND);
    }


    @GetMapping("/find_boss_by_employeeId")
    public  ResponseEntity getBossByEmployeeId(@RequestParam int employeeId) throws EmployeeNotFoundException {
        BossNameAgeRatingResponseDto bossNameAgeRatingResponseDto = employeeService.getBossName(employeeId);
        return new ResponseEntity<>(bossNameAgeRatingResponseDto,HttpStatus.FOUND);
    }

    @GetMapping("/find_employee_age_greater_than_x")
    public ResponseEntity getEmployeeAgeGreaterThanX(@RequestParam int age)
    {
        List<EmployeeNameRatingResponseDto> employeeNameRatingResponseDtoList = employeeService.getEmployeesAgeGreaterThanX(age);
        return new ResponseEntity<>(employeeNameRatingResponseDtoList,HttpStatus.FOUND);
    }

    @PutMapping("/update_age_of_employee_by_id")
    public ResponseEntity  updateAgeOfEmployeeById(@RequestParam int id, @RequestParam int age)
    {
        EmployeeResponseDto employeeResponseDto = employeeService.updateAgeOfEmployeeById(id,age);
        return new ResponseEntity(employeeResponseDto,HttpStatus.ACCEPTED);
    }
}
