package com.school.administration.service;

import com.school.administration.request.StudentCourseRelAddRequest;
import com.school.administration.request.StudentCourseRelUpdateRequest;
import com.school.administration.response.StudentCourseRelResponse;

import java.util.List;

public interface StudenCourseRelService {
    List<StudentCourseRelResponse> listAll();
    StudentCourseRelResponse save(StudentCourseRelAddRequest studentCourseRelAddRequest);
    StudentCourseRelResponse update(StudentCourseRelUpdateRequest studentCourseRelUpdateRequest);
    void delete(Integer studentCourseRelId);
}
