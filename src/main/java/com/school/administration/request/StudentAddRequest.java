package com.school.administration.request;

import lombok.Data;

@Data
public class StudentAddRequest {

    private String studentName;
    private String studentSurname;
    private double studentEcts;
}
