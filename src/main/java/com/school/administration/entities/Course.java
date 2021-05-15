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
@Table(name = "course",catalog = "Administration")

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="course_id",nullable = false)
    private int courseId;
    private String courseName;
    private double ects;
    private LocalDate endDate;
}
