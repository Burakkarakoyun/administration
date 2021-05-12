package com.school.administration.service;

import com.school.administration.request.StudentAddRequest;
import com.school.administration.request.StudentUpdateRequest;
import com.school.administration.response.StudentResponse;

import java.util.List;

public interface StudentService {
    List<StudentResponse> listAll();
    StudentResponse save(StudentAddRequest studentAddRequest);
    StudentResponse update(StudentUpdateRequest studentUpdateRequest);
    void delete(Integer studentId);
}
