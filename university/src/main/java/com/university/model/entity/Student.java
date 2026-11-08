package com.university.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "the name must nut null")
    @Size(min = 2, max =30 , message = "The name must be between 2 and 30 characters long.")
    private String name;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    @NotNull(message = "the age must nut null")
    @Min(value = 18,message = "the age is small")
    @Max(value = 60,message = "the age is big")
    @Positive(message = "the age must be positive")
    private Integer age;
    @Email
    @NotBlank
    @Column(unique = true)
    private String email;

}
