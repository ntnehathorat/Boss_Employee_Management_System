package com.example.Boss_Employee_Management_System.service.impl;

import com.example.Boss_Employee_Management_System.dto.ResponseDto.BossNameAgeRatingResponseDto;
import com.example.Boss_Employee_Management_System.dto.ResponseDto.EmployeeNameRatingResponseDto;
import com.example.Boss_Employee_Management_System.dto.ResponseDto.EmployeeResponseDto;
import com.example.Boss_Employee_Management_System.dto.requestDto.EmployeeRequestDto;
import com.example.Boss_Employee_Management_System.entity.Boss;
import com.example.Boss_Employee_Management_System.entity.Employee;
import com.example.Boss_Employee_Management_System.exception.BossNotFoundException;
import com.example.Boss_Employee_Management_System.exception.EmployeeNotFoundException;
import com.example.Boss_Employee_Management_System.repository.BossRepository;
import com.example.Boss_Employee_Management_System.repository.EmployeeRepository;
import com.example.Boss_Employee_Management_System.service.EmployeeService;
import com.example.Boss_Employee_Management_System.transformer.BossTransformer;
import com.example.Boss_Employee_Management_System.transformer.EmployeeTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    BossRepository bossRepository;


    @Override
    public EmployeeResponseDto addEmployee(EmployeeRequestDto employeeRequestDto) throws BossNotFoundException {

        Optional<Boss> optionalBoss = bossRepository.findById(employeeRequestDto.getBossId());

        if(!optionalBoss.isPresent())
        {
            throw new BossNotFoundException("Boss Does Not Exist !!");
        }

        Boss boss = optionalBoss.get();

        Employee employee =  EmployeeTransformer.employeeRequestDtoToEmployee(employeeRequestDto,boss);

        employee.setBoss(boss);
        boss.getEmployeeList().add(employee);

        Employee savedEmployee =  employeeRepository.save(employee);
        bossRepository.save(boss);

       return EmployeeTransformer.employeetoEmployeeResponseDto(savedEmployee);

    }

    @Override
    public List <EmployeeNameRatingResponseDto> getEmployeeList() {

        List<Employee> employeeList = employeeRepository.employeeList();

        List<EmployeeNameRatingResponseDto> employeeNameRatingResponseDtoList = new ArrayList<>();

        for(Employee employee : employeeList)
        {
          EmployeeNameRatingResponseDto employeeNameRatingResponseDto= EmployeeTransformer.employeeToEmployeeNameRatingResponseDto(employee);
            employeeNameRatingResponseDtoList.add(employeeNameRatingResponseDto);
        }

        return employeeNameRatingResponseDtoList;
    }

    @Override
    public BossNameAgeRatingResponseDto getBossName(int employeeId) throws EmployeeNotFoundException {

        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);

        if (!optionalEmployee.isPresent()) {
            throw new EmployeeNotFoundException("Employee Dose Not Exist");
        }

        Employee employee = optionalEmployee.get();

        Boss boss = employee.getBoss();

        return BossTransformer.bossTobossNameAgeRatingResponseDto(boss);
    }

    @Override
    public List<EmployeeNameRatingResponseDto> getEmployeesAgeGreaterThanX(int age) {

        List<Employee> employeeList = employeeRepository.employeeList();

        List<EmployeeNameRatingResponseDto> employeeNameRatingResponseDtoList = new ArrayList<>();

        for(Employee employee : employeeList)
        {
            if(employee.getAge() > age)
            {
            EmployeeNameRatingResponseDto employeeNameRatingResponseDto =  EmployeeTransformer.employeeToEmployeeNameRatingResponseDto(employee);
            employeeNameRatingResponseDtoList.add(employeeNameRatingResponseDto);
            }

        }
        return employeeNameRatingResponseDtoList;

    }

    @Override
    public EmployeeResponseDto updateAgeOfEmployeeById(int id, int age) {

        Employee employee = employeeRepository.getEmployById(id);

        employee.setAge(age);
        Employee savedEmployee = employeeRepository.save(employee);

      return   EmployeeTransformer.employeetoEmployeeResponseDto(savedEmployee);
    }

}
