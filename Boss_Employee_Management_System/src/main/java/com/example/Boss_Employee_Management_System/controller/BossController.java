package com.example.Boss_Employee_Management_System.controller;

import com.example.Boss_Employee_Management_System.Enum.Gender;
import com.example.Boss_Employee_Management_System.dto.ResponseDto.BossNameAgeRatingResponseDto;
import com.example.Boss_Employee_Management_System.dto.ResponseDto.BossNameEmployeeResponseDto;
import com.example.Boss_Employee_Management_System.dto.ResponseDto.BossResponseDto;
import com.example.Boss_Employee_Management_System.dto.ResponseDto.EmployeeNameRatingResponseDto;
import com.example.Boss_Employee_Management_System.dto.requestDto.BossRequestDto;
import com.example.Boss_Employee_Management_System.exception.BossNotFoundException;
import com.example.Boss_Employee_Management_System.service.BossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boss")
public class BossController {

    @Autowired
    BossService bossService;


    @PostMapping("/add")
    public ResponseEntity addBoss(@RequestBody BossRequestDto bossRequestDto)
    {
        BossResponseDto bossResponseDto = bossService.addBoss(bossRequestDto);

        return new ResponseEntity<>(bossResponseDto, HttpStatus.CREATED);
    }


    @GetMapping("/get_employee_list_by_bossId")
    public  ResponseEntity getEmployeeListByBossId(@RequestParam int bossId) throws BossNotFoundException {
        List<EmployeeNameRatingResponseDto> employeeNameRatingResponseDtoList = bossService.getEmployeeListByBossId(bossId);

        return new ResponseEntity<>(employeeNameRatingResponseDtoList,HttpStatus.FOUND);
    }


    @GetMapping("/get_boss_list")
  public ResponseEntity getBossList()
    {
        List<BossNameAgeRatingResponseDto> bossNameAgeRatingResponseDtoList = bossService.getBossList();
        return new ResponseEntity<>(bossNameAgeRatingResponseDtoList,HttpStatus.CREATED);
    }


    @GetMapping("/get_boss_by_employee_count")
    public  ResponseEntity getBossFromEmployeeCount()
    {
        List<BossNameEmployeeResponseDto> bossNameEmployeeResponseDtoList = bossService.getBossFromEmployeeCountGreaterThan5();
        return new ResponseEntity<>(bossNameEmployeeResponseDtoList,HttpStatus.FOUND);
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

}
