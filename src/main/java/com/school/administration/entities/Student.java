package com.school.administration.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Where;

import javax.persistence.*;
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

    private int studentId;
    private String studentName;
    private String studentSurname;
    private double studentEcts;
    private LocalDate endDate;

}
