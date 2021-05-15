package com.school.administration.request;

import lombok.Data;

@Data
public class CourseAddRequest {
    private double ects;
    private String courseName;
}
