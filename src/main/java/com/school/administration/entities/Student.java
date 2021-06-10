package com.school.administration.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "end_date is null")
@Table(name="student",catalog = "Administration")

public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="student_id",nullable = false)
    @NotNull
    private int studentId;
    @NotEmpty(message = "Öğrenci isim alanı boş bırakılamaz!")
    private String studentName;
    @NotEmpty(message = "Öğrenci soyisim alanı boş bırakılamaz!")
    private String studentSurname;
    private double studentEcts;
    private LocalDate endDate;
}
