package com.school.administration.request;

import lombok.Data;

@Data
public class StudentCourseRelUpdateRequest {
    private int id;
    private int studentId;
    private int courseId;
}
