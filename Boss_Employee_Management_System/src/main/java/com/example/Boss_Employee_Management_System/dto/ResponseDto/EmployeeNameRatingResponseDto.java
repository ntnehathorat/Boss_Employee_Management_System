package com.example.Boss_Employee_Management_System.dto.ResponseDto;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class EmployeeNameRatingResponseDto {

    String name;

    double rating;

}
