package com.school.administration.service;

import com.school.administration.request.CourseAddRequest;
import com.school.administration.request.CourseUpdateRequest;
import com.school.administration.response.CourseResponse;

import java.util.List;

public interface CourseService {
    List<CourseResponse> listAll();
    CourseResponse save(CourseAddRequest courseAddRequest);
    CourseResponse update(CourseUpdateRequest courseUpdateRequest);
    void delete(Integer courseId);
}
