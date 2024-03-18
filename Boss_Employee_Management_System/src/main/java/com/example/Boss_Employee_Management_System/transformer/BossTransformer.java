package com.example.Boss_Employee_Management_System.transformer;

import com.example.Boss_Employee_Management_System.dto.ResponseDto.BossNameAgeRatingResponseDto;
import com.example.Boss_Employee_Management_System.dto.ResponseDto.BossNameEmployeeResponseDto;
import com.example.Boss_Employee_Management_System.dto.ResponseDto.BossResponseDto;
import com.example.Boss_Employee_Management_System.dto.requestDto.BossRequestDto;
import com.example.Boss_Employee_Management_System.entity.Boss;
import com.example.Boss_Employee_Management_System.entity.Employee;

public class BossTransformer {

    public static Boss boosRequestDtoToBoss(BossRequestDto bossRequestDto)
    {
       return Boss.builder()
                .name(bossRequestDto.getName())
                .age(bossRequestDto.getAge())
                .gender(bossRequestDto.getGender())
                .salary(bossRequestDto.getSalary())
                .rating(bossRequestDto.getRating())
                .build();
    }

    public static BossResponseDto bossToBossResponseDto(Boss boss)
    {
        return BossResponseDto.builder()
                .name(boss.getName())
                .message(boss.getName()+" Added Successfully !!")
                                .build();
    }




    public static BossNameAgeRatingResponseDto bossTobossNameAgeRatingResponseDto(Boss boss)
    {
        return BossNameAgeRatingResponseDto.builder()
                .name(boss.getName())
                .age(boss.getAge())
                .rating(boss.getRating())
                .build();
    }


    public static BossNameEmployeeResponseDto bossToBossNameEmployeeResponseDto(Boss boss)
    {
        return BossNameEmployeeResponseDto.builder()
                .name(boss.getName())
                .employeeCount(boss.getEmployeeList().size())
                .build();
    }
}
