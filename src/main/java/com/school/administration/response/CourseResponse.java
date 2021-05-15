package com.school.administration.response;

import lombok.Data;

@Data
public class CourseResponse {
    private int courseId;
    private String courseName;
    private double ects;
}
