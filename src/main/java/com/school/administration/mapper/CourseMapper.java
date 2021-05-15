package com.school.administration.mapper;

import com.school.administration.entities.Course;
import com.school.administration.request.CourseAddRequest;
import com.school.administration.response.CourseResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    List<CourseResponse> toCourseResponseList (List<Course> courses);
    CourseResponse toCourseResponse (Course course);
    Course toCourse (CourseAddRequest courseAddRequest);
}
