package com.school.administration.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "end_and date is null")
@Table(name="course_student_rel", catalog = "Administration")

public class StudentCourseRel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    @NotNull
    private int id;
    @NotNull
    private int studentId;
    @NotNull
    private int courseId;
    private LocalDate endDate;
}
