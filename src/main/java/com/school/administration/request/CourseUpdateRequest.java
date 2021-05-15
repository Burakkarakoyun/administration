package com.school.administration.request;

import lombok.Data;

@Data
public class CourseUpdateRequest {
    private int courseId;
    private String courseName;
    private double ects;
}
