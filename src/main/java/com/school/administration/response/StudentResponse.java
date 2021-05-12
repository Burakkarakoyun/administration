package com.school.administration.response;

import lombok.Data;

@Data
public class StudentResponse {
    private int studentId;
    private String studentName;
    private String studentSurname;
    private double studentEcts;
}
