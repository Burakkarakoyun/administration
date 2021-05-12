package com.school.administration.request;

import lombok.Data;

@Data
public class StudentUpdateRequest {
    private int studentId;
    private String studentName;
    private String studentSurname;
    private double studentEcts;
}
