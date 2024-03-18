package com.example.Boss_Employee_Management_System.service;

import com.example.Boss_Employee_Management_System.dto.ResponseDto.BossNameAgeRatingResponseDto;
import com.example.Boss_Employee_Management_System.dto.ResponseDto.BossNameEmployeeResponseDto;
import com.example.Boss_Employee_Management_System.dto.ResponseDto.BossResponseDto;
import com.example.Boss_Employee_Management_System.dto.ResponseDto.EmployeeNameRatingResponseDto;
import com.example.Boss_Employee_Management_System.dto.requestDto.BossRequestDto;
import com.example.Boss_Employee_Management_System.exception.BossNotFoundException;

import java.util.List;

public interface BossService {

    public BossResponseDto addBoss(BossRequestDto bossRequestDto);

    public List<EmployeeNameRatingResponseDto> getEmployeeListByBossId(int bossId) throws BossNotFoundException;

    public List<BossNameAgeRatingResponseDto> getBossList();


    public List<BossNameEmployeeResponseDto> getBossFromEmployeeCountGreaterThan5();



}
