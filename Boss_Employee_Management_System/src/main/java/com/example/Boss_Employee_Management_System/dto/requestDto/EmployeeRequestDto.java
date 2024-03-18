package com.example.Boss_Employee_Management_System.dto.requestDto;


import com.example.Boss_Employee_Management_System.Enum.Gender;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeRequestDto
{

    int bossId;

    String name;

    int age;

    Gender gender;

    long salary;

    double rating;
}
