package com.school.administration.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Data
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "end_date is null")
@Table(name = "course",catalog = "Administration")

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="course_id",nullable = false)
    @NotNull
    private int courseId;
    @NotEmpty(message = "İsimsiz Ders olamaz!")
    private String courseName;
    @Min(value = 0,message = "Ortalama 0'dan küçük olamaz!")
    @Max(value = 4, message = "4 ten büyük ortalama olamaz!")
    private double ects;
    private LocalDate endDate;
}
