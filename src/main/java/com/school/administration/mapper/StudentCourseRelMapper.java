package com.school.administration.mapper;

import com.school.administration.entities.StudentCourseRel;
import com.school.administration.request.StudentAddRequest;
import com.school.administration.request.StudentCourseRelAddRequest;
import com.school.administration.response.StudentCourseRelResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentCourseRelMapper {
    List<StudentCourseRelResponse> toStudentCourseRelResponseList (List<StudentCourseRel> studentCourseRels);
    StudentCourseRelResponse toStudentCourseRelResponse (StudentCourseRel studentCourseRel);
    StudentCourseRel toStudentCourseRel (StudentCourseRelAddRequest studentCourseRelAddRequest);
}
