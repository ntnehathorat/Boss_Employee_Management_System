package com.example.Boss_Employee_Management_System.dto.ResponseDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class BossNameAgeRatingResponseDto {

    String name;

    int age;

    double rating;

}
