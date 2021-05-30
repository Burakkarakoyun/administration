package com.school.administration.response;

import lombok.Data;

@Data
public class StudentCourseRelResponse {
    private int id;
    private int studentId;
    private int courseId;
}
