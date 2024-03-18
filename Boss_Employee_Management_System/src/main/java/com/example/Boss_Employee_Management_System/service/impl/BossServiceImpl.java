package com.example.Boss_Employee_Management_System.service.impl;

import com.example.Boss_Employee_Management_System.dto.ResponseDto.BossNameAgeRatingResponseDto;
import com.example.Boss_Employee_Management_System.dto.ResponseDto.BossNameEmployeeResponseDto;
import com.example.Boss_Employee_Management_System.dto.ResponseDto.BossResponseDto;
import com.example.Boss_Employee_Management_System.dto.ResponseDto.EmployeeNameRatingResponseDto;
import com.example.Boss_Employee_Management_System.dto.requestDto.BossRequestDto;
import com.example.Boss_Employee_Management_System.entity.Boss;
import com.example.Boss_Employee_Management_System.entity.Employee;
import com.example.Boss_Employee_Management_System.exception.BossNotFoundException;
import com.example.Boss_Employee_Management_System.repository.BossRepository;
import com.example.Boss_Employee_Management_System.repository.EmployeeRepository;
import com.example.Boss_Employee_Management_System.service.BossService;
import com.example.Boss_Employee_Management_System.transformer.BossTransformer;
import com.example.Boss_Employee_Management_System.transformer.EmployeeTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class BossServiceImpl implements BossService {


    @Autowired
    BossRepository bossRepository;

    @Autowired
    EmployeeRepository employeeRepository;


    @Override
    public BossResponseDto addBoss(BossRequestDto bossRequestDto) {

        Boss boss = BossTransformer.boosRequestDtoToBoss(bossRequestDto);

        Boss savedBoss = bossRepository.save(boss);

        return BossTransformer.bossToBossResponseDto(savedBoss);
    }

    @Override
    public List<EmployeeNameRatingResponseDto> getEmployeeListByBossId(int bossId) throws BossNotFoundException {

//        Optional<Boss> optionalBoss = bossRepository.findById(bossId);
//
//        if(!optionalBoss.isPresent())
//        {
//            throw  new BossNotFoundException("Boss Does Not Exist !!");
//        }

//        Boss boss = optionalBoss.get();

//        List<EmployeeNameRatingResponseDto> employeeNameRatingResponseDtosList = new ArrayList<>();
//
//        for(Employee employee : boss.getEmployeeList())
//        {
//           EmployeeNameRatingResponseDto employeeNameRatingResponseDto =  EmployeeTransformer.employeeToEmployeeNameRatingResponseDto(employee);
//           employeeNameRatingResponseDtosList.add(employeeNameRatingResponseDto);
//
//        }
//
//        return employeeNameRatingResponseDtosList;

        List<EmployeeNameRatingResponseDto> employeeNameRatingResponseDtosList = new ArrayList<>();
        List<Employee> employeeList =  employeeRepository.listOfEmployee(bossId);

        for(Employee employee : employeeList)
        {
           EmployeeNameRatingResponseDto employeeNameRatingResponseDto =  EmployeeTransformer.employeeToEmployeeNameRatingResponseDto(employee);
           employeeNameRatingResponseDtosList.add(employeeNameRatingResponseDto);

        }
        return employeeNameRatingResponseDtosList;

    }



    @Override
    public List<BossNameAgeRatingResponseDto> getBossList() {

        List<Boss> bossList = bossRepository.bossList();

        List<BossNameAgeRatingResponseDto> bossNameAgeRatingResponseDtosList = new ArrayList<>();

        for(Boss boss : bossList)
        {
         BossNameAgeRatingResponseDto bossNameAgeRatingResponseDto=   BossTransformer.bossTobossNameAgeRatingResponseDto(boss);
         bossNameAgeRatingResponseDtosList.add(bossNameAgeRatingResponseDto);

        }

        return bossNameAgeRatingResponseDtosList;

    }

    @Override
    public List<BossNameEmployeeResponseDto> getBossFromEmployeeCountGreaterThan5() {

        List<Boss> bossList = bossRepository.bossList();

        List<BossNameEmployeeResponseDto> bossNameEmployeeResponseDtoList = new ArrayList<>();

        for(Boss boss : bossList)
        {
            if(boss.getEmployeeList().size() >= 2)
            {
                BossNameEmployeeResponseDto bossNameEmployeeResponseDto = BossTransformer.bossToBossNameEmployeeResponseDto(boss);
                bossNameEmployeeResponseDtoList.add(bossNameEmployeeResponseDto);
            }
        }

        return bossNameEmployeeResponseDtoList;

    }
}
