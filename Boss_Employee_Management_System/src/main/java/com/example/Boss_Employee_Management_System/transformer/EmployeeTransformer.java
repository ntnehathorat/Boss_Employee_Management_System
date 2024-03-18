package com.example.Boss_Employee_Management_System.transformer;

import com.example.Boss_Employee_Management_System.dto.ResponseDto.EmployeeNameRatingResponseDto;
import com.example.Boss_Employee_Management_System.dto.ResponseDto.EmployeeResponseDto;
import com.example.Boss_Employee_Management_System.dto.requestDto.EmployeeRequestDto;
import com.example.Boss_Employee_Management_System.entity.Boss;
import com.example.Boss_Employee_Management_System.entity.Employee;

public class EmployeeTransformer {

    public static Employee employeeRequestDtoToEmployee(EmployeeRequestDto employeeRequestDto,Boss boss)
    {
       return Employee.builder()
               .boss(boss)
               .name(employeeRequestDto.getName())
               .age(employeeRequestDto.getAge())
               .salary(employeeRequestDto.getSalary())
               .rating(employeeRequestDto.getRating())
               .gender(employeeRequestDto.getGender())
               .build();
    }

    public static EmployeeResponseDto employeetoEmployeeResponseDto(Employee employee)
    {
        return EmployeeResponseDto.builder()
                .message(employee.getName()+" Age Updated  Successfully !!")
                .build();
    }


    public static EmployeeNameRatingResponseDto employeeToEmployeeNameRatingResponseDto(Employee employee)
    {
        return EmployeeNameRatingResponseDto.builder()
                .name(employee.getName())
                .rating(employee.getRating())
                .build();
    }


}
