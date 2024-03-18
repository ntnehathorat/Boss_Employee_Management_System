package com.example.Boss_Employee_Management_System.entity;


import com.example.Boss_Employee_Management_System.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "boss")
@Builder
public class Boss {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    int age;

    @Enumerated(EnumType.STRING)
    Gender gender;

    long salary;

    double rating;

    @OneToMany(mappedBy = "boss",cascade = CascadeType.ALL)
    List<Employee> employeeList = new ArrayList<>();

}
