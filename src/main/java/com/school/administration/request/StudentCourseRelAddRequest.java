package com.school.administration.request;

import lombok.Data;

@Data
public class StudentCourseRelAddRequest {
    private int studentId;
    private int courseId;
}
